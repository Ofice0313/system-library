package com.caleb.library.services;

import com.caleb.library.dto.PublisherDTO;
import com.caleb.library.entities.Publisher;
import com.caleb.library.repositories.PublisherRepository;
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
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional(readOnly = true)
    public PublisherDTO findById(Integer id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new PublisherDTO(publisher);
    }

    @Transactional(readOnly = true)
    public Page<PublisherDTO> findAll(Pageable pageable){
        Page<Publisher> result = publisherRepository.findAll(pageable);
        return result.map(x -> new PublisherDTO(x));
    }

    @Transactional
    public PublisherDTO insert(PublisherDTO dto){
        Publisher entity = new Publisher();
        copyDtoToEntity(dto, entity);
        entity = publisherRepository.save(entity);
        return new PublisherDTO(entity);
    }

    @Transactional
    public PublisherDTO update(Integer id, PublisherDTO dto){
        try {
            Publisher entity = publisherRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new PublisherDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!publisherRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            publisherRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(PublisherDTO dto, Publisher entity) {
        entity.setName(dto.getName());
        entity.setSite(dto.getSite());
        entity.setContact(dto.getContact());
    }
}
