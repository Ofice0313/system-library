package com.caleb.library.services;

import com.caleb.library.dto.CategoryDTO;
import com.caleb.library.entities.Category;
import com.caleb.library.repositories.CategoryRepository;
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
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public CategoryDTO findById(Integer id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new CategoryDTO(category);
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAll(Pageable pageable){
        Page<Category> result = categoryRepository.findAll(pageable);
        return result.map(x -> new CategoryDTO(x));
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto){
        Category entity = new Category();
        copyDtoToEntity(dto, entity);
        entity = categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Integer id, CategoryDTO dto){
        try {
            Category entity = categoryRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new CategoryDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!categoryRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(CategoryDTO dto, Category entity) {
        entity.setTypeCategory(dto.getTypeCategory());
    }

}
