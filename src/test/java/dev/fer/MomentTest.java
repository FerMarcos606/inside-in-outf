package dev.fer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dev.fer.model.ListEmotions;
import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;

import java.time.LocalDate;


public class MomentTest {

    @Test
    void repositoryStartsEmpty() {
        MomentRepository repository = new MomentRepository();
        assertTrue(repository.getAll().isEmpty(), 
                   "El repositorio debería empezar vacío");
    }

     @Test
     void storeMomentAddsMomentToRepository() {
        // 1. Arrange (Preparar el escenario)
        MomentRepository repository = new MomentRepository();
         Moment moment = new Moment(1, "Cumpleaños", "Fiesta con amigos", ListEmotions.ALEGRIA, LocalDate.now());
        
        // 2. Act (Ejecutar la acción a probar)
        repository.store(moment);

        // 3. Assert (Verificar el resultado)
        assertEquals(1, repository.getAll().size(), "El repositorio debería tener un momento");
        assertEquals("Cumpleaños", repository.getAll().get(0).getTitle(), "El título del momento debería coincidir");
    }
    
    Para garantizar que tu código funcione correctamente, lo ideal es terminar de testear la clase MomentRepository antes de pasar a otro paquete.

Los tests que has hecho (repositoryStartsEmpty y storeMomentAddsMomentToRepository) son un excelente comienzo, pero aún quedan varias funcionalidades importantes de tu repositorio por verificar.

Próximos tests para el MomentRepository
Aquí hay una lista de los tests que te recomiendo hacer. Cada uno se enfoca en una funcionalidad específica de tu repositorio.

Test para encontrar un momento por su id:

Lógica: Asegura que el método findById() funcione.

Pasos: Guarda un Moment en el repositorio y luego usa findById() para verificar que puedes recuperarlo.

Ejemplo de test:

Java

@Test
void findMomentById() {
    MomentRepository repository = new MomentRepository();
    Moment moment = new Moment(1, "Viaje", "Viaje a la playa", ListEmotions.ALEGRIA, LocalDate.now());
    repository.store(moment);

//     Optional<Moment> foundMoment = repository.findById(1);

//     assertTrue(foundMoment.isPresent());
//     assertEquals(1, foundMoment.get().getId());
// }
// Test para actualizar un momento:

// Lógica: Asegura que el método update() funcione.

// Pasos: Guarda un Moment, modifica su título o descripción, y luego usa update() para verificar que los cambios se reflejan en el repositorio.

// Test para eliminar un momento:

// Lógica: Asegura que el método deleteById() funcione.

// Pasos: Guarda un Moment, elimínalo con deleteById(), y luego verifica que el repositorio está vacío o que el momento ya no puede ser encontrado.

// Test para cuando no se encuentra un id:

// Lógica: Asegura que el método findById() se comporta bien cuando el id no existe.

// Pasos: Busca un id que no has guardado y verifica que el resultado sea un Optional vacío.


    }