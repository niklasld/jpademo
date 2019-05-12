package com.example.jpademo.model;

import javax.persistence.*;

@Entity
public class notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String note;

    public notes() {
    }

    @OneToOne
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
