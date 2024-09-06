package com.workspacepi.apiquoteflow.domain.cotacao;

import java.util.List;
import java.util.UUID;

// Nossa interface cotacaoRepository que define a abstração dos métodos de consulta
public interface CotacaoRepository {

    List<Cotacao> findAll();

    Cotacao findById(UUID cotacaoId);

}
