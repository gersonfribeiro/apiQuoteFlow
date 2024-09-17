// Nosso arquivo para construir as nossas query em sql que serão usadas no JDBC repository
// Construíndo métodos staticos para que não seja necessário instânciar a classe

package com.workspacepi.apiquoteflow.adapters.jdbc;

public class CotacoesSqlExpressions {
    public static String sqlSelectAll() {
        return """
                   SELECT id_cotacao,
                        categoria,
					    data_solicitacao,
                        status,
					    id_autor
                   FROM cotacoes
                """;
    }

    public static String sqlSelectById() {
        return """
                   SELECT id_cotacao,
                        categoria,
                        data_solicitacao,
                        status,
                        id_autor
                   FROM cotacoes
                   WHERE id_cotacao = :id_cotacao
               """;
    }

    public static String sqlSolicitarCotacao() {
        return """
                    INSERT INTO cotacoes(
                        id_cotacao,
                        categoria,
                        data_solicitacao,
                        status,
                        id_autor)
                        values (
                            :id_cotacao,
                            :categoria,
                            :data_solicitacao,
                            :status,
                            :id_autor)
               """;
    }
}
