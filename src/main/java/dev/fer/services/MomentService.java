package dev.fer.services;

import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;
import java.util.List;

public class MomentService {

    private final MomentRepository repository;

    public MomentService(MomentRepository repository) {
        this.repository = repository;
    }

    public List<Moment> getAllMoments() {
        // Por ahora, solo devuelve el resultado del repositorio
        return repository.getAllMoments();
    }

    public void addMoment(Moment moment) {
        // La lógica de negocio irá aquí más tarde.
        // Por ahora, solo delega la tarea al repositorio.
        repository.addMoment(moment);
    }

    public boolean deleteMoment(int id) {
        // La lógica de negocio irá aquí más tarde.
        // Por ahora, solo delega la tarea al repositorio.
        return repository.deleteMoment(id);
    }
}