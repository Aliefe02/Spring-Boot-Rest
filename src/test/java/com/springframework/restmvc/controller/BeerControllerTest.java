//package com.springframework.restmvc.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.springframework.restmvc.model.BeerDTO;
//import com.springframework.restmvc.services.BeerService;
//import com.springframework.restmvc.services.BeerServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.hamcrest.core.Is.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.mock;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(BeerController.class)
//class BeerControllerTest {
//
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @MockitoBean
//    BeerService beerService;
//
//    BeerServiceImpl beerServiceImpl;
//
//    @BeforeEach
//    void setUp() {
//        beerServiceImpl = new BeerServiceImpl();
//    }
//
//    @Test
//    void testCreateBeerNullBeerName() throws Exception {
//        BeerDTO beerDTO = BeerDTO.builder().build();
//        given(beerService.saveNewBeer(any(BeerDTO.class))).willReturn(beerServiceImpl.listBeer(null, null, false, 1, 25).getFirst());
//
//        MvcResult mvcResult = mockMvc.perform(post(BeerController.BEER_PATH)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(beerDTO)))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.length()", is(6)))
//                .andReturn();
//
//        System.out.println(mvcResult.getResponse().getContentAsString());
//
//
//    }
//
//    @Test
//    void getBeerByIdNotFound() throws Exception {
//        given(beerService.getBeerById(any(UUID.class))).willReturn(Optional.empty());
//
//        mockMvc.perform(get(BeerController.BEER_PATH_ID, UUID.randomUUID()))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void testCreateNewBeer() throws Exception {
//
//        BeerDTO beer = beerServiceImpl.listBeer(null, null, false, 1, 25).getFirst();
////        beer.setVersion(null);
////        beer.setId(null);
//        given(beerService.saveNewBeer(any(BeerDTO.class))).willReturn(beerServiceImpl.listBeer(null, null, false, 1, 25).getFirst());
//
//        mockMvc.perform(post(BeerController.BEER_PATH)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(beer)))
//                .andExpect(status().isCreated())
//                .andExpect(header().exists("Location"));
//    }
//
//    @Test
//    void testListBeers() throws Exception {
//        given(beerService.listBeer(null, null, false, 1, 25)).willReturn(beerServiceImpl.listBeer(null, null, false, 1, 25));
//
//        mockMvc.perform(get(BeerController.BEER_PATH)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.length()", is(3)));
//    }
//
//    @Test
//    void getBeerById() throws Exception {
//
//        BeerDTO testBeer = beerServiceImpl.listBeer(null, null, false, 1, 25).getFirst();
//        given(beerService.getBeerById(testBeer.getId())).willReturn(Optional.of(testBeer));
//
//        mockMvc.perform((get(BeerController.BEER_PATH_ID, testBeer.getId()))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(testBeer.getId().toString())))
//                .andExpect(jsonPath("$.beerName", is(testBeer.getBeerName())));
//
//
//    }
//}