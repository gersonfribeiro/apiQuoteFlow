package com.workspacepi.apiquoteflow.application.cotacao;

import com.workspacepi.apiquoteflow.domain.cotacao.Categoria;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoStatus;
import com.workspacepi.apiquoteflow.domain.cotacao.ItensCotacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

//  Usando Jackson para serialização
public class CotacaoCreateCommand {

    @JsonProperty("categoria")
    private Categoria categoria;

    @JsonProperty("status")
    private CotacaoStatus status;


    @JsonProperty("data_solicitacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp data_solicitacao;

    @JsonProperty("id_autor")
    private UUID id_autor;

    @JsonProperty("itens")
    private Set<ItensCotacao> itens;


//  Conversão para cotacao
    public Cotacao toCotacao() {
        return new Cotacao(categoria, status, id_autor, itens);
    }

//  Getters e setters
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

    public Timestamp getData_solicitacao() {
        return data_solicitacao;
    }

    public void setData_solicitacao(Timestamp data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }

    public Set<ItensCotacao> getItens() {
        return itens;
    }

    public void setItens(Set<ItensCotacao> itens) {
        this.itens = itens;
    }

    public UUID getId_autor() {
        return id_autor;
    }

    public void setId_autor(UUID id_autor) {
        this.id_autor = id_autor;
    }
}
