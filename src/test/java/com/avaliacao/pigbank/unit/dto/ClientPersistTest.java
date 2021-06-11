package com.avaliacao.pigbank.unit.dto;

import com.avaliacao.pigbank.cliente.model.ClientPersist;
import com.avaliacao.pigbank.conta.model.Conta;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientPersistTest {

    private ClientPersist clientPersist;

    private Validator validator;

    @BeforeEach
    public void setUp() {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();

        //cenario
        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta());
        contas.add(new Conta());

        this.clientPersist = new ClientPersist();
        clientPersist.setNome(RandomStringUtils.random(25));
        clientPersist.setCpf(RandomStringUtils.random(11));
        clientPersist.setEmail(RandomStringUtils.random(25));
        clientPersist.setTelefone(RandomStringUtils.random(25));
        clientPersist.setContas(contas);
    }

    @Test
    public void clientIsValid() {

        //ação
        Set<ConstraintViolation<ClientPersist>> violations = validator.validate(clientPersist);

        //validção
        assertEquals(0, violations.size());
    }

    @Test
    public void clientCpfIsNull() {

        //cenario
        this.clientPersist.setCpf(null);
        //ação
        Set<ConstraintViolation<ClientPersist>> violations = validator.validate(clientPersist);
        //validção
        assertEquals(1, violations.size());
    }

    //Válido, Nulo



}