package com.caleb.library.services;

import com.caleb.library.dto.BookDTO;
import com.caleb.library.entities.Book;
import com.caleb.library.repositories.BookRepository;
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
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public BookDTO findById(Integer id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new BookDTO(book);
    }

    @Transactional(readOnly = true)
    public Page<BookDTO> findAll(Pageable pageable){
        Page<Book> result = bookRepository.findAll(pageable);
        return result.map(x -> new BookDTO(x));
    }

    @Transactional
    public BookDTO insert(BookDTO dto){
        Book entity = new Book();
        copyDtoToEntity(dto, entity);
        entity = bookRepository.save(entity);
        return new BookDTO(entity);
    }

    @Transactional
    public BookDTO update(Integer id, BookDTO dto){
        try {
            Book entity = bookRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new BookDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id){
        if(!bookRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            bookRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential Integrity Failure!");
        }
    }

    private void copyDtoToEntity(BookDTO dto, Book entity) {
        entity.setTitle(dto.getTitle());
        entity.setCaption(dto.getCaption());
        entity.setCdu(dto.getCdu());
        entity.setIsbn(dto.getIsbn());
        entity.setCountryPublished(dto.getCountryPublished());
        entity.setLanguage(dto.getLanguage());
        entity.setMatter(dto.getMatter());
        entity.setYearOfEdition(dto.getYearOfEdition());
    }
}
