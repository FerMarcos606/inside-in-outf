package dev.fer.views;

import dev.fer.controller.MomentController;


public class HomeView extends View {

    private static MomentController CONTROLLER = MomentController.getInstance();

    public static void printMenu() {
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
            case 1 -> MomentPostView.printStoreMenu();
            case 2 -> CONTROLLER.getAllMoments();
            //Falta agregar los  métodos añadir, eliminar, modificar emotions y filtrar por emotion y date 
            case 5 -> System.out.println("Hasta la próxima!!!");
            default -> {
                System.out.println("Opción no válida");
                printMenu();
            }
        }
    }
}
