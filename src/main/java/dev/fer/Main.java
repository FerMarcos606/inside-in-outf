package dev.fer;

import dev.fer.controller.HomeController;

/**
 * Hello world!
 */
// public final class App {
//     private App() {
//     }

//     /**
//      * Says hello to the world.
//      * @param args The arguments of the program.
//      */
//     public static void main(String[] args) {
//         System.out.println("Hello World!");
//     }
// }


import dev.fer.controller.MomentController;
import dev.fer.repositories.MomentRepository;
import dev.fer.services.MomentService;
import dev.fer.views.HomeView;

public class Main {
    public static void main(String[] args) {
        // 1. Crear el repositorio (la "base de datos" simulada)
        MomentRepository repository = new MomentRepository();
        
        // 2. Crear el servicio y pasarle el repositorio
        MomentService service = new MomentService(repository);

        // 3. Crear el controlador de momentos y pasarle el servicio
        MomentController momentController = new MomentController(service);

        // 4. Crear la vista y pasarle el controlador de momentos
        HomeView homeView = new HomeView(momentController);
        
        // 5. Crear el controlador principal y pasarle la vista
        HomeController homeController = new HomeController(homeView);

        // 6. Iniciar la aplicación a través del controlador principal
        homeController.index();
    }
}