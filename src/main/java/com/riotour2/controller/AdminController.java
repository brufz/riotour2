package com.riotour2.controller;

import com.riotour2.model.AdminModel;
import com.riotour2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    private ResponseEntity<List<AdminModel>> getAll(){
        return ResponseEntity.ok(adminRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<AdminModel> post(@RequestBody @Valid AdminModel admin){
        return ResponseEntity.status(HttpStatus.CREATED).body(adminRepository.save(admin));
    }

    @PutMapping
    public ResponseEntity<AdminModel> put(@RequestBody @Valid AdminModel admin){
        return adminRepository.findById(admin.getId()).map(resp -> {
            return ResponseEntity.ok().body(adminRepository.save(admin));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }

}
