package com.riotour2.repository;

import com.riotour2.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    public List<UsuarioModel> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}

