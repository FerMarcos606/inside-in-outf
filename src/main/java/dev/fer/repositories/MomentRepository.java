package dev.fer.repositories;

import dev.fer.model.Moment;
import java.util.ArrayList;
import java.util.List;

public class MomentRepository {

    private final List<Moment> moments = new ArrayList<>();

    // Añadir un momento
    public void store(Moment moment) {
        moments.add(moment);
    }

    // Recuperar todos los momentos
    public List<Moment> getAll() {
        return new ArrayList<>(moments); // devolvemos copia para evitar modificar la lista interna
    }

    // Extra: obtener tamaño de la lista
    public int size() {
        return moments.size();
    }
}
