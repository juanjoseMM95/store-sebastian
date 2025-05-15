package com.store.store.mockmvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.store.controller.OrderController;
import com.store.store.dto.OrderDTO;
import com.store.store.service.OrderService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

//para probar toda la aplicaciòn y sube todo spring

//pruebas unitarias
@WebMvcTest(OrderController.class)
public class OrderMockMvcTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    OrderService orderService;

    @Test
    void TestGetMethod() throws Exception{
        when(orderService.getOrders()).thenReturn(List.of(new OrderDTO()));
        this.mockMvc.perform(get("/api/orders")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void TestPostMethod() throws Exception{
        // OrderDTO orderDTO = new OrderDTO();
        // when(orderService.saveOrder(orderDTO)).thenReturn(orderDTO);
        when(orderService.saveOrder(any())).thenReturn(new OrderDTO());
        String bodyReq = new ObjectMapper().writeValueAsString(new OrderDTO( 1l, "Order client id", null ));
        MvcResult mvcResult = this.mockMvc.perform(post("/api/orders")
        .contentType(MediaType.APPLICATION_JSON).content(bodyReq)).andDo(print()).andExpect(status().isCreated())
        .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString(), is(not(emptyString())));
    }

}
