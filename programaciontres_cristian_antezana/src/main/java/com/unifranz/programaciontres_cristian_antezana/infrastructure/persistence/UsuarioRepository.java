package com.unifranz.programaciontres_cristian_antezana.infrastructure.persistence;

import com.unifranz.programaciontres_cristian_antezana.domain.Usuario;
import com.unifranz.programaciontres_cristian_antezana.application.dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



    @Query("SELECT new com.unifranz.programaciontres_cristian_antezana.application.dto.UsuarioDto(u)"+
            " FROM Usuario u" +
            " WHERE u.eliminado = false")
    List<UsuarioDto> listarActivos();
}
