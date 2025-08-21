package dev.fer.controller;

import dev.fer.services.MomentService;
import dev.fer.views.MomentView;
import dev.fer.model.Moment;

import java.util.List;

public class MomentController {

    // 1. Instancia única de la clase (Singleton)
    private static MomentController instance;

    // 2. Dependencia de la capa de servicio
    private final MomentService service;

    // 3. Constructor privado para evitar que se cree desde fuera
    private MomentController() {
        // Aquí se crea la dependencia.
        // Es una forma básica de Inyección de Dependencias???.
        this.service = new MomentService();
    }

    // 4. Método estático para obtener la única instancia de la clase
    public static MomentController getInstance() {
        if (instance == null) {
            instance = new MomentController();
        }
        return instance;
    }

    // 5. Métodos que usan el servicio
    public void getAllMoments() {
        List<Moment> moments = service.getAllMoments();
        MomentView.printAllMoments(moments);
    }

    public void addMoment(Moment moment) {
        service.addMoment(moment);
    }

    public void deleteMoment(int id) {
        service.deleteMoment(id);
    }
}