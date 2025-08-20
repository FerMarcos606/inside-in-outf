package dev.fer.controller;

import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;
import dev.fer.views.MomentView;

import java.util.List;

public class MomentController {

    private MomentRepository repository;

    public MomentController(MomentRepository repository) {
        this.repository = repository;
    }

    // Mostrar todos los momentos
    public void getAllMoments() {
        List<Moment> moments = repository.getAllMoments();
        MomentView.printAllMoments(moments);
    }

    // Añadir un momento


    public void addMoment(Moment moment) {
        repository.addMoment(moment);
        System.out.println("Momento añadido correctamente.");
    }

    // Eliminar un momento
    public void deleteMoment(int id) {
        boolean removed = repository.deleteMomentById(id);
        if (removed) {
            System.out.println("Momento eliminado correctamente.");
        } else {
            System.out.println("No se encontró un momento con ese ID.");
        }
    }
}

