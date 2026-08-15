package com.unifranz.programaciontres_cristian_antezana.infrastructure.web.controller;


import com.unifranz.programaciontres_cristian_antezana.application.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.JsonNode;

import java.util.Map;

@RestController
@RequestMapping("api/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;
    @PostMapping("/MostrarCambio")
    public Map<String, Object> MostrarCambio (@RequestBody JsonNode entrada) {
        int dinero = entrada.get("dinero").asInt();
        int cambio = entrada.get("cambio").asInt();
        return eventoService.MostrarCambio(dinero, cambio);
    }
}
