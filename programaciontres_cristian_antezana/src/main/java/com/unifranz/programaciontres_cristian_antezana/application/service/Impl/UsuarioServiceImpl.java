package com.unifranz.programaciontres_cristian_antezana.application.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.unifranz.programaciontres_cristian_antezana.infrastructure.persistence.UsuarioRepository;
import com.unifranz.programaciontres_cristian_antezana.application.dto.UsuarioDto;
import com.unifranz.programaciontres_cristian_antezana.domain.Usuario;
import com.unifranz.programaciontres_cristian_antezana.application.service.UsuarioService;
import com.unifranz.programaciontres_cristian_antezana.domain.UsuarioAdmin;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {

        Usuario usuario;

        if (usuarioDto.getFlagAdmin()) {
            usuario = new UsuarioAdmin();
        } else {
            usuario = new Usuario();
        }

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setFlagAdmin(usuarioDto.getFlagAdmin());
        usuario.setEliminado(false);

        Usuario guardar = usuarioRepository.save(usuario);

        return new UsuarioDto(guardar);
    }

    @Override
    public List<UsuarioDto> listar(){
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDto(u))
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDto> listarActivos(){
        return usuarioRepository.listarActivos();
    }

    @Override
        public UsuarioDto editar(Long id, UsuarioDto usuarioDto) {
            Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // Si eliminado es null o true
        if (Boolean.TRUE.equals(usuario.getEliminado())) {
            throw new IllegalStateException("No se puede editar un usuario eliminado.");
        }

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        if (usuarioDto.getFlagAdmin() != null) {
            usuario.setFlagAdmin(usuarioDto.getFlagAdmin());
        }

        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return new UsuarioDto(usuarioActualizado);
    }

    @Override
    public void eliminarLogico(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // Marcar como eliminado en lugar de usar usuarioRepository.delete(usuario)
        usuario.setEliminado(true);
        usuarioRepository.save(usuario);
    }
}
