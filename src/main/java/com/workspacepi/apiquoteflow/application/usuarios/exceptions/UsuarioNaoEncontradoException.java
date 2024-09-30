package com.workspacepi.apiquoteflow.application.usuarios.exceptions;

import java.util.UUID;

// Exceção específica para quando um usuario não for encontrado
public class UsuarioNaoEncontradoException extends UsuariosExceptions {

    public UsuarioNaoEncontradoException(UUID usuarioId) {
        super("Cotacao " + usuarioId + " não encontrada", usuarioId);
    }
}
