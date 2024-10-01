package com.workspacepi.apiquoteflow.domain.produtos;

import java.util.UUID;

public class Produto {
    private String categoria_produto;
    private String descricao_produto;
    private String obsevacao_produto;
    private String sku_produto;
    private UUID id_empresa_produto;
    private UUID id_produto;
    
    // Construtor do RowMapper
    public Produto(String categoria_produto, String descricao_produto, String obsevacao_produto,
            String sku_produto, UUID id_empresa_produto, UUID id_produto) {
        this.categoria_produto = categoria_produto;
        this.descricao_produto = descricao_produto;
        this.obsevacao_produto = obsevacao_produto;
        this.sku_produto = sku_produto;
        this.id_empresa_produto = id_empresa_produto;
        this.id_produto = id_produto;
    }

    // Construtor de modificação
    public Produto(String categoria_produto, String descricao_produto, String obsevacao_produto,
            String sku_produto, UUID id_empresa_produto) {
        this.categoria_produto = categoria_produto;
        this.descricao_produto = descricao_produto;
        this.obsevacao_produto = obsevacao_produto;
        this.sku_produto = sku_produto;
        this.id_empresa_produto = id_empresa_produto;
        this.id_produto = UUID.randomUUID();
    }

    public String getCategoria_produto() {
        return categoria_produto;
    }

    public void setCategoria_produto(String categoria_produto) {
        this.categoria_produto = categoria_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public String getObsevacao_produto() {
        return obsevacao_produto;
    }

    public void setObsevacao_produto(String obsevacao_produto) {
        this.obsevacao_produto = obsevacao_produto;
    }

    public String getSku_produto() {
        return sku_produto;
    }

    public void setSku_produto(String sku_produto) {
        this.sku_produto = sku_produto;
    }

    public UUID getId_empresa_produto() {
        return id_empresa_produto;
    }

    public void setId_empresa_produto(UUID id_empresa_produto) {
        this.id_empresa_produto = id_empresa_produto;
    }

    public UUID getId_produto() {
        return id_produto;
    }

    public void setId_produto(UUID id_produto) {
        this.id_produto = id_produto;
    }
    
}
