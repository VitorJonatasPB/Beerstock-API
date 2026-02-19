package one.digitalinnovation.beerstock.service;

import one.digitalinnovation.beerstock.mapper.BeerMapper;
import one.digitalinnovation.beerstock.repository.BeerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BeerServiceTest {

    @Mock
    private BeerRepository beerRepository;

    @Mock
    private BeerMapper beerMapper; // agora você injeta o mapper como mock

    @InjectMocks
    private BeerService beerService; // o service recebe os mocks

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // inicializa mocks
    }

    @Test
    void whenBeerInformedThenItShouldBeCreated() throws Exception {
        // Aqui você usa beerMapper mockado, não INSTANCE
    }

    // demais testes seguem o mesmo padrão
}
