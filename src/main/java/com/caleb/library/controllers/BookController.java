package com.caleb.library.controllers;

import com.caleb.library.dto.BookDTO;
import com.caleb.library.dto.BookPublisherAuthorCategoryDTO;
import com.caleb.library.dto.BookPublisherAuthorDTO;
import com.caleb.library.dto.BookPublisherDTO;
import com.caleb.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Integer id){
        BookDTO dto = bookService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<BookDTO>> findAll(Pageable pageable){
        Page<BookDTO> dto = bookService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    //@PostMapping
    public ResponseEntity<BookDTO> insert(@Validated @RequestBody BookDTO dto){
        dto = bookService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //@PostMapping
    public ResponseEntity<BookPublisherDTO> insert(@RequestBody BookPublisherDTO dto){
        dto = bookService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //@PostMapping
    public ResponseEntity<BookPublisherAuthorDTO> insert(@RequestBody BookPublisherAuthorDTO dto){
        dto = bookService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping
    public ResponseEntity<BookPublisherAuthorCategoryDTO> insert(@RequestBody BookPublisherAuthorCategoryDTO dto){
        dto = bookService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    //@PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Integer id, @Validated @RequestBody BookDTO dto){
        dto = bookService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookPublisherDTO> update(@PathVariable Integer id, @Validated @RequestBody BookPublisherDTO dto){
        dto = bookService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookDTO> delete(@PathVariable Integer id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
