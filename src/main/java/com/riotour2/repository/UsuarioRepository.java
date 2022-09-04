package com.riotour2.repository;

import com.riotour2.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    public Optional<UsuarioModel> findByNomeUsuario(@Param("nomeUsuario") String nomeUsuario);
}

