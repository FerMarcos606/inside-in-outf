package dev.fer.services;
import dev.fer.model.Moment;
import dev.fer.repositories.MomentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;


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
}