package com.riotour2.controller;

import com.riotour2.model.ViagemModel;
import com.riotour2.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RequestMapping("/viagem")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ViagemController {

    @Autowired
    public ViagemRepository viagemRepository;


    @GetMapping
    public ResponseEntity<List<ViagemModel>> getAll(){
        return ResponseEntity.ok(viagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViagemModel> getById(@PathVariable Long id){
        return viagemRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<ViagemModel>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(viagemRepository.findAllByTituloContainingIgnoreCase(titulo));

    }

    @GetMapping("/preco/precomin")
    public ResponseEntity<List<ViagemModel>> getAllByPrecoMin(){
        return ResponseEntity.ok(viagemRepository.findAllByOrderByPrecoAsc());
    }

    @GetMapping("/preco/precomax")
    public ResponseEntity<List<ViagemModel>> getAllByPrecoMax(){
        return ResponseEntity.ok(viagemRepository.findAllByOrderByPrecoDesc());
    }

    @PostMapping
    public ResponseEntity<ViagemModel> post(@RequestBody @Valid ViagemModel viagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(viagem));
    }

    //@PostMapping ("/foto/salvar")
    //public RedirectView salvarFoto (ViagemModel viagem,
      //                              @RequestParam("foto") MultipartFile multipartFile) throws IOException {

        //String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        //ViagemModel salvarFoto = viagemRepository.save(viagem);

        //String uploadDir = "Admin-fotos/";

        //FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        //return new RedirectView("/users", true);
    //}

    @PutMapping
    public ResponseEntity<ViagemModel> put(@RequestBody @Valid ViagemModel viagem){
        return viagemRepository.findById(viagem.getId()).map(resp -> {
            return ResponseEntity.ok().body(viagemRepository.save(viagem));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Long id){
        return viagemRepository.findById(id).map(resp -> {
            viagemRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
