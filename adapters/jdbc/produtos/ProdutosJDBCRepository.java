// Nosso repositório de acesso a dados


package com.workspacepi.apiquoteflow.adapters.jdbc.produtos;


import com.workspacepi.apiquoteflow.domain.cotacao.Categoria;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoStatus;
// import com.workspacepi.apiquoteflow.adapters.http.produtos.error.ProdurtosErrorHandler;
import com.workspacepi.apiquoteflow.domain.produtos.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

// import static com.workspacepi.apiquoteflow.adapters.jdbc.cotacoes.ProdutosSqlExpressions.*;


// Nosso repositório que define os nossos métodos de query e de crud usando o JDBC

@Repository
public class ProdutosJDBCRepository implements ProdutosRepository {

//  Um atributo para criar o nosso template do JDBC assim como o seu construtor

private final NamedParameterJdbcTemplate jdbcTemplate;

public ProdutosJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}


//  Logger cuida do envio das nossas exceptions específicas ao invés das exceptions padrões

    // private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoErrorHandler.class);


//  Função da RowMapper para aproveitamento de código
//  Essa função é usada para mapear o resultado de uma consulta SQL

    private RowMapper<Produto> createProdutoRowMapper() {
        return (rs, rowNum) -> {
            String categoria_produto = rs.getString("categoria_produto");
            String descricao_produto = rs.getString("descricao_produto");
            String obsevacao_produto = rs.getString("obsevacao_produto");
            String sku_produto = rs.getString("sku_produto");
            UUID id_empresa_produto = UUID.fromString(rs.getString("id_empresa_produto"));
            UUID id_produto = UUID.fromString(rs.getString("id_produto"));

            return new Produto(categoria_produto, descricao_produto, obsevacao_produto, 
                        sku_produto, id_empresa_produto, id_produto);
        };
    }

//  Função para mapeamento dos parâmetros para as consultas sql

    private MapSqlParameterSource parameterSource(Produto produto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoria_produto", produto.getCategoria_produto());
        params.addValue("descricao_produto", produto.getDescricao_produto());
        params.addValue("observacao_produto", produto.getObsevacao_produto());
        return params;
    }


    @Override
    public List<Produto> findAll() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Produto findById(UUID id_produto) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Boolean modificarProdutos(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Boolean solicitarProdutos(Produto produto) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
