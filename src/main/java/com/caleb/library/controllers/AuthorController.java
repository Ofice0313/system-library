package com.caleb.library.controllers;

import com.caleb.library.dto.AuthorDTO;
import com.caleb.library.dto.PersonDTO;
import com.caleb.library.services.AuthorService;
import com.caleb.library.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable Integer id){
        AuthorDTO dto = authorService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<AuthorDTO>> findAll(Pageable pageable){
        Page<AuthorDTO> dto = authorService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> insert(@Validated @RequestBody AuthorDTO dto){
        dto = authorService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable Integer id, @Validated @RequestBody AuthorDTO dto){
        dto = authorService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AuthorDTO> delete(@PathVariable Integer id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
