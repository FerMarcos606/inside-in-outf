package dev.fer.views;
import java.time.LocalDate;
import dev.fer.model.Moment;
import dev.fer.model.ListEmotions; 

public class MomentPostView extends View {

    public static Moment createMomentFromInput() {
        System.out.println("Ingrese el título:");
        String title = SCANNER.nextLine();

        System.out.println("Ingrese la fecha (yyyy-mm-dd):");
        String dateStr = SCANNER.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        System.out.println("Ingrese la descripción:");
        String description = SCANNER.nextLine();

        // Mostrar emociones
        String[] emotions = {
            "ALEGRIA", "TRISTEZA", "IRA", "ASCO", "MIEDO",
            "ANSIEDAD", "ENVIDIA", "VERGUENZA", "ABURRIMIENTO", "NOSTALGIA"
        };
        for (int i = 0; i < emotions.length; i++) {
            System.out.println((i + 1) + ". " + emotions[i]);
        }
        System.out.println("Seleccione el número de la emoción:");
        int emotionOption = SCANNER.nextInt();
        SCANNER.nextLine(); // Limpiar buffer

        // Convertir la cadena de texto a un enum ListEmotions
        String emotionString = emotions[emotionOption - 1];
        ListEmotions selectedEmotion = ListEmotions.valueOf(emotionString);

        // La vista crea el objeto Moment con el enum
        Moment moment = new Moment(
            0, // Usamos 0 como un ID temporal que el servicio reemplazará
            title,
            description,
            selectedEmotion, // Pasamos el enum, no la cadena de texto
            date
        );

        return moment;
    }
}
