package com.workspacepi.apiquoteflow.adapters.jdbc;


import com.workspacepi.apiquoteflow.domain.cotacao.Categoria;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoRepository;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static com.workspacepi.apiquoteflow.adapters.jdbc.CotacoesSqlExpressions.sqlSelectAll;
import static com.workspacepi.apiquoteflow.adapters.jdbc.CotacoesSqlExpressions.sqlSelectById;

// Nosso repositório que define os nossos métodos de query e de crud usando o JDBC
@Repository
public class CotacoesJDBCRepository implements CotacaoRepository {

//    Um atributo para criar o nosso template do JDBC assim como o seu construtor
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CotacoesJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    Reescrita do método findAll definito na nossa interface de cotações
    @Override
    public List<Cotacao> findAll() {
        return jdbcTemplate.query(sqlSelectAll(), createCotacaoRowMapper());
    }

//    Reescrita do método findById definido na nossa interface de cotações
    @Override
    public Cotacao findById(UUID cotacaoId) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", cotacaoId);
        List<Cotacao> cotacoes = jdbcTemplate.query(sqlSelectById(), params, createCotacaoRowMapper());

        // Verifica se a lista está vazia e retorna o primeiro elemento ou null
        return cotacoes.isEmpty() ? null : cotacoes.get(0);
    }

//    Função da RowMapper para aproveitamento de código
    private RowMapper<Cotacao> createCotacaoRowMapper() {
        return new RowMapper<Cotacao>() {
            @Override
            public Cotacao mapRow(ResultSet rs, int rowNum) throws SQLException {
                UUID cotacaoId = UUID.fromString(rs.getString("cotacaoId"));
                String categoria = rs.getString("categoria");
                CotacaoStatus status = CotacaoStatus.valueOf(rs.getString("cotacaoStatus"));
                Instant dataCotacao = rs.getTimestamp("dataCotacao").toInstant();

                return new Cotacao(
                        cotacaoId,
                        Categoria.valueOf(categoria),
                        status,
                        dataCotacao,
                        null // Aqui você pode adicionar a lógica para preencher os itens, se necessário.
                );
            }
        };
    }

}
