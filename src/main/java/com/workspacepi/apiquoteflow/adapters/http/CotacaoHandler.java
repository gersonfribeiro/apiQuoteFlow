package com.workspacepi.apiquoteflow.adapters.http;


import com.workspacepi.apiquoteflow.application.cotacao.CotacaoService;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

// Nosso Handler é um componente controlado pelo Spring para termos a injeção de dependência,
// sua função é chamar os Services

@Component
public class CotacaoHandler {

//    Definção do atributo dos serviços de cotação e seu construtor

    private CotacaoService cotacaoService;
    public CotacaoHandler(CotacaoService cotacaoService) {
        this.cotacaoService = cotacaoService;
    }

//    Método findAll definidos nos Serviços de cotação, o retorno é uma lista de cotações

    public ResponseEntity<List<Cotacao>> findAll() {
        List<Cotacao> cotacao = cotacaoService.findAll();
        return ResponseEntity.ok(cotacao);
    }

//    Método findById definido nos Serviços de cotação, o retorno é uma cotação ou uma Exception

    public ResponseEntity<Cotacao> findById(String cotacaoId) throws Exception{
        Cotacao cotacao = cotacaoService.findById(UUID.fromString(cotacaoId));
        return ResponseEntity.ok(cotacao);
    }
}
