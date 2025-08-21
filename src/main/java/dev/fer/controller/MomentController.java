package dev.fer.controller;
import dev.fer.views.MomentView;
import dev.services.MomentServices;
import dev.fer.model.Moment;
import java.util.List;

public class MomentController {

    private final MomentServices service service; // El controlador  depende de la capa de servicio

    public MomentController(MomentServices service) {
        this.service = service;
    }

      public void getAllMoments() {
        List<Moment> moments = service.getAllMoments(); // 
        MomentView.printAllMoments(moments);
    }

    // Añadir un momento
    public void addMoment(Moment moment) {
        service.addMoment(moment);
    }

    public boolean deleteMoment(int id) {
        return service.deleteMoment(id);
    }
}