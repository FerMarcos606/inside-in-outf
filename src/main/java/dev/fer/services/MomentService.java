package dev.fer.services;
import dev.fer.repositories.MomentRepository;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import dev.fer.model.Moment;

public class MomentService {

    private final MomentRepository repository;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public MomentService(MomentRepository repository) {
        this.repository = repository;
    }

    public List<Moment> getAllMoments() {
        return repository.getAllMoments();
    }

    // Método que vamos a completar
    public Moment addMoment(Moment moment) {
        // Genera un ID simple y se lo asigna al momento.
        moment.setId(counter.incrementAndGet());
        // Llama al repositorio para guardar el momento.
        repository.addMoment(moment);
        return moment;
    }

    public boolean deleteMoment(int id) {
        return repository.deleteMoment(id);
    }
}