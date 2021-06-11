package com.avaliacao.pigbank.unit.dto.service;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.cliente.services.ClienteService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ClienteServiceTest {

    @MockBean
    private ClienteService clienteService;

    private Cliente cliente;

    private List<Cliente> clientes;

    @BeforeEach
    public void setUp() {

        //cenario
        this.cliente = new Cliente();
        this.cliente.setId(RandomUtils.nextLong());
        this.cliente.setNome(RandomStringUtils.random(25));
        this.cliente.setCpf(RandomStringUtils.random(25));
        this.cliente.setEmail(RandomStringUtils.random(25));

        clientes = Collections.singletonList(cliente);
    }

    @Test
    public void buscarCliente() {

        //cenario
        Mockito.when(clienteService.buscarCliente(Mockito.anyLong())).thenReturn(cliente);

        //ação
        Cliente clienteRetornado = clienteService.buscarCliente(cliente.getId());

        //validação
        assertNotNull(clienteRetornado);
        assertEquals(cliente.getId(), clienteRetornado.getId());
        assertEquals(cliente.getNome(), clienteRetornado.getNome());
        assertEquals(cliente.getCpf(), clienteRetornado.getCpf());
        assertEquals(cliente.getEmail(), clienteRetornado.getEmail());
    }

    @Test
    public void listClientes() {
        //cenario
        Mockito.when(clienteService.listarClientes()).thenReturn(clientes);

        //ação
        List<Cliente> listaRetornada = clienteService.listarClientes();

        //validação
        assertNotNull(listaRetornada);
        assertIterableEquals(clientes, listaRetornada);
    }

    @Test
    public void gerarCliente() {

        //cenario
        Mockito.when(clienteService.gerarCliente(Mockito.any(Cliente.class))).thenReturn(cliente);

        //ação
        Cliente clienteRetornado = clienteService.gerarCliente(cliente);

        //validação
        assertNotNull(clienteRetornado);
        assertEquals(cliente.getId(), clienteRetornado.getId());
        assertEquals(cliente.getNome(), clienteRetornado.getNome());
        assertEquals(cliente.getCpf(), clienteRetornado.getCpf());
        assertEquals(cliente.getEmail(), clienteRetornado.getEmail());
    }

    @Test
    public void gerarClienteNull() {

        //cenario
        Mockito.when(clienteService.gerarCliente(Mockito.any(Cliente.class))).thenReturn(null);

        //ação
        Cliente clienteRetornado = clienteService.gerarCliente(cliente);

        //validação
        assertNull(clienteRetornado);
    }


    //buscarCliente
    //listarClientes
    //gerarCliente
    // atualizarCliente
    //deletarCliente

}