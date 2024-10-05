// Nosso repositório de acesso a dados


package com.workspacepi.apiquoteflow.adapters.jdbc.cotacoes;


import com.workspacepi.apiquoteflow.adapters.http.cotacoes.error.CotacaoErrorHandler;
import com.workspacepi.apiquoteflow.domain.cotacao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import static com.workspacepi.apiquoteflow.adapters.jdbc.cotacoes.CotacoesSqlExpressions.*;


// Nosso repositório que define os nossos métodos de query e de crud usando o JDBC

@Repository
public class CotacoesJDBCRepository implements CotacaoRepository {

//  Um atributo para criar o nosso template do JDBC assim como o seu construtor

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CotacoesJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//  Logger cuida do envio das nossas exceptions específicas ao invés das exceptions padrões

    private static final Logger LOGGER = LoggerFactory.getLogger(CotacaoErrorHandler.class);


//  Função da RowMapper para aproveitamento de código
//  Essa função é usada para mapear o resultado de uma consulta SQL

    private RowMapper<Cotacao> createCotacaoRowMapper() {
        return (rs, rowNum) -> {
            UUID id_cotacao = UUID.fromString(rs.getString("id_cotacao"));
            Categoria categoria = Categoria.valueOf(rs.getString("categoria"));
            Timestamp data_solicitacao = rs.getTimestamp("data_solicitacao");
            CotacaoStatus status = CotacaoStatus.valueOf(rs.getString("status"));
            UUID id_autor = UUID.fromString(rs.getString("id_autor"));

            return new Cotacao(id_cotacao, categoria, data_solicitacao, status, id_autor,null);
        };
    }

//  Função para mapeamento dos parâmetros para as consultas sql

    private MapSqlParameterSource parameterSource(Cotacao cotacao) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_cotacao", cotacao.getId_cotacao());
        params.addValue("categoria", cotacao.getCategoria().name());
        params.addValue("data_solicitacao", cotacao.getDataSolicitacao());
        params.addValue("status", cotacao.getStatus().name());
        params.addValue("id_autor", cotacao.getId_autor());
        params.addValue("itens", cotacao.getItens());
        return params;
    }

//  Reescrita do método findAll definito na nossa interface de cotações

    @Override
    public List<Cotacao> findAll() {
        List<Cotacao> cotacoes = List.of();
        try {
            cotacoes = jdbcTemplate.query(sqlSelectAllQuotations(), createCotacaoRowMapper());
            return cotacoes;

        } catch (Exception e) {
            LOGGER.error("Houve um erro ao consultar as cotações: " + e.getMessage());
            throw e;
        }
    }

//  Reescrita do método findById definido na nossa interface de cotações

    @Override
    public Cotacao findById(UUID cotacaoId) {
        List<Cotacao> cotacoes;
        try {
            MapSqlParameterSource params = new MapSqlParameterSource("id_cotacao", cotacaoId);
            cotacoes = jdbcTemplate.query(sqlSelectQuotationById(), params, createCotacaoRowMapper());
            return cotacoes.isEmpty() ? null : cotacoes.get(0);
        } catch (Exception e) {
            LOGGER.error("Houve um erro ao consultar a cotação: " + e.getMessage());
            throw e;
        }
    }

//  Método de inserção de cotações

    @Override
    public Boolean solicitarCotacao(Cotacao cotacao) {
        try {
            MapSqlParameterSource params = parameterSource(cotacao);
            int numLinhasAfetadas = jdbcTemplate.update(sqlSolicitarCotacao(), params);
            return numLinhasAfetadas > 0;
        } catch (Exception e) {
            LOGGER.error("Houve um erro ao solicitar a cotacao: " + e.getMessage());
            throw e;
        }
    }

//  Método de atualização de cotações

    @Override
    public Boolean modificarCotacao(Cotacao cotacao) {
        try {
            MapSqlParameterSource params = parameterSource(cotacao);
            int numLinhasAfetadas = jdbcTemplate.update(sqlModificarCotacao(), params);
            return numLinhasAfetadas > 0;
        } catch (Exception e) {
            LOGGER.error("Houve um erro ao atualizar a cotacao: " + e.getMessage());
            throw e;
        }
    }
}
