package com.avaliacao.pigbank.transacoes.services;




import com.avaliacao.pigbank.conta.model.Conta;

import com.avaliacao.pigbank.conta.repositories.ContaRepository;
import com.avaliacao.pigbank.conta.services.ContaService;
import com.avaliacao.pigbank.exceptions.ObjectNotFoundException;
import com.avaliacao.pigbank.transacoes.model.Transacao;
import com.avaliacao.pigbank.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.avaliacao.pigbank.transacoes.model.TipoTransacao.*;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private ContaRepository contaRepository;


    public Transacao buscarTransacao(Long id){
        Optional<Transacao> obj = transacaoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: " + id +
                ", Tipo: " + Transacao.class.getName()));
    }

    public Transacao sacar(Transacao transacao, Long idConta){
        transacao.setId(null);
        Conta contaAtual = contaService.buscarConta(idConta);
        Double saldo = contaAtual.getSaldo();
        Double valorSaque = transacao.getValor();
        Double novoSaldo = (saldo - valorSaque);
        contaAtual.setSaldo(novoSaldo);
        transacao.setTipoTransacao(SAQUE);
        transacao.setConta(contaAtual);
        return transacaoRepository.save(transacao);
    }


    public Transacao depositar(Transacao transacao, Long idConta) {
        transacao.setId(null);
        Conta contaAtual = contaService.buscarConta(idConta);
        Double saldo = contaAtual.getSaldo();
        Double valorDeposito = transacao.getValor();

        if(saldo < 0){
            Double s1 = valorDeposito + saldo;
            Double s2 = saldo * 0.005;
            Double novoSaldo = s1 + s2;
            contaAtual.setSaldo(novoSaldo);
        }else {
            Double novoSaldo = (saldo + valorDeposito);
            contaAtual.setSaldo(novoSaldo);
        }

        transacao.setTipoTransacao(DEPOSITO);
        transacao.setConta(contaAtual);
        return transacaoRepository.save(transacao);
    }

    public Transacao transferir(Transacao transacao, Long idContaOrigem, Long idcontaDestino) {
        transacao.setId(null);
        transacao.setTipoTransacao(TRANSFERENCIA);
        Conta contaOrigem = contaService.buscarConta(idContaOrigem);
        Double saldoOrigem = contaOrigem.getSaldo();
        Double valorOrigem = transacao.getValor();


        Conta contaDestino = contaService.buscarConta(idcontaDestino);
        contaDestino.getNumeroConta();
        contaDestino.getAgencia();
        Double saldoDestino = contaDestino.getSaldo();

        if(saldoOrigem > 0){
            //ERRO! SEU saldo está negativo
            System.out.println("Saldo menor que ZERO");
        }
/*
        if(valorOrigem > saldoOrigem) {
            throw new Exception("ERRO! O valor da transfrencia é superior ao seu saldo.");
        }

        if(contaOrigem.getAgencia() == contaDestino.getAgencia()){
            //não cobra a tava de 0.001

        }*/
        Double novoSaldoOrigem = saldoOrigem - valorOrigem;
        Double novoSaldoDestino = saldoDestino + valorOrigem;

        contaOrigem.setSaldo(novoSaldoOrigem);
        contaDestino.setSaldo(novoSaldoDestino);

        transacao.setConta(contaDestino);
        return transacaoRepository.save(transacao);
    }
}
