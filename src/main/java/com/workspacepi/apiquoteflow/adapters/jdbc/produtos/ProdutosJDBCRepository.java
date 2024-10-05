// Nosso repositório de acesso a dados


package com.workspacepi.apiquoteflow.adapters.jdbc.produtos;


// import com.workspacepi.apiquoteflow.adapters.http.produtos.error.ProdurtosErrorHandler;
import com.workspacepi.apiquoteflow.domain.produtos.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

import static com.workspacepi.apiquoteflow.adapters.jdbc.produtos.ProdutoSQLRepository.*;


// Nosso repositório que define os nossos métodos de query e de crud usando o JDBC

@Repository
public class ProdutosJDBCRepository implements ProdutosRepository {

//  Um atributo para criar o nosso template do JDBC assim como o seu construtor

private final NamedParameterJdbcTemplate jdbcTemplate;

public ProdutosJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}


//  Logger cuida do envio das nossas exceptions específicas ao invés das exceptions padrões

     private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoErrorHandler.class);


//  Função da RowMapper para aproveitamento de código
//  Essa função é usada para mapear o resultado de uma consulta SQL

    private RowMapper<Produtos> createProdutoRowMapper() {
        return (rs, rowNum) -> {
            String categoria_produto = rs.getString("categoria_produto");
            String descricao_produto = rs.getString("descricao_produto");
            String observacao_produto = rs.getString("observacao_produto");
            String sku_produto = rs.getString("sku_produto");
            UUID id_empresa_produto = UUID.fromString(rs.getString("id_empresa_produto"));
            UUID id_produto = UUID.fromString(rs.getString("id_produto"));

            return new Produtos(categoria_produto, descricao_produto, observacao_produto,
                        sku_produto, id_empresa_produto, id_produto);
        };
    }

//  Função para mapeamento dos parâmetros para as consultas sql

    private MapSqlParameterSource parameterSource(Produtos produto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("categoria_produto", produto.getCategoria_produto());
        params.addValue("descricao_produto", produto.getDescricao_produto());
        params.addValue("observacao_produto", produto.getObservacao_produto());
        params.addValue("sku_produto", produto.getSku_produto());
        params.addValue("id_empresa_produto", produto.getId_empresa_produto());
        params.addValue("id_produto", produto.getId_produto());
        return params;
    }

    @Override
    public List<Produtos> findAll() {
        List<Produtos> produtos = List.of();
        try {
            produtos = jdbcTemplate.query(sqlSelectAllProdutos(), createProdutoRowMapper());
            return produtos;
        } catch (Exception e) {
            LOGGER.error("Houver um erro ao consultar os usuários: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Produtos findById(UUID id_produto) {
        List<Produtos> produtos = List.of();
        try {
            produtos = jdbcTemplate.query(sqlSelectProdutoById(), createProdutoRowMapper());
            return produtos.get(0);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Boolean modificarProduto(Produtos produto) {
        try {
            MapSqlParameterSource params = parameterSource(produto);
            int numLinhasAfetadas = jdbcTemplate.update(sqlModificarProduto(), params);
            return numLinhasAfetadas > 0;
        } catch (Exception e) {
            LOGGER.error("Houve um erro ao modificar o produto: " + produto.getDescricao_produto() + "\n" + e.getMessage());
            throw e;
        }
    }

    @Override
    public Boolean cadastrarProduto(Produtos produto) {
        try {
            MapSqlParameterSource params = parameterSource(produto);
            int numLinhasAfetadas = jdbcTemplate.update(sqlCadastrarProduto(), params);
            return numLinhasAfetadas > 0;
        } catch (Exception e) {
            LOGGER.error("Houve um erro ao cadastrar o produto: " + e.getMessage());
            throw e;
        }
    }

}
