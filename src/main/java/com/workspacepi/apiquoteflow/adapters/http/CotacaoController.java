package com.workspacepi.apiquoteflow.adapters.http;

import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//  Esse é o nosso controller, ele define os casos de uso para uma rota de cotacoes usando o método get

@RestController
public class CotacaoController {
    private static final String UUID_REGEX = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}";


//  Definição do nosso atributo Handles assim como o seu construtor

    private CotacaoHandler cotacaoHandler;
    public CotacaoController(CotacaoHandler cotacaoHandler) {
        this.cotacaoHandler = cotacaoHandler;
    }

//  Método get para a rota de cotações que devolve todas as cotações
//  (afim de testes, isso não pode ser implementado na aplicação com as cotações).

    @GetMapping("/cotacoes")
    public ResponseEntity<List<Cotacao>> findAll() {
        return cotacaoHandler.findAll();
    }

//  Método get para a rota de uma cotação especifica.

    @GetMapping("/cotacoes/{cotacaoId:$UUID_REGEX}")
    public ResponseEntity<Cotacao> findById(@PathVariable String cotacaoId) throws Exception {
        return cotacaoHandler.findById(cotacaoId);
    }

}
