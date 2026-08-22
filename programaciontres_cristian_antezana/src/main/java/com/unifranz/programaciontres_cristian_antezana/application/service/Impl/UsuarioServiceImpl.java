package com.unifranz.programaciontres_cristian_antezana.application.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.unifranz.programaciontres_cristian_antezana.infrastructure.persistence.UsuarioRepository;
import com.unifranz.programaciontres_cristian_antezana.application.dto.UsuarioDto;
import com.unifranz.programaciontres_cristian_antezana.domain.Usuario;
import com.unifranz.programaciontres_cristian_antezana.application.service.UsuarioService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto guardar (UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        Usuario guardar =   usuarioRepository.save(usuario);
        return new UsuarioDto(guardar.getId(),
                guardar.getNombre(),
                guardar.getEmail());
    }

    @Override
    public List<UsuarioDto> listar(){
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioDto(u.getId(), u.getNombre(), u.getEmail()))
                .collect(Collectors.toList());
    }
}
