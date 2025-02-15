package com.springframework.restmvc.repositories;

import com.springframework.restmvc.entities.Beer;
import com.springframework.restmvc.entities.BeerOrder;
import com.springframework.restmvc.entities.BeerOrderShipment;
import com.springframework.restmvc.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerOrderRepositoryTest {

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Customer testCustomer;
    Beer beer;

    @BeforeEach
    void setUp() {
        testCustomer = customerRepository.findAll().getFirst();
        beer = beerRepository.findAll().getFirst();
    }

    @Transactional
    @Test
    void testBeerOrders() {
        BeerOrder beerOrder = BeerOrder.builder()
                .customerRef("Test order")
                .customer(testCustomer)
                .beerOrderShipment(BeerOrderShipment.builder()
                        .trackingNumber("123r")
                        .build())
                .build();

        BeerOrder savedBeerOrder = beerOrderRepository.save(beerOrder);

        System.out.println(beerOrder.getBeerOrderShipment().getId());

        System.out.println(savedBeerOrder.getId() + ": " + savedBeerOrder.getCustomer().getBeerOrders().size());

    }
}


















