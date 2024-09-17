package com.workspacepi.apiquoteflow.application.cotacao;

import com.workspacepi.apiquoteflow.adapters.http.CotacaoHandler;
import com.workspacepi.apiquoteflow.application.cotacao.exceptions.CotacaoNaoEncontradaException;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// Nossa classe de serviços das cotações, aqui definimos as regras de negócios do nosso projeto no que diz respeito as cotações

@Service
public class CotacaoService {

//  Atributo do nosso repository onde temos a nossa interface que
//  declara a abstração que devemos possuir nos métodos crud usando o JDBC
//  assim como o seu construtor

    private CotacaoRepository cotacaoRepository;
    public CotacaoService(CotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

//  Retorno do método findAll

    public List<Cotacao> findAll() {
        return cotacaoRepository.findAll();
    }

//  Retorno do método findById com a possíbilidade de retornar uma exception criada manualmente

    public Cotacao findById(UUID cotacaoId) throws Exception{
        Cotacao cotacao = cotacaoRepository.findById(cotacaoId);

        if(cotacao == null)
            throw new CotacaoNaoEncontradaException(cotacaoId);

        return  cotacao;
    }

    public Cotacao solicitarCotacao(CotacaoCreateCommand cotacao) throws Exception{
        Cotacao cotacaoDomain = cotacao.toCotacao();
        cotacaoRepository.solicitarCotacao(cotacaoDomain);

        return findById(cotacaoDomain.getId_cotacao());
    }

}
