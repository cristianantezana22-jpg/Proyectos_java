package com.unifranz.programaciontres_cristian_antezana.application.service;

import com.unifranz.programaciontres_cristian_antezana.application.dto.UsuarioDto;
import java.util.List;

public interface UsuarioService {
    UsuarioDto guardar(UsuarioDto usuarioDto);
    List<UsuarioDto> listar();

}
