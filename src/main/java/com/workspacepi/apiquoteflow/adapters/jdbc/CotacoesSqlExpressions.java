package com.workspacepi.apiquoteflow.adapters.jdbc;

public class CotacoesSqlExpressions {
    public static String sqlSelectAll() {
        return """
                   SELECT id_cotacao,
                        categoria,
                        cotacaoStatus,
                        data_cotacao
                   FROM cotacoes
               """;
    }

    public static String sqlSelectById() {
        return """
                   SELECT id_cotacao,
                        categoria,
                        cotacaoStatus,
                        data_cotacao
                   FROM cotacoes
                   WHERE id = :id
               """;
    }
}
