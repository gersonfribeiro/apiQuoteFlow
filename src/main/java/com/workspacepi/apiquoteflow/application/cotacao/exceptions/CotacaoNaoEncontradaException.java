package com.workspacepi.apiquoteflow.application.cotacao.exceptions;

import java.util.UUID;

// Exceção específica para quando uma cotação não for encontrada
public class CotacaoNaoEncontradaException extends CotacaoExceptions {

    public CotacaoNaoEncontradaException(UUID cotacaoId) {
        super("Cotacao " + cotacaoId + " não encontrada", cotacaoId);
    }
}
