package com.unifranz.programaciontres_cristian_antezana.infrastructure.persistence;

import com.unifranz.programaciontres_cristian_antezana.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
