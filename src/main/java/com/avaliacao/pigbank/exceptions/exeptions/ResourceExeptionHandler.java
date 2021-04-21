package com.avaliacao.pigbank.exceptions.exeptions;


import com.avaliacao.pigbank.exceptions.ExceptionDataIntegrityViolation;
import com.avaliacao.pigbank.exceptions.ObjectNotFoundException;
import com.avaliacao.pigbank.exceptions.SaldoInferiorParaTransferencia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExeptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<com.avaliacao.pigbank.exceptions.exeptions.StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
        com.avaliacao.pigbank.exceptions.exeptions.StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ExceptionDataIntegrityViolation.class)
    public ResponseEntity<com.avaliacao.pigbank.exceptions.exeptions.StandardError> exceptionDataIntegrityViolation(ExceptionDataIntegrityViolation e, ServletRequest request){
        com.avaliacao.pigbank.exceptions.exeptions.StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(SaldoInferiorParaTransferencia.class)
    public ResponseEntity<com.avaliacao.pigbank.exceptions.exeptions.StandardError> saldoInferiorParaTransferencia(SaldoInferiorParaTransferencia e, ServletRequest request){
        com.avaliacao.pigbank.exceptions.exeptions.StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

