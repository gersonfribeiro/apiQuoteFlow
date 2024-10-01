// Nosso repositório de acesso a dados

package com.workspacepi.apiquoteflow.adapters.jdbc.enderecos;

import com.workspacepi.apiquoteflow.domain.enderecos.Endereco;
import com.workspacepi.apiquoteflow.domain.enderecos.EnderecoRepository;
import com.workspacepi.apiquoteflow.adapters.jdbc.enderecos.*;
import com.workspacepi.apiquoteflow.adapters.jdbc.enderecos.EnderecosSqlExpressions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
//import com.workspacepi.apiquoteflow.adapters.http.cotacoes.error.EnderecoErrorHandler;
import com.workspacepi.apiquoteflow.domain.enderecos.*;

import java.util.List;
import java.util.UUID;

import static com.workspacepi.apiquoteflow.adapters.jdbc.enderecos.EnderecosSqlExpressions.sqlSelectAllEnderecos;


// Nosso repositório que define os nossos métodos de query e de crud usando o JDBC

@Repository
public class EnderecosJDBCRepository implements EnderecoRepository {

    //  Um atributo para criar o nosso template do JDBC assim como o seu construtor

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public EnderecosJDBCRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Logger cuida do envio das nossas exceptions específicas ao invés das exceptions padrões

//    private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoErrorHandler.class);


//  Função da RowMapper para aproveitamento de código
//  Essa função é usada para mapear o resultado de uma consulta SQL

    private RowMapper<Endereco> createEnderecoRowMapper() {
            return (rs, rowNum) -> {
                String bairro_endereco = rs.getString("bairro_endereco");
                String cep_endereco = rs.getString("cep_enderco");
                String complemento_endereco = rs.getString("complemento_endereco");
                String localidade_endereco = rs.getString("localidade_endereco");
                String logradouro_endereco = rs.getString("logradouro_endereco");
                int numero_endereco = rs.getRow();
                String uf_endereco = rs.getString("uf_endereco");
                UUID id_empresa_endereco = UUID.fromString(rs.getString("id_empresa_endereco"));
                UUID id_endereco = UUID.fromString(rs.getString("id_endereco"));

                return new Endereco(bairro_endereco, cep_endereco, complemento_endereco, localidade_endereco, logradouro_endereco, numero_endereco, uf_endereco, id_empresa_endereco, id_endereco);
        };
    }

// Função para mapeamento dos parâmetros para as consultas sql

    private MapSqlParameterSource parameterSource(Endereco endereco){
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("bairro_endereco", endereco.getBairro_endereco());
        params.addValue("cep_endereco", endereco.getCep_endereco());
        params.addValue("complemento_endereco", endereco.getComplemento_endereco());
        params.addValue("localidade_endereco", endereco.getLocalidade_endereco());
        params.addValue("logradouro_endereco", endereco.getLogradouro_endereco());
        params.addValue("numero_endereco", endereco.getNumero_endereco());
        params.addValue("uf_endereco", endereco.getUf_endereco());
        params.addValue("id_empresa_endereco", endereco.getId_empresa_endereco());
        params.addValue("id_endereco", endereco.getId_endereco());
        return params;
    }

    @Override
    public List<Endereco> findAll() {
        List<Endereco> enderecos = List.of();
        try {
            enderecos = jdbcTemplate.query(sqlSelectAllEnderecos(), createEnderecoRowMapper());
            return enderecos;

        } catch (Exception e) {
//            LOGGER.error("Houve um erro ao consultar os endereços: " + e.getMessage());
            throw e;
        }
    }


    @Override
    public Endereco findById(UUID id_endereco) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Boolean modificarEndereco(Endereco endereco) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Boolean solicitarEndereco(Endereco endereco) {
        // TODO Auto-generated method stub
        return null;
    } 

}
