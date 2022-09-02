package com.riotour2.repository;

import java.util.List;

import com.riotour2.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Long> {

    public List<AdminModel> findByEmail(String email);

}
