package com.riotour2.controller;

import com.riotour2.model.UsuarioModel;
import com.riotour2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/usuario")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAll() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<UsuarioModel>> getByTitulo(@PathVariable String nome) {
        return ResponseEntity.ok(usuarioRepository.findAllByNomeContainingIgnoreCase(nome));

    }


    @PostMapping
    public ResponseEntity<UsuarioModel> post(@RequestBody @Valid UsuarioModel usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<UsuarioModel> put(@RequestBody @Valid UsuarioModel usuario) {
        return usuarioRepository.findById(usuario.getId()).map(resp -> {
            return ResponseEntity.ok().body(usuarioRepository.save(usuario));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return usuarioRepository.findById(id).map(resp -> {
            usuarioRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
