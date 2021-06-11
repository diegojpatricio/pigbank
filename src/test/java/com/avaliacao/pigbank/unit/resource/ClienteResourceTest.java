package com.avaliacao.pigbank.unit.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.avaliacao.pigbank.cliente.services.ClienteService;
import com.avaliacao.pigbank.conta.services.ContaService;
import com.avaliacao.pigbank.transacoes.services.TransacaoService;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
public class ClienteResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private ContaService contaService;

    @MockBean
    private TransacaoService transacaoService;

    @Test
    public void getCliente() throws Exception {

        MvcResult response = mockMvc.perform(get("/api/clientes/{id}", RandomUtils.nextLong()))
                .andReturn();

        String conteudo = response.getResponse().getContentType();
        System.out.println(conteudo);
    }

    @Test
    public void deletecliente() throws Exception {

        this.mockMvc.perform(delete("/api/clientes/{id}", RandomUtils.nextLong()))
                .andExpect(status().isNoContent());
    }

}