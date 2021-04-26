package com.avaliacao.pigbank.cliente.resources;


import com.avaliacao.pigbank.cliente.model.ClienteDTO;
import com.avaliacao.pigbank.cliente.services.ClienteService;
import com.avaliacao.pigbank.cliente.model.Cliente;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id){
        Cliente obj = clienteService.buscarCliente(id);
        return ResponseEntity.ok().body(obj);
    }


    @GetMapping
    public  ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<Cliente> list = clienteService.listarClientes();
        List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    /*
    * Por questões de boas práticas deve-se retornar para o usuário a URI de acesso ao novo objeto criado.
    * */
    @PostMapping
    public ResponseEntity<Cliente> gerarCliente(@RequestBody Cliente cliente){
        cliente = clienteService.gerarCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDto){
       Cliente upCliente = clienteService.atualizarCliente(id, clienteDto);
       return ResponseEntity.ok().body(new ClienteDTO(upCliente));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();

    }
}
