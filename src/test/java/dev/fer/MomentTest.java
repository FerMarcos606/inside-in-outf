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
    
   


    }
