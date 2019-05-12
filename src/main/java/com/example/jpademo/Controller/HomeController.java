package com.example.jpademo.Controller;

import com.example.jpademo.model.Recipe;
import com.example.jpademo.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private RecipeRepo recipeRepo;

    @GetMapping("/")
    private String home() {
        Optional<Recipe> recipe = recipeRepo.findByDescription("Perfekt guac");
        if(recipe.isPresent()) {
            System.out.println("Fandt; "+recipe.get().getDescription());
        }
        else {
            System.out.println("Fandt ingen opskrift");
        }
        return "index";
    }
}
