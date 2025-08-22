package dev.fer.services;

import dev.fer.model.ListEmotions;
import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MomentService {

    private final MomentRepository repository;
    private final AtomicInteger counter = new AtomicInteger(0); // para generar IDs únicos

    public MomentService(MomentRepository repository) {
        this.repository = repository;
    }

    // Agrega un momento y le asigna un ID único
     public Moment addMoment(Moment moment) {
         int newId = counter.incrementAndGet();
         moment.setId(newId);
        repository.store(moment);
         return moment;
     }

        // Devuelve todos los momentos
    public List<Moment> getAllMoments() {
        return repository.getAllMoments();
    }

    // Elimina un momento por ID
    public boolean deleteMoment(int id) {
        return repository.deleteMoment(id);
    }
     public List<Moment> filterByEmotion(ListEmotions emotion) {
        return repository.findByEmotion(emotion);
    }

    public List<Moment> filterByDate(LocalDate date) {
        return repository.findByMonthAndYear(date.getMonthValue(), date.getYear());
    }

}
