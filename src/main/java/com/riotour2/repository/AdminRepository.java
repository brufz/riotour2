package com.riotour2.repository;

import java.util.List;
import java.util.Optional;

import com.riotour2.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Long> {

    public Optional<AdminModel> findByEmail(String email);

}
