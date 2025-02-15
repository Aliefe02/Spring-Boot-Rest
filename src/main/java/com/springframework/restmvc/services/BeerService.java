package com.springframework.restmvc.services;

import com.springframework.restmvc.model.BeerDTO;
import com.springframework.restmvc.model.BeerStyle;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Page<BeerDTO> listBeer(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateById(UUID beerId, BeerDTO beer);

    boolean deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);
}
