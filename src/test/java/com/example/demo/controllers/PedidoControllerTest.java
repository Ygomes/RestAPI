package com.example.demo.controllers;

import com.example.demo.controllers.entity.Status;
import com.example.demo.model.ResponseCommand;
import com.example.demo.service.PedidoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PedidoControllerTest {


    //private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PedidoService pedidoService;

    @Test
    void itShouldgetPedido() throws Exception {
        mockMvc.perform(get("/api/pedido").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldsetNewStatus() throws Exception {
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").accept(MediaType.APPLICATION_JSON)
                        .content("{\"status\":\"APROVADO\",\"itensAprovados\":3,\"valorAprovado\":20,\"pedido\":\"" + 123456 + "\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..status", Matchers.contains("APROVADO")));

    }
}