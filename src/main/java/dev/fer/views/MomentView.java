package dev.fer.views;

import dev.fer.model.Moment;
import java.util.List;

public class MomentView {

    public static void printAllMoments(List<Moment> moments) {
        if (moments.isEmpty()) {
            System.out.println("No hay momentos registrados aún.");
            return;
        }

        for (Moment moment : moments) {
            System.out.println("-------------------------");
            System.out.println("ID: " + moment.getId());
            System.out.println("Título: " + moment.getTitle());
            System.out.println("Descripción: " + moment.getDescription());
            System.out.println("Emoción: " + moment.getEmotion());
            System.out.println("Fecha: " + moment.getDate());
            System.out.println("Creado: " + moment.getCreationDate());
            System.out.println("Modificado: " + moment.getModificationDate());
        }
        System.out.println("-------------------------");
    }
}
