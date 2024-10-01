package com.workspacepi.apiquoteflow.application.usuarios.exceptions;

import java.util.UUID;

// Classe base para exceções de usuario
public abstract class UsuariosExceptions extends Exception {
    private final UUID usuarioId;

    public UsuariosExceptions(String mensagem, UUID usuarioId) {
        super(mensagem);
        this.usuarioId = usuarioId;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }
}
