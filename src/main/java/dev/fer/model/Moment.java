package dev.fer.model;


import java.time.LocalDate;

import java.time.LocalDate;
import dev.fer.model.ListEmotions;

public class Moment {
    private int id;
    private String title;
    private String description;
    private ListEmotions emotion; // <-- Tipo correcto
    private LocalDate date;
    private LocalDate creationDate;
    private LocalDate modificationDate;

    public Moment(int id, String title, String description, ListEmotions emotion, LocalDate date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion; // <-- Ya no hay error
        this.date = date;
        this.creationDate = LocalDate.now();
        this.modificationDate = LocalDate.now();
    }   

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
        this.modificationDate = LocalDate.now();
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
        this.modificationDate = LocalDate.now();
    }

     public ListEmotions getEmotion() {
        return emotion;
    }
    public void setEmotion(ListEmotions emotion) {
        this.emotion = emotion;
        this.modificationDate = LocalDate.now();
    }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) {
        this.date = date;
        this.modificationDate = LocalDate.now();
    }

    public LocalDate getCreationDate() { return creationDate; }
    public LocalDate getModificationDate() { return modificationDate; }

    @Override
    public String toString() {
        return "Ocurrió el: " + date +
               ". Título: " + title +
               ". Descripción: " + description +
               ". Emoción: " + emotion;
    }
}
