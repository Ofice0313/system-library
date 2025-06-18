package com.caleb.library.controllers;

import com.caleb.library.dto.CourseDTO;
import com.caleb.library.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Integer id){
        CourseDTO dto = courseService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> findAll(Pageable pageable){
        Page<CourseDTO> dto = courseService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> insert(@Validated @RequestBody CourseDTO dto){
        dto = courseService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Integer id, @Validated @RequestBody CourseDTO dto){
        dto = courseService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> delete(@PathVariable Integer id){
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
