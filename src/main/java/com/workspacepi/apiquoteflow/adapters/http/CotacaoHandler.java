package com.workspacepi.apiquoteflow.adapters.http;


import com.workspacepi.apiquoteflow.application.cotacao.CotacaoService;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CotacaoHandler {
    private CotacaoService cotacaoService;

    public CotacaoHandler(CotacaoService cotacaoService) {
        this.cotacaoService = cotacaoService;
    }

    public ResponseEntity<List<Cotacao>> findAll() {
        List<Cotacao> cotacao = cotacaoService.findAll();
        return ResponseEntity.ok(cotacao);
    }
}
