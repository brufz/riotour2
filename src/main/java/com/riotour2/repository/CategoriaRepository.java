package com.riotour2.repository;

import com.riotour2.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    public List<CategoriaModel> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
