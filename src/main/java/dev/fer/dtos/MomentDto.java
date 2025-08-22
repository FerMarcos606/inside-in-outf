package dev.fer.dtos;
import dev.fer.model.ListEmotions;
import java.time.LocalDate;

public class MomentDto {
    
    private String title;
    private String description;
    private ListEmotions emotion;
    private LocalDate date;

    // Getters y setters (o puedes usar un record de Java si es 16+)
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ListEmotions getEmotion() { return emotion; }
    public void setEmotion(ListEmotions emotion) { this.emotion = emotion; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
