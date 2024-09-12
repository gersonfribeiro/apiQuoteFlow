package com.workspacepi.apiquoteflow.application.cotacao.exceptions;

import java.util.UUID;

// Classe base para exceções de cotação
public abstract class CotacaoExceptions extends Exception {
    private final UUID cotacaoId;

    public CotacaoExceptions(String mensagem, UUID cotacaoId) {
        super(mensagem);
        this.cotacaoId = cotacaoId;
    }

    public UUID getCotacaoId() {
        return cotacaoId;
    }
}

