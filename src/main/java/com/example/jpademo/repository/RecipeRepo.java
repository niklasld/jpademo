package com.example.jpademo.repository;

import com.example.jpademo.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription(String description);
}
