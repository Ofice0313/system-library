package com.caleb.library.repositories;

import com.caleb.library.entities.Category;
import com.caleb.library.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
