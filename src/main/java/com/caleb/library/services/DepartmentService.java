package com.caleb.library.services;

import com.caleb.library.dto.*;
import com.caleb.library.entities.*;
import com.caleb.library.repositories.*;
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
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Integer id){
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new DepartmentDTO(department);
    }

    @Transactional(readOnly = true)
    public DepartmentWithEmployeesDTO findByIdWithEmployees(Integer id){
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new DepartmentWithEmployeesDTO(department);
    }

    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findAll(Pageable pageable){
        Page<Department> result = departmentRepository.findAll(pageable);
        return result.map(x -> new DepartmentDTO(x));
    }

    @Transactional
    public DepartmentDTO insert(DepartmentDTO dto){
        Department entity = new Department();
        copyDtoToEntity(dto, entity);
        entity = departmentRepository.save(entity);
        return new DepartmentDTO(entity);
    }

    @Transactional
    public DepartmentDTO update(Integer id, DepartmentDTO dto){
        try {
            Department entity = departmentRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new DepartmentDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!departmentRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            departmentRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }

}
