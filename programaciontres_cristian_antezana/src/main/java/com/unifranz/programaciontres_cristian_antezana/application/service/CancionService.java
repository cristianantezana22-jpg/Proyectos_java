package com.unifranz.programaciontres_cristian_antezana.application.service;

import com.unifranz.programaciontres_cristian_antezana.application.dto.CancionDto;
import java.util.List;

public interface CancionService {
    CancionDto guardar(CancionDto CancionDto);
    List<CancionDto> listar();

}
