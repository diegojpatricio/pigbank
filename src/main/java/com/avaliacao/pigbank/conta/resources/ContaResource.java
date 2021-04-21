package com.avaliacao.pigbank.conta.resources;


import com.avaliacao.pigbank.conta.model.Conta;
import com.avaliacao.pigbank.conta.model.ContaDTO;
import com.avaliacao.pigbank.conta.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/contas")
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> buscarConta(@PathVariable Long id){
        Conta obj = contaService.buscarConta(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ContaDTO>> listarContas(
            @RequestParam(value = "cliente", defaultValue = "0") Long id_cliente){
        List<Conta> list = contaService.listarConta(id_cliente);
        List<ContaDTO> listDTO = list.stream().map(obj -> new ContaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id, @RequestBody Conta conta){
        Conta upConta = contaService.atualizarConta(id, conta);
        return ResponseEntity.ok().body(upConta);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Conta> atualizarDadoConta(@PathVariable Long id, @RequestBody Conta conta){
        Conta upConta = contaService.atualizarConta(id, conta);
        return ResponseEntity.ok().body(upConta);
    }

    @PostMapping
    public ResponseEntity<Conta> gerarConta(@RequestParam(value = "cliente", defaultValue = "0") Long id_cliente,
                                            @RequestBody Conta conta){
        Conta addConta = contaService.gerarConta(id_cliente, conta);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/contas/{id}").buildAndExpand(addConta.getId()).toUri();
        return ResponseEntity.created(uri).body(conta);

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable Long id){
        contaService.deleteConta(id);
        return ResponseEntity.noContent().build();
    }

}
