package com.caleb.library.services;

import com.caleb.library.dto.CourseDTO;
import com.caleb.library.dto.CourseWithStudentsDTO;
import com.caleb.library.entities.Course;
import com.caleb.library.repositories.CourseRepository;
import com.caleb.library.services.exceptions.DatabaseException;
import com.caleb.library.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public CourseDTO findById(Integer id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new CourseDTO(course);
    }

    @Transactional(readOnly = true)
    public CourseWithStudentsDTO findByIdWithStudents(Integer id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new CourseWithStudentsDTO(course);
    }

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(Pageable pageable){
        Page<Course> result = courseRepository.findAll(pageable);
        return result.map(x -> new CourseDTO(x));
    }

    @Transactional
    public CourseDTO insert(CourseDTO dto){
        Course entity = new Course();
        copyDtoToEntity(dto, entity);
        entity = courseRepository.save(entity);
        return new CourseDTO(entity);
    }

    @Transactional
    public CourseDTO update(Integer id, CourseDTO dto){
        try {
            Course entity = courseRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new CourseDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!courseRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            courseRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(CourseDTO dto, Course entity) {
        entity.setName(dto.getName());
    }

}
