package com.workspacepi.apiquoteflow.adapters.http;

import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// esse é o nosso controller, ele define os casos de uso para uma rota de cotacoes usando o método get

@RestController
public class CotacaoController {

// Definição do nosso atributo Handles assim como o seu construtor
    private CotacaoHandler cotacaoHandler;

    public CotacaoController(CotacaoHandler cotacaoHandler) {
        this.cotacaoHandler = cotacaoHandler;
    }

// método get para a rota de cotações que devolve todas as cotações
// (afim de testes, isso não pode ser implementado na aplicação com as cotações).
    @GetMapping("/cotacoes")
    public ResponseEntity<List<Cotacao>> findAll() {
        return cotacaoHandler.findAll();
    }
}
