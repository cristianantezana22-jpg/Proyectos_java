package com.unifranz.programaciontres_cristian_antezana.infrastructure.persistence;

import com.unifranz.programaciontres_cristian_antezana.domain.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    List<Cancion> findByGenero(String genero);

}
