package com.avaliacao.pigbank.cliente.resources;


import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.cliente.repositoies.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository cr;

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return this.cr.save(cliente);
    }
}
