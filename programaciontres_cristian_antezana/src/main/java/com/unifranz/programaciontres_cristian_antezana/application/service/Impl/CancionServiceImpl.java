package com.unifranz.programaciontres_cristian_antezana.application.service.Impl;

import com.unifranz.programaciontres_cristian_antezana.application.dto.CancionDto;
import com.unifranz.programaciontres_cristian_antezana.application.service.CancionService;
import com.unifranz.programaciontres_cristian_antezana.domain.Cancion;
import com.unifranz.programaciontres_cristian_antezana.infrastructure.persistence.CancionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CancionServiceImpl implements CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    @Override
    public CancionDto guardar (CancionDto cancionDto){
        Cancion cancion = new Cancion();
        cancion.setNombre(cancionDto.getNombre());
        cancion.setGenero(cancionDto.getGenero());
        Cancion guardar =   cancionRepository.save(cancion);
        return new CancionDto(guardar.getId(),
                guardar.getNombre(),
                guardar.getGenero());
    }

    @Override
    public List<CancionDto> listar(){
        return cancionRepository.findAll()
                .stream()
                .map(c -> new CancionDto(c.getId(), c.getNombre(), c.getGenero()))
                .collect(Collectors.toList());
    }
}
