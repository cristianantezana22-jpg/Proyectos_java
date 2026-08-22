package com.unifranz.programaciontres_cristian_antezana.application.service.Impl;

import com.unifranz.programaciontres_cristian_antezana.application.service.EventoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventoServiceImpl implements EventoService {

    @Override
    public Map<String, Object> MostrarCambio (double dinero, double cambio){
        double total = 0.0;
        String advertencia = "Todo correcto";

        if (dinero <= 0 || cambio <= 0) {
            advertencia = "el dinero y el cambio deben ser mayores a 0";
        } else {
            total = dinero * cambio;;
        }
        Map<String, Object> salida = new HashMap<>();
        salida.put("Total", total);
        salida.put("motivo", advertencia);

        return salida;
    }

}
