package dev.fer.views;


import dev.fer.controller.MomentController;

public class HomeView extends View {

    private final MomentController controller;

    public HomeView(MomentController controller) {
        this.controller = controller;
    }

    public void printMenu() {
        String text = """
                My diario:
                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Salir
                ----------------------
                Seleccione una opción:
                """;

            System.out.print(text);
            int option = SCANNER.nextInt();
            SCANNER.nextLine(); // Consumir el salto de línea pendiente

            switch (option) {
            case 1 -> {
                // Aquí, el view delega al controlador la lógica para agregar un momento.
                this.controller.addMoment(MomentPostView.createMomentFromInput());
                this.printMenu(); // Vuelve a mostrar el menú después de la operación.
            }
            case 2 -> {
                this.controller.getAllMoments();
                this.printMenu(); // Vuelve a mostrar el menú después de la operación.
            }
            case 3 -> {
                {
            System.out.println("Ingrese el ID del momento a eliminar:");
            int idToDelete = SCANNER.nextInt();
            SCANNER.nextLine(); // Consumir el salto de línea pendiente

            System.out.println("¿Está seguro de que quiere eliminar este momento? (s/n)");
            String confirmation = SCANNER.nextLine();

            if (confirmation.equalsIgnoreCase("s")) {
                boolean wasDeleted = this.controller.deleteMoment(idToDelete);
                if (wasDeleted) {
                    System.out.println("El momento se ha borrado con éxito.");
                } else {
                    System.out.println("No se encontró ningún momento con ese ID.");
                }
            } else {
                    System.out.println("Operación cancelada.");
            }
            this.printMenu();
                }
            }

            // ... (código anterior del switch) ...

            case 4 -> {
                System.out.println("¿Cómo desea filtrar los momentos?");
                System.out.println("1. Por emoción");
                System.out.println("2. Por fecha");
                System.out.print("Seleccione una opción: ");

                int filterOption = SCANNER.nextInt();
                SCANNER.nextLine(); // Consumir el salto de línea

                switch (filterOption) {
                    case 1 -> {
                        System.out.println("Escribe la emoción (ALEGRIA, TRISTEZA, IRA, etc.):");
                        String emotion = SCANNER.nextLine();
                        this.controller.filterMomentsByEmotion(emotion);
                    }
                    case 2 -> {
                        System.out.println("Escribe la fecha (yyyy-mm-dd):");
                        String date = SCANNER.nextLine();
                        this.controller.filterMomentsByDate(date);
                    }
                    default -> System.out.println("Opción de filtro no válida.");
                }
                this.printMenu();
            }


            // Agrega los otros casos aquí
            case 5 -> System.out.println("Hasta la próxima!!!");
            default -> {
                System.out.println("Opción no válida");
                this.printMenu();
            }
        }
    }
}
