package com.workspacepi.apiquoteflow.application.usuarios;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.workspacepi.apiquoteflow.domain.cotacao.Categoria;
import com.workspacepi.apiquoteflow.domain.cotacao.Cotacao;
import com.workspacepi.apiquoteflow.domain.cotacao.CotacaoStatus;
import com.workspacepi.apiquoteflow.domain.cotacao.ItensCotacao;
import com.workspacepi.apiquoteflow.domain.usuarios.Usuarios;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

//  Usando Jackson para serialização
public class UsuariosCreateCommand {

    @JsonProperty("nome_usuario")
    private String nome_usuario;

    @JsonProperty("email_usuario")
    private String email_usuario;


    @JsonProperty("senha_usuario")
    private String senha_usuario;

//  Conversão para usuario
    public Usuarios toUsuario() {
        return new Usuarios(nome_usuario, email_usuario, senha_usuario);
    }

//  Getters e setters

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
}
