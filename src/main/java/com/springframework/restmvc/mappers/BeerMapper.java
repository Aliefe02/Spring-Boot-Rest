package com.springframework.restmvc.mappers;

import com.springframework.restmvc.entities.Beer;
import com.springframework.restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

}
