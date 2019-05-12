package com.example.jpademo.bootstrap;

import com.example.jpademo.model.Ingredient;
import com.example.jpademo.model.Recipe;
import com.example.jpademo.model.notes;
import com.example.jpademo.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RecipeRepo recipeRepo;

    private List<Recipe> createRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        Recipe r1 = new Recipe();
        r1.setDescription("Perfekt guac");
        notes notes = new notes();
        notes.setNote("Avocado, hvidløg, citron, salt, peber");
        notes.setRecipe(r1);
        r1.setNotes(notes);
        recipes.add(r1);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Avocado");
        ingredient.setGrams(BigDecimal.valueOf(500));
        ingredient.setRecipe(r1);

        return recipes;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("context refreshed");
        recipeRepo.saveAll(createRecipes());
    }
}
