package com.riotour2.repository;


import com.riotour2.model.PassageiroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassageiroRepository extends JpaRepository<PassageiroModel, Long> {
    public List<PassageiroModel> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
