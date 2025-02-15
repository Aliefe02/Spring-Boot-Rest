package com.springframework.restmvc.repositories;

import com.springframework.restmvc.bootstrap.BootstrapData;
import com.springframework.restmvc.entities.Beer;
import com.springframework.restmvc.model.BeerStyle;
import com.springframework.restmvc.services.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
@ActiveProfiles("test")
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName() {
        Page<Beer> page = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(page.getNumberOfElements()).isEqualTo(25);
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder().beerName("My Beer")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("123123")
                        .price(new BigDecimal("11.99"))
                .build());

        beerRepository.flush();
        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }

    @Test
    void testSaveBeerTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder().beerName("My Bee08574243548749804283109321Bee0857424354874980428310932")
                            .beerStyle(BeerStyle.PALE_ALE)
                            .upc("123123")
                            .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();

        });

    }
}