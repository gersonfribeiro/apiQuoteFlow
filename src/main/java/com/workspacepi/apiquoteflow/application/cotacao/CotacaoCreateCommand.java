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

    @JsonProperty("cotacaoStatus")
    private CotacaoStatus cotacaoStatus;


    @JsonProperty("dataCotacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dataCotacao;

    @JsonProperty("itens")
    private Set<ItensCotacao> itens;

    @JsonProperty("id_autor")
    private UUID id_autor;

//  Conversão para cotacao
    public Cotacao toCotacao() {
        Cotacao cotacao = new Cotacao(categoria, cotacaoStatus, id_autor, itens);
        return cotacao;
    }

//  Getters e setters
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CotacaoStatus getCotacaoStatus() {
        return cotacaoStatus;
    }

    public void setCotacaoStatus(CotacaoStatus cotacaoStatus) {
        this.cotacaoStatus = cotacaoStatus;
    }

    public Timestamp getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Timestamp dataCotacao) {
        this.dataCotacao = dataCotacao;
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
