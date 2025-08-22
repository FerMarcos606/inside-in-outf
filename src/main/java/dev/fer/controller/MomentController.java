package dev.fer.controller;

import dev.fer.services.MomentService;
import dev.fer.views.MomentView;
import dev.fer.model.ListEmotions;
import dev.fer.model.Moment;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class MomentController {

    private static MomentController instance;

    private final MomentService service;

    // Constructor privado que recibe el servicio
    public MomentController(MomentService service) {
    this.service = service;
    }

    // Método estático que recibe el servicio y devuelve la única instancia
    public static MomentController getInstance(MomentService service) {
        if (instance == null) {
            instance = new MomentController(service);
        }
        return instance;
    }
    
    // Tus otros métodos
    public void getAllMoments() {
        List<Moment> moments = service.getAllMoments();
        MomentView.printAllMoments(moments);
    }

    public void addMoment(Moment moment) {
        service.addMoment(moment);
    }
       

    public boolean deleteMoment(int id) {
    return service.deleteMoment(id);
    }

     public void filterMomentsByEmotion(String emotionString) {
        try {
            ListEmotions emotion = ListEmotions.valueOf(emotionString.toUpperCase());
            List<Moment> filteredMoments = service.filterByEmotion(emotion);
            MomentView.printAllMoments(filteredMoments);
        } catch (IllegalArgumentException e) {
            System.out.println("La emoción '" + emotionString + "' no es válida. Por favor, intente de nuevo.");
        }
    }
    
    public void filterMomentsByDate(String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString);
            List<Moment> filteredMoments = service.filterByDate(date);
            MomentView.printAllMoments(filteredMoments);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha no válido. Por favor, use el formato yyyy-mm-dd.");
        }
    }

}