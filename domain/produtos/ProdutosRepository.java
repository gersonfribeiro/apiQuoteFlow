package com.workspacepi.apiquoteflow.domain.produtos;

import java.util.List;
import java.util.UUID;

// Nossa interface produtosRepository que define a abstração dos métodos de consulta
public interface ProdutosRepository {

//  Buscar todas as produtos
    List<Produto> findAll();

//  Buscar por ID
    Produto findById(UUID id_produto);

//  Inserção
    Boolean solicitarProdutos(Produto produto);

//  Modificação
    Boolean modificarProdutos(Produto produto);

}
