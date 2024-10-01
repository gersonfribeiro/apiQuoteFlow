// Nosso arquivo para construir as nossas query em sql que serão usadas no JDBC repository
// Construíndo métodos staticos para que não seja necessário instânciar a classe

package com.workspacepi.apiquoteflow.adapters.jdbc.enderecos;

public class EnderecosSqlExpressions {
    public static String sqlSelectAllEnderecos(){
        return """
                    SELECT bairro_endereco,
                        cep_endereco,
                        complemento_endereco, 
                        localidade_endereco,
                        logradouro_endereco,
                        numero_endereco,
                        uf_endereco,
                        id_empresa_endereco,
                        id_endereco
                    FROM enderecos
                """;
    }

    public static String sqlSelectEnderecosById(){
        return """
                    SELECT bairro_endereco,
                        cep_endereco,
                        complemento_endereco, 
                        localidade_endereco,
                        logradouro_endereco,
                        numero_endereco,
                        uf_endereco,
                        id_empresa_endereco,
                        id_endereco
                    FROM enderecos
                    WHERE id_enderecos = :id_endereco
                """;
    
}
    public static String solicitarEndereco(){
        return """
                    INSERT INTO enderecos(
                        bairro_endereco,
                        cep_endereco,
                        complemento_endereco, 
                        localidade_endereco,
                        logradouro_endereco,
                        numero_endereco,
                        uf_endereco,
                        id_empresa_endereco,
                        id_endereco)
                        values (
                            :bairro_endereco,
                            :cep_endereco,
                            :complemento_endereco, 
                            :localidade_endereco,
                            :logradouro_endereco,
                            :numero_endereco,
                            :uf_endereco,
                            :id_empresa_endereco,
                            :id_endereco)    
                """;
    }

    public static String modificarEndereco(){
        return """
                    UPDATE enderecos 
                    SET bairro_endereco = :bairro_endereco,
                        cep_endereco = :cep_endereco,
                        complemento_endereco = :complemento_endereco,
                        localidade_endereco = :localidade_endereco,
                        logradouro_endereco = :logradouro_endereco,
                        numero_endereco = :numero_endereco,
                        uf_endereco = :uf_endereco,
                        id_empresa_endereco = :id_empresa_endereco,
                        id_endereco = :id_endereco
                    WHERE id_enderecos = :id_endereco
                """;
    }
}