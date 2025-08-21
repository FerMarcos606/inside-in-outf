package dev.fer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dev.fer.model.ListEmotions;
import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;

import java.time.LocalDate;
import java.util.List;


public class MomentTest {

    @Test
    void repositoryStartsEmpty() {
        MomentRepository repository = new MomentRepository();
        assertTrue(repository.getAll().isEmpty(), 
                   "El repositorio debería empezar vacío");
    }

     @Test
     void storeMomentAddsMomentToRepository() {
        
        MomentRepository repository = new MomentRepository();
         Moment moment = new Moment(1, "Cumpleaños", "Fiesta con amigos", ListEmotions.ALEGRIA, LocalDate.now());
               
        repository.store(moment);

        assertEquals(1, repository.getAll().size(), "El repositorio debería tener un momento");
        assertEquals("Cumpleaños", repository.getAll().get(0).getTitle(), "El título del momento debería coincidir");
    }
    
    @Test
        void findMomentById() {
            MomentRepository repository = new MomentRepository();
            Moment moment = new Moment(1, "Viaje", "Viaje a la playa", ListEmotions.ALEGRIA, LocalDate.now());
            repository.store(moment);

    }
    @Test
    void findByIdReturnsMomentWhenIdExists() {
        
        MomentRepository repository = new MomentRepository();
        Moment moment1 = new Moment(1, "Cumpleaños", "Fiesta con amigos", ListEmotions.ALEGRIA, LocalDate.now());
        Moment moment2 = new Moment(2, "Viaje", "Vacaciones en la playa", ListEmotions.ALEGRIA, LocalDate.now());
        
        repository.store(moment1);
        repository.store(moment2);

        
        // se busca el momento con el ID 2
        Moment foundMoment = repository.findById(2); 

        
        assertNotNull(foundMoment, "El momento no debería ser nulo");
        assertEquals(2, foundMoment.getId(), "El ID del momento encontrado debería ser 2");
        assertEquals("Viaje", foundMoment.getTitle(), "El título del momento encontrado debería ser 'Viaje'");
    }

    @Test
    void findByIdReturnsNullWhenIdDoesNotExist() {
       
        MomentRepository repository = new MomentRepository();
        Moment moment1 = new Moment(1, "Cumpleaños", "Fiesta con amigos", ListEmotions.ALEGRIA, LocalDate.now());
        
        repository.store(moment1);
        // Buscamos un ID que no existe
        Moment foundMoment = repository.findById(99); 

        assertNull(foundMoment, "El momento debería ser nulo si el ID no existe");
    }

     @Test
    void shouldDeleteMomentWhenIdExists() {
        MomentRepository repository = new MomentRepository();
        Moment moment1 = new Moment(1, "Cumpleaños", "Fiesta con amigos", ListEmotions.ALEGRIA, LocalDate.now());
        Moment moment2 = new Moment(2, "Viaje", "Vacaciones en la playa", ListEmotions.ALEGRIA, LocalDate.now());
        
        repository.store(moment1);
        repository.store(moment2);
        
        // Verificamos que el repositorio tiene 2 momentos
        assertEquals(2, repository.getAll().size(), "El repositorio debería tener 2 momentos antes de la eliminación");

        boolean isDeleted = repository.delete(2); 

        assertTrue(isDeleted, "El método debería devolver 'true' si la eliminación fue exitosa");
        assertEquals(1, repository.getAll().size(), "El repositorio debería tener solo 1 momento después de la eliminación");
        assertNull(repository.findById(2), "El momento con ID 2 no debería ser encontrado después de la eliminación");
    }

    @Test
    //el momnento no existe
    void shouldReturnFalseWhenDeletingMomentThatDoesNotExist() {
        
        MomentRepository repository = new MomentRepository();
        repository.store(new Moment(1, "Cumpleaños", "Fiesta con amigos", ListEmotions.ALEGRIA, LocalDate.now()));
        
        // tamaño inicial de la lista
        int initialSize = repository.getAll().size();
        
        boolean isDeleted = repository.delete(99); 

        assertFalse(isDeleted, "El método debería devolver 'false' si el ID no existe");
        assertEquals(initialSize, repository.getAll().size(), "El tamaño del repositorio no debería haber cambiado");
    }
        //test filtro por emoción
     @Test
    void shouldFilterMomentsByEmotion() {
        
        MomentRepository repository = new MomentRepository();
        // momentos y emociones 
        repository.store(new Moment(1, "Viaje a la playa", "Un día soleado", ListEmotions.ALEGRIA, LocalDate.of(2024, 6, 15)));
        repository.store(new Moment(2, "Una película triste", "Lloré mucho", ListEmotions.TRISTEZA, LocalDate.of(2024, 6, 16)));
        repository.store(new Moment(3, "La fiesta de Luis", "Bailamos toda la noche", ListEmotions.ALEGRIA, LocalDate.of(2024, 6, 17)));

        List<Moment> joyMoments = repository.findByEmotion(ListEmotions.ALEGRIA);

        assertNotNull(joyMoments, "La lista devuelta no debería ser nula");
        assertEquals(2, joyMoments.size(), "La lista debería contener 2 momentos de ALEGRIA");
        // los momentos filtrados tienen la emoción correcta
        for (Moment moment : joyMoments) {
            assertEquals(ListEmotions.ALEGRIA, moment.getEmotion(), "Cada momento filtrado debe ser de ALEGRIA");
        }
    }

    @Test
    void shouldFilterMomentsByMonthAndYear() {
        MomentRepository repository = new MomentRepository();
        // Momentos de junio de 2024
        repository.store(new Moment(1, "Viaje de verano", "A la playa", ListEmotions.ALEGRIA, LocalDate.of(2024, 6, 10)));
        repository.store(new Moment(2, "Graduación", "Momento feliz", ListEmotions.ALEGRIA, LocalDate.of(2024, 6, 25)));
        // Momento de julio de 2024
        repository.store(new Moment(3, "Partido de fútbol", "Perdimos", ListEmotions.TRISTEZA, LocalDate.of(2024, 7, 5)));
        // Momento de junio de 2023
        repository.store(new Moment(4, "Examen difícil", "Estaba nervioso", ListEmotions.ANSIEDAD, LocalDate.of(2023, 6, 18)));
    
        List<Moment> june2024Moments = repository.findByMonthAndYear(6, 2024);
        
        assertNotNull(june2024Moments, "La lista devuelta no debería ser nula");
        assertEquals(2, june2024Moments.size(), "La lista debería contener 2 momentos de junio de 2024");
        // ¿los momentos filtrados tienen la fecha correcta?
        for (Moment moment : june2024Moments) {
            assertEquals(6, moment.getDate().getMonthValue(), "Cada momento debe ser del mes 6");
            assertEquals(2024, moment.getDate().getYear(), "Cada momento debe ser del año 2024");
        }
    }
    @Test
    void EmptyListWhenFilterFindsNoMoments() {
        MomentRepository repository = new MomentRepository();
        repository.store(new Moment(1, "Viaje", "Divertido", ListEmotions.ALEGRIA, LocalDate.of(2024, 6, 10)));
        
        List<Moment> notFoundByEmotion = repository.findByEmotion(ListEmotions.VERGUENZA);

        List<Moment> notFoundByDate = repository.findByMonthAndYear(1, 2020);

        assertNotNull(notFoundByEmotion, "La lista por emoción no debe ser nula");
        assertTrue(notFoundByEmotion.isEmpty(), "La lista por emoción debe estar vacía");
        
        assertNotNull(notFoundByDate, "La lista por fecha no debe ser nula");
        assertTrue(notFoundByDate.isEmpty(), "La lista por fecha debe estar vacía");
    }
}


