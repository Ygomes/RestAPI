package com.example.demo.controllers;

import com.example.demo.entity.Status;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PedidoControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void itShouldgetPedido() throws Exception {
        mockMvc.perform(get("/api/pedido").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    String pedido = "123456";
    Status getNewStatus = new Status("APROVADO", 3, 20, pedido);

    @Test
    void itShouldsetNewStatusInvalido() throws Exception {
        getNewStatus.setPedido("1234KlmN");
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.contains("CODIGO_PEDIDO_INVALIDO")));
    }


    @Test
    void itShouldsetNewStatusToAprovado() throws Exception {
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                        .andExpect(jsonPath("$.status", Matchers.contains("APROVADO")));
    }

    @Test
    void itShouldsetNewStatusToReprovado() throws Exception {
        getNewStatus.setStatus("REPROVADO");
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.contains("REPROVADO")));
    }

    @Test
    void itShouldsetNewStatusToVMaior() throws Exception {
        getNewStatus.setValorAprovado(21);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.contains("APROVADO_VALOR_A_MAIOR")));
    }

    @Test
    void itShouldsetNewStatusToVMenor() throws Exception {
        getNewStatus.setValorAprovado(19);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.contains("APROVADO_VALOR_A_MENOR")));
    }

    @Test
    void itShouldsetNewStatusToQMaior() throws Exception {
        getNewStatus.setItensAprovados(4);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.contains("APROVADO_QTD_A_MAIOR")));
    }

    @Test
    void itShouldsetNewStatusToQMenor() throws Exception {
        getNewStatus.setItensAprovados(2);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.contains("APROVADO_QTD_A_MENOR")));
    }

    @Test
    void itShouldsetNewStatusToQMenorAndVMenor() throws Exception {
        getNewStatus.setItensAprovados(2);
        getNewStatus.setValorAprovado(19);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.containsInAnyOrder("APROVADO_QTD_A_MENOR", "APROVADO_VALOR_A_MENOR")));
    }

    @Test
    void itShouldsetNewStatusToQMenorAndVMaior() throws Exception {
        getNewStatus.setItensAprovados(2);
        getNewStatus.setValorAprovado(21);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.containsInAnyOrder("APROVADO_QTD_A_MENOR", "APROVADO_VALOR_A_MAIOR")));
    }

    @Test
    void itShouldsetNewStatusToQMaiorAndVMaior() throws Exception {
        getNewStatus.setItensAprovados(4);
        getNewStatus.setValorAprovado(21);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.containsInAnyOrder("APROVADO_QTD_A_MAIOR", "APROVADO_VALOR_A_MAIOR")));
    }

    @Test
    void itShouldsetNewStatusToQMaiorAndVMenor() throws Exception {
        getNewStatus.setItensAprovados(4);
        getNewStatus.setValorAprovado(19);
        mockMvc.perform(post("/api/status")
                        .contentType("application/json").content(mapper.writeValueAsString(getNewStatus)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pedido", Matchers.equalTo(pedido)))
                .andExpect(jsonPath("$.status", Matchers.containsInAnyOrder("APROVADO_QTD_A_MAIOR", "APROVADO_VALOR_A_MENOR")));
    }
}