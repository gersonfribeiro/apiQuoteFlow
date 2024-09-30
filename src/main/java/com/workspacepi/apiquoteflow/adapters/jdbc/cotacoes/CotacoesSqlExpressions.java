// Nosso arquivo para construir as nossas query em sql que serão usadas no JDBC repository
// Construíndo métodos staticos para que não seja necessário instânciar a classe

package com.workspacepi.apiquoteflow.adapters.jdbc.cotacoes;

public class CotacoesSqlExpressions {
    public static String sqlSelectAllQuotations() {
        return """
                    SELECT id_cotacao,
                        categoria,
                        data_solicitacao,
                        status,
                        id_autor
                    FROM cotacoes
                """;
    }

    public static String sqlSelectQuotationById() {
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

    public static String sqlModificarCotacao() {
        return """
                    UPDATE cotacoes
                    SET categoria = :categoria,
                         data_solicitacao = :data_solicitacao,
                         status = :status,
                         id_autor = :id_autor
                    WHERE id_cotacao = :id_cotacao
                """;
    }
}
