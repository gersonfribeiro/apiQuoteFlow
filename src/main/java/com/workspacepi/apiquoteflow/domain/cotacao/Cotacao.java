package com.workspacepi.apiquoteflow.domain.cotacao;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

// A nossa classe cotação que será usada na manipulação e persistência dos dados
// atravez dos métodos crud e consultas sql feitas no código da aplicação

public class Cotacao {
    private UUID id_cotacao;
    private Categoria categoria;
    private Timestamp data_solicitacao;
    private CotacaoStatus status;
    private UUID id_autor;
    private Set<ItensCotacao> itens;

//  Construtores

    // Construtor para uso do RowMapper

    public Cotacao(UUID id_cotacao, Categoria categoria, Timestamp data_solicitacao, CotacaoStatus status, UUID id_autor, Set<ItensCotacao> itens) {
        this.id_cotacao = id_cotacao;
        this.categoria = categoria;
        this.data_solicitacao = data_solicitacao;
        this.status = status;
        this.id_autor = id_autor;
        this.itens = itens;
    }

    // Construtor para uso da inserção no banco de dados

    public Cotacao(Categoria categoria, CotacaoStatus cotacaoStatus, UUID id_autor, Set<ItensCotacao> itens) {
        this.id_cotacao = UUID.randomUUID();
        this.categoria = categoria;
        this.status = cotacaoStatus;
        this.data_solicitacao = Timestamp.from(Instant.now());
        this.id_autor = id_autor;
        this.itens = itens;
    }

    public UUID getId_cotacao() {
        return id_cotacao;
    }

    public void setId_cotacao(UUID id_cotacao) {
        this.id_cotacao = id_cotacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CotacaoStatus getStatus() {
        return status;
    }

    public void setStatus(CotacaoStatus status) {
        this.status = status;
    }

    public Timestamp getDataSolicitacao() {
        return data_solicitacao;
    }

    public void setDataSolicitacao(Timestamp dataCotacao) {
        this.data_solicitacao = dataCotacao;
    }

    public UUID getId_autor() {
        return id_autor;
    }

    public void setId_autor(UUID id_autor) {
        this.id_autor = id_autor;
    }

    public Set<ItensCotacao> getItens() {
        return itens;
    }

    public void setItens(Set<ItensCotacao> itens) {
        this.itens = itens;
    }
}
