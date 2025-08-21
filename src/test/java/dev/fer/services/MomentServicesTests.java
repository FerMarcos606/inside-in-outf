package dev.fer.services;
import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class MomentServicesTests {

    @Mock
    private MomentRepository repository;

    @InjectMocks
    private MomentService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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

}