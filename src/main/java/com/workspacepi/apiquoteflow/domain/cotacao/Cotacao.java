package com.workspacepi.apiquoteflow.domain.cotacao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

// A nossa classe cotação que será usada na manipulação e persistência dos dados
// atravez dos métodos crud e consultas sql feitas no código da aplicação

public class Cotacao {
    private UUID cotacaoId = UUID.randomUUID();
    private Categoria categoria;
    private CotacaoStatus cotacaoStatus;
    private Instant dataCotacao = Instant.now();
    private ArrayList<ItensCotacao> itens;

//    Construtor
    public Cotacao(UUID cotacaoId, Categoria categoria, CotacaoStatus cotacaoStatus, Instant dataCotacao, ArrayList<ItensCotacao> itens) {
        this.cotacaoId = cotacaoId;
        this.categoria = categoria;
        this.cotacaoStatus = cotacaoStatus;
        this.dataCotacao = dataCotacao;
        this.itens = itens;
    }
}
