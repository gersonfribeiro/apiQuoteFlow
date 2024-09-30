package com.workspacepi.apiquoteflow.application.usuarios;

import com.workspacepi.apiquoteflow.application.usuarios.exceptions.UsuarioNaoEncontradoException;
import com.workspacepi.apiquoteflow.domain.usuarios.Usuarios;
import com.workspacepi.apiquoteflow.domain.usuarios.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    public Usuarios findById(UUID usuarioId) throws Exception {
        Usuarios usuario = usuariosRepository.findById(usuarioId);

        if (usuario == null)
            throw new Exception("Usuario no encontrado");

        return usuario;
    }

    public Usuarios cadastrarUsuario(UsuariosCreateCommand usuarioCreateCommand) throws Exception {
        Usuarios usuarioDomain = usuarioCreateCommand.toUsuario();
        usuariosRepository.cadastrarUsuario(usuarioDomain);

        return findById(usuarioDomain.getId_usuario());
    }

    public Usuarios modificarUsuario(UsuariosUpdateCommand usuarioUpdateCommand, UUID usuarioId) throws Exception {
        Usuarios usuarioDomain = usuariosRepository.findById(usuarioId);

        if (usuarioDomain == null)
            throw new UsuarioNaoEncontradoException(usuarioId);

        usuariosRepository.modificarUsuario(usuarioUpdateCommand.toUsuario(usuarioId));
        return findById(usuarioId);
    }
}
