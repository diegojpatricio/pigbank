package com.avaliacao.pigbank.transacoes.resources;



import com.avaliacao.pigbank.conta.model.Conta;
import com.avaliacao.pigbank.transacoes.model.Transacao;
import com.avaliacao.pigbank.transacoes.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/transacao")
public class TransacaoResource {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transacao> buscarTransacao(@PathVariable Long id){
        Transacao obj = transacaoService.buscarTransacao(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping(value = "/sacar/{idConta}")
    public ResponseEntity<Transacao> sacar(@RequestBody Transacao transacao, @PathVariable Long idConta){
        Transacao saque = transacaoService.sacar(transacao, idConta);
        return ResponseEntity.ok().body(saque);
    }

    @PostMapping(value = "/depositar/{idConta}")
    public ResponseEntity<Transacao> depositar(@RequestBody Transacao transacao, @PathVariable Long idConta){
        Transacao deposito = transacaoService.depositar(transacao, idConta);
        return ResponseEntity.ok().body(deposito);
    }

    @PostMapping(value = "/transferencia/{idContaOrigem}")
    public ResponseEntity<Transacao> transferencia(
            @RequestBody Transacao transacao, @PathVariable Long idContaOrigem,
            @RequestParam(value = "id_contaDestino") Long id_contaDestino) {
        Transacao deposito = transacaoService.transferir(transacao, idContaOrigem, id_contaDestino);
        return ResponseEntity.ok().body(deposito);
    }





}

