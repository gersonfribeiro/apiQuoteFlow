package com.workspacepi.apiquoteflow.adapters.jdbc;


import com.workspacepi.apiquoteflow.domain.cotacao.Categoria;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoRepository;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static com.workspacepi.apiquoteflow.adapters.jdbc.CotacoesSqlExpressions.sqlSelectAll;

@Repository
public class CotacoesJDBCRepository implements CotacaoRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CotacoesJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cotacao> findAll() {
        return jdbcTemplate.query(sqlSelectAll(), new RowMapper<Cotacao>() {
            @Override
            public Cotacao mapRow(ResultSet rs, int rowNum) throws SQLException {
                UUID cotacaoId = UUID.fromString(rs.getString("cotacaoId"));
                String categoria = rs.getString("categoria");
                String status = rs.getString("cotacaoStatus");
                Instant dataCotacao = rs.getTimestamp("dataCotacao").toInstant();

                return new Cotacao(
                        cotacaoId,
                        Categoria.valueOf(categoria),
                        CotacaoStatus.valueOf(rs.getString("status")),
                        dataCotacao,
                        null
                        );
            }
        });
    }
}
