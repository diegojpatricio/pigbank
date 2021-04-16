package com.avaliacao.pigbank.conta.Resources;

import com.avaliacao.pigbank.cliente.model.Cliente;
import com.avaliacao.pigbank.conta.Repositories.ContaRepository;
import com.avaliacao.pigbank.conta.model.Conta;
import com.avaliacao.pigbank.conta.model.TipoConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contas")
public class ContaResource {

    @Autowired
    private ContaRepository contaRepository;


    @GetMapping
    public List<Conta> listarContas(){
        return this.contaRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarConta(@PathVariable Long id){
        Optional<Conta> conta = contaRepository.findById(id);

        if(conta.isPresent()){
            return ResponseEntity.ok(conta.get());
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id, @RequestBody Conta conta){

        if(!contaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        conta.setId(id);
        conta = contaRepository.save(conta);
        return ResponseEntity.ok(conta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long id){

        if(!contaRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        contaRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@RequestBody Conta conta){

        return this.contaRepository.save(conta);

    }



}


