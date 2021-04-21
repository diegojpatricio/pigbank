package com.avaliacao.pigbank.exceptions;

public class SaldoInferiorParaTransferencia  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SaldoInferiorParaTransferencia(String message) {
        super(message);
    }

    public SaldoInferiorParaTransferencia(String message, Throwable cause) {
        super(message, cause);
    }
}
