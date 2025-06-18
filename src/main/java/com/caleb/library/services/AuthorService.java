package com.caleb.library.services;

import com.caleb.library.dto.AuthorDTO;
import com.caleb.library.entities.Author;
import com.caleb.library.repositories.AuthorRepository;
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
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public AuthorDTO findById(Integer id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new AuthorDTO(author);
    }

    @Transactional(readOnly = true)
    public Page<AuthorDTO> findAll(Pageable pageable){
        Page<Author> result = authorRepository.findAll(pageable);
        return result.map(x -> new AuthorDTO(x));
    }

    @Transactional
    public AuthorDTO insert(AuthorDTO dto){
        Author entity = new Author();
        copyDtoToEntity(dto, entity);
        entity = authorRepository.save(entity);
        return new AuthorDTO(entity);
    }

    @Transactional
    public AuthorDTO update(Integer id, AuthorDTO dto){
        try {
            Author entity = authorRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new AuthorDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!authorRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            authorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(AuthorDTO dto, Author entity) {
        entity.setName(dto.getName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setNationality(dto.getNationality());
    }
}
