package com.avaliacao.pigbank.unit.service;

import com.avaliacao.pigbank.conta.model.Conta;
import com.avaliacao.pigbank.exceptions.SaldoInferiorParaTransferencia;
import com.avaliacao.pigbank.transacoes.model.TipoTransacao;
import com.avaliacao.pigbank.transacoes.model.Transacao;
import com.avaliacao.pigbank.transacoes.services.TransacaoService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class TransacaoServiceTest {

    @MockBean
    private TransacaoService transacaoService;

    private Transacao transacao;

    @BeforeEach
    public void setUp() {

        Conta conta = new Conta();
        conta.setId(RandomUtils.nextLong());

        this.transacao = new Transacao();
        this.transacao.setId(RandomUtils.nextLong());
        this.transacao.setConta(conta);
        this.transacao.setDateTime(LocalDateTime.now());
        this.transacao.setValor(RandomUtils.nextDouble());
        this.transacao.setTipoTransacao(randomEnum());
    }

    //transferir(Transacao transacao, Long idContaOrigem, Long idcontaDestino)

    @Test
    public void transferir() {

        //cenario
        Mockito.when(transacaoService.transferir(Mockito.any(Transacao.class), Mockito.anyLong(), Mockito.anyLong())).thenReturn(transacao);

        //ação
        Transacao transacaoRetornada = transacaoService.transferir(transacao, RandomUtils.nextLong(), RandomUtils.nextLong());

        //validação
        assertNotNull(transacaoRetornada);
    }

    @Test
    public void transferirComExecao() {
        //doThrow(new SaldoInferiorParaTransferencia("Saldo Insuficiente para operação.")).

        //cenario
        Mockito.when(transacaoService.transferir(Mockito.any(Transacao.class),
                Mockito.anyLong(), Mockito.anyLong())).thenThrow(new SaldoInferiorParaTransferencia("Saldo Insuficiente para operação."));

       SaldoInferiorParaTransferencia exceptionSaldo = assertThrows(SaldoInferiorParaTransferencia.class, () -> transacaoService.transferir(transacao,
                RandomUtils.nextLong(), RandomUtils.nextLong()));

        //validação
        assertEquals("Saldo Insuficiente para operação.", exceptionSaldo.getMessage());
    }

    private TipoTransacao randomEnum() {
        List<TipoTransacao> enums = Arrays.asList(TipoTransacao.values());
        return enums.get(RandomUtils.nextInt(0, enums.size()));
    }
}