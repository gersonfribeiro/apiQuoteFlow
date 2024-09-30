package com.workspacepi.apiquoteflow.adapters.http.usuarios;

import com.workspacepi.apiquoteflow.application.usuarios.UsuariosCreateCommand;
import com.workspacepi.apiquoteflow.application.usuarios.UsuariosUpdateCommand;
import com.workspacepi.apiquoteflow.domain.usuarios.Usuarios;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {
    private final UsuariosHandler usuariosHandler;

    public UsuariosController(UsuariosHandler usuariosHandler) {
        this.usuariosHandler = usuariosHandler;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuarios>> findAll() {
        return usuariosHandler.findAll();
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<Usuarios> findById(@PathVariable String usuarioId) throws Exception {
        return usuariosHandler.findById(usuarioId);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuarios> create(@RequestBody UsuariosCreateCommand usuarioCreateCommand) throws Exception {
        return usuariosHandler.cadastrarUsuario(usuarioCreateCommand);
    }

    @PutMapping("/usuarios/{usuarioId}")
    public ResponseEntity<Usuarios> create(@RequestBody UsuariosUpdateCommand usurioUpdateCommand, @PathVariable String usuarioId) throws Exception {
        return usuariosHandler.modificarUsuario(usurioUpdateCommand, usuarioId);
    }
}
