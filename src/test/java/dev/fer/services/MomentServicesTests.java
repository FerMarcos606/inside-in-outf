package dev.fer.services;
import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class MomentServicesTests {

    @Mock
    private MomentRepository repository;

    @InjectMocks
    private MomentService service;

    // Lista simulada para que el repositorio "guarde" los momentos
    private final List<Moment> mockMoments = new ArrayList<>();

     @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Resetea la lista simulada antes de cada test
        mockMoments.clear();

        // Configura el comportamiento del mock para el método addMoment
        // Cuando se llame a repository.addMoment, añade el momento a nuestra lista simulada porque no tenemos ningun recuerdo guardado
        Mockito.doAnswer(invocation -> {
            Moment moment = invocation.getArgument(0);
            mockMoments.add(moment);
            return null; 
        }).when(repository).addMoment(Mockito.any(Moment.class));
        
        // Configura el comportamiento del mock para el método findById
        Mockito.when(repository.findById(Mockito.anyInt()))
            .thenAnswer(invocation -> {
                int id = invocation.getArgument(0);
                return mockMoments.stream()
                        .filter(moment -> moment.getId() == id)
                        .findFirst()
                        .orElse(null);
            });
            
        // Configura el comportamiento del mock para el método deleteMoment
        Mockito.when(repository.deleteMoment(Mockito.anyInt()))
            .thenAnswer(invocation -> {
                int id = invocation.getArgument(0);
                return mockMoments.removeIf(moment -> moment.getId() == id);
            });
            
        // Configura el comportamiento del mock para el método getAllMoments
        Mockito.when(repository.getAllMoments()).thenReturn(mockMoments);
    }

    @Test
    public void testAddMomentShouldReturnMomentWithGeneratedId() {
        // Arrange (Preparar)
        // Crea un objeto Moment de prueba sin un ID.
        Moment newMoment = new Moment(0, "Test Title", "Test Description", null, LocalDate.now());
        
        // Act (Actuar)
        // Llama al método del servicio que queremos probar.
        Moment addedMoment = service.addMoment(newMoment);

        // Assert (Afirmar)
        // Verificamos que el momento devuelto no es nulo y que se le asignó un ID.
        assertNotNull(addedMoment);
        assertNotNull(addedMoment.getId(), "El ID del momento no debe ser nulo.");
    }

    @Test
    public void ShouldReturnListOfMoments() {
        // Arrange
        Moment m1 = new Moment(1, "Título 1", "Descripción 1", null, LocalDate.now());
        Moment m2 = new Moment(2, "Título 2", "Descripción 2", null, LocalDate.now());

        when(repository.getAllMoments()).thenReturn(Arrays.asList(m1, m2));

        // Act
        List<Moment> moments = service.getAllMoments();

        // Assert
        assertNotNull(moments);
        assertEquals(2, moments.size(), "El servicio debería devolver 2 momentos");
        assertEquals("Título 1", moments.get(0).getTitle());
    }
    @Test
    public void shouldReturnAllMoments() {
        // Arrange
        Moment m1 = new Moment(1, "Título 1", "Descripción 1", null, LocalDate.now());
        Moment m2 = new Moment(2, "Título 2", "Descripción 2", null, LocalDate.now());

        when(repository.getAllMoments()).thenReturn(Arrays.asList(m1, m2));

        // Act
        List<Moment> moments = service.getAllMoments();

        // Assert
        assertNotNull(moments);
        assertEquals(2, moments.size(), "El servicio debería devolver 2 momentos");
        assertEquals("Título 1", moments.get(0).getTitle());    
    }
       
        @Test
    public void ShouldRemoveMomentById() {
        // Arrange
        // Creamos un momento con un ID "simulado" para que el test lo encuentre
        Moment newMoment = new Moment(1, "Test Title", "Test Description", null, LocalDate.now());
        
        // Le decimos al mock del repositorio que guarde este momento en la lista simulada
        // Sin esta línea de código el test fallaba!!!!!
        mockMoments.add(newMoment);

        // Act
        // Eliminamos el momento por su ID.
        boolean deleted = service.deleteMoment(newMoment.getId());

        // Assert
        // Verificamos que la eliminación fue exitosa
        assertTrue(deleted, "El momento debería eliminarse correctamente");
        // Verificamos que la lista simulada ahora esté vacía
        assertTrue(service.getAllMoments().isEmpty(), "La lista debería quedar vacía después de eliminar");
    }
  }


