package one.digitalinnovation.beerstock.service;

import one.digitalinnovation.beerstock.builder.BeerBuilder;
import one.digitalinnovation.beerstock.entity.Beer;
import one.digitalinnovation.beerstock.exception.BeerStockExceededException;
import one.digitalinnovation.beerstock.repository.BeerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BeerServiceBusinessRulesTest {

    @Mock
    private BeerRepository beerRepository;

    @InjectMocks
    private BeerService beerService;

    private Beer beer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        beer = BeerBuilder.builder().build().toBeer();
        beer.setId(1L);
    }

    // Cenário negativo: incremento acima do máximo
    @Test
    void shouldThrowException_whenIncrementExceedsMaxStock() {
        beer.setQuantity(50);
        beer.setMax(60);

        when(beerRepository.findById(beer.getId())).thenReturn(Optional.of(beer));

        assertThrows(BeerStockExceededException.class, () ->
            beerService.increment(beer.getId(), 20)
        );

        verify(beerRepository, never()).save(any(Beer.class));
    }

    // Cenário negativo: decremento abaixo de zero
    @Test
    void shouldThrowException_whenDecrementResultsInNegativeStock() {
        beer.setQuantity(5);

        when(beerRepository.findById(beer.getId())).thenReturn(Optional.of(beer));

        assertThrows(BeerStockExceededException.class, () ->
            beerService.decrement(beer.getId(), 10)
        );

        verify(beerRepository, never()).save(any(Beer.class));
    }

    // Cenário positivo: incremento válido
    @Test
    void shouldUpdateQuantity_whenIncrementIsWithinLimit() throws BeerStockExceededException {
        beer.setQuantity(50);
        beer.setMax(60);

        when(beerRepository.findById(beer.getId())).thenReturn(Optional.of(beer));

        beerService.increment(beer.getId(), 5);

        assertEquals(55, beer.getQuantity());
        verify(beerRepository).save(beer);
    }

    // Cenário positivo: decremento válido
    @Test
    void shouldUpdateQuantity_whenDecrementIsValid() throws BeerStockExceededException {
        beer.setQuantity(10);

        when(beerRepository.findById(beer.getId())).thenReturn(Optional.of(beer));

        beerService.decrement(beer.getId(), 5);

        assertEquals(5, beer.getQuantity());
        verify(beerRepository).save(beer);
    }
}
