package com.workspacepi.apiquoteflow.adapters.http;

import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CotacaoController {
    private CotacaoHandler cotacaoHandler;

    public CotacaoController(CotacaoHandler cotacaoHandler) {
        this.cotacaoHandler = cotacaoHandler;
    }

    @GetMapping("/cotacoes")
    public ResponseEntity<List<Cotacao>> findAll() {
        return cotacaoHandler.findAll();
    }
}
