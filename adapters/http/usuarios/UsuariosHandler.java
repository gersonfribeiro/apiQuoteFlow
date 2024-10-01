package com.workspacepi.apiquoteflow.adapters.http.usuarios;

import com.workspacepi.apiquoteflow.application.usuarios.UsuariosCreateCommand;
import com.workspacepi.apiquoteflow.application.usuarios.UsuariosService;
import com.workspacepi.apiquoteflow.application.usuarios.UsuariosUpdateCommand;
import com.workspacepi.apiquoteflow.domain.usuarios.Usuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UsuariosHandler {
    private final UsuariosService usuariosService;

    public UsuariosHandler(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    public ResponseEntity<List<Usuarios>> findAll() {
        List<Usuarios> usuario = usuariosService.findAll();
        return ResponseEntity.ok(usuario);
    }

    public ResponseEntity<Usuarios> findById(String usuarioId) throws Exception {
        Usuarios usuario = usuariosService.findById(UUID.fromString(usuarioId));
        return ResponseEntity.ok(usuario);
    }

    public ResponseEntity<Usuarios> cadastrarUsuario(UsuariosCreateCommand usuarioCreateCommand) throws Exception {
        Usuarios usuario = usuariosService.cadastrarUsuario(usuarioCreateCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    public ResponseEntity<Usuarios> modificarUsuario(UsuariosUpdateCommand usuarioUpdateCommand, String usuarioId) throws Exception {
        Usuarios usuario = usuariosService.modificarUsuario(usuarioUpdateCommand, UUID.fromString(usuarioId));
        return ResponseEntity.ok(usuario);
    }
}
