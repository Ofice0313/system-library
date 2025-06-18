package com.caleb.library.controllers;

import com.caleb.library.dto.PublisherDTO;
import com.caleb.library.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PublisherDTO> findById(@PathVariable Integer id){
        PublisherDTO dto = publisherService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<PublisherDTO>> findAll(Pageable pageable){
        Page<PublisherDTO> dto = publisherService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PublisherDTO> insert(@Validated @RequestBody PublisherDTO dto){
        dto = publisherService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PublisherDTO> update(@PathVariable Integer id, @Validated @RequestBody PublisherDTO dto){
        dto = publisherService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PublisherDTO> delete(@PathVariable Integer id){
        publisherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
