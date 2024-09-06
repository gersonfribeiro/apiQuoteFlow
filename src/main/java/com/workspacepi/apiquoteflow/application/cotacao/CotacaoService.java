package com.workspacepi.apiquoteflow.application.cotacao;

import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotacaoService {
    private CotacaoRepository cotacaoRepository;

    public CotacaoService(CotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public List<Cotacao> findAll() {
        return cotacaoRepository.findAll();
    }
}
