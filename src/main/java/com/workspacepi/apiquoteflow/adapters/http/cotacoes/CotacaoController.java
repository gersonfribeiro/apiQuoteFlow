package com.workspacepi.apiquoteflow.adapters.http.cotacoes;

import com.workspacepi.apiquoteflow.application.cotacao.CotacaoCreateCommand;
import com.workspacepi.apiquoteflow.application.cotacao.CotacaoUpdateCommand;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//  Esse é o nosso controller, ele define os casos de uso para uma rota de cotacoes usando o método get

@RestController
public class CotacaoController {

//  Definição do nosso atributo Handles assim como o seu construtor

    private final CotacaoHandler cotacaoHandler;
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

    @GetMapping("/cotacoes/{cotacaoId}")
    public ResponseEntity<Cotacao> findById(@PathVariable String cotacaoId) throws Exception {
        return cotacaoHandler.findById(cotacaoId);
    }

//  Método post para solicitar uma nova cotação (necessita de modificações
    @PostMapping("/cotacoes")
    public ResponseEntity<Cotacao> create(@RequestBody CotacaoCreateCommand cotacaoCreateCommand) throws Exception {

        return cotacaoHandler.solicitarCotacao(cotacaoCreateCommand);
    }

//  Método put para solicitar uma nova cotação (necessita de modificações
    @PutMapping("/cotacoes/{cotacaoId}")
    public ResponseEntity<Cotacao> create(@RequestBody CotacaoUpdateCommand cotacaoUpdateCommandCommand, @PathVariable String cotacaoId) throws Exception {

        return cotacaoHandler.modificarCotacao(cotacaoUpdateCommandCommand, cotacaoId);
    }

}
