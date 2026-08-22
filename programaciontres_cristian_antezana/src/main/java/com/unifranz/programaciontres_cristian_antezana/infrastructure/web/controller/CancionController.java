package com.unifranz.programaciontres_cristian_antezana.infrastructure.web.controller;

import com.unifranz.programaciontres_cristian_antezana.application.dto.CancionDto;
import com.unifranz.programaciontres_cristian_antezana.application.service.CancionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    @PostMapping
    public ResponseEntity<CancionDto> guardar (@RequestBody CancionDto cancionDto){
        CancionDto cancion = cancionService.guardar(cancionDto);
        return ResponseEntity.ok(cancion);
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<CancionDto>> listarCanciones(@PathVariable String genero){
        return ResponseEntity.ok(cancionService.listar(genero));
    }
}
