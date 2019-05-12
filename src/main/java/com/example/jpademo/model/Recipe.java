package com.example.jpademo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private notes notes;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    public Recipe() {

    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public com.example.jpademo.model.notes getNotes() {
        return notes;
    }

    public void setNotes(com.example.jpademo.model.notes notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
