package com.workspacepi.apiquoteflow.adapters.jdbc;

public class CotacoesSqlExpressions {
    public static String sqlSelectAll() {
        return """
                   SELECT id_cotacao,
                        categoria,
                        cotacaoStatus,
                        data_cotacao
                   from cotacoes
               """;
    }
}
