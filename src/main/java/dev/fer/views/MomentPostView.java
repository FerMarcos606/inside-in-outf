package dev.fer.views;
import dev.fer.model.Moment;
import dev.fer.controller.MomentController;
import dev.fer.model.ListEmotions;
import dev.fer.repositories.MomentRepository;
import java.time.LocalDate;

public class MomentPostView extends View {

    // Instancia directa del repositorio y del controlador
    private static MomentRepository repository = new MomentRepository();
    public static void printStoreMenu() {
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
        int emotionOption = SCANNER.nextInt();
        SCANNER.nextLine(); // Limpiar buffer

      Moment moment = new Moment(
    repository.getAllMoments().size() + 1, // id automático simple
    title,
    description,
        emotions[emotionOption - 1],
        date
    );

    repository.addMoment(moment); // este es el método correcto
    System.out.println("Momento vivido añadido correctamente.");

    }
}
