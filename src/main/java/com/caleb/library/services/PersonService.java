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
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(readOnly = true)
    public PersonDTO findById(Integer id){
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new PersonDTO(person);
    }

    @Transactional(readOnly = true)
    public Page<PersonDTO> findAll(Pageable pageable){
        Page<Person> result = personRepository.findAll(pageable);
        return result.map(x -> new PersonDTO(x));
    }

    @Transactional
    public PersonDTO insert(PersonDTO dto){
        Person entity = new Person();
        copyDtoToEntity(dto, entity);
        entity = personRepository.save(entity);
        return new PersonDTO(entity);
    }

    @Transactional
    public PersonDTO update(Integer id, PersonDTO dto){
        try {
            Person entity = personRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new PersonDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!personRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            personRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(PersonDTO dto, Person entity) {
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
    }
}
