package dev.fer.repositories;
import dev.fer.model.ListEmotions;
import dev.fer.model.Moment;
import java.util.ArrayList;
import java.util.List;

public class MomentRepository {

    private final List<Moment> moments = new ArrayList<>();

    // Añadir un momento
    public void store(Moment moment) {
        moments.add(moment);
    }

    // Recuperar todos los momentos
    public List<Moment> getAll() {
        return new ArrayList<>(moments); // devolvemos copia para evitar modificar la lista interna
    }

    // Extra: obtener tamaño de la lista
    public int size() {
        return moments.size();
    }

    // 1. Añade este método para que el test pase
    public Moment findById(int id) {
        // Recorre la lista de momentos
        for (Moment moment : this.moments) {
            // Si el ID del momento coincide con el ID que buscas
            if (moment.getId() == id) {
                return moment; // Devuelve el momento encontrado
            }
        }
        return null; // Si no lo encuentra después de recorrer toda la lista, devuelve null
    } 

    public boolean delete(int id) {
       Moment momentToDelete = findById(id);

   
    if (momentToDelete != null) {
       
        this.moments.remove(momentToDelete);
        return true; // 
      }
    return false;
       
    }
    
    public List<Moment> findByEmotion(ListEmotions emotion) {
        List<Moment> filteredMomentsByEmotion = new ArrayList<>();
        for (Moment moment : moments) {
            if (moment.getEmotion() == emotion) {
                filteredMomentsByEmotion.add(moment);
            }
        }
        return filteredMomentsByEmotion;
        
       
    }

   public List<Moment> findByMonthAndYear(int month, int year) {
        List<Moment> filteredMomentsByDate = new ArrayList<>();
        
        for (Moment moment : moments) {
                if (moment.getDate().getMonthValue() == month && moment.getDate().getYear() == year) {
                filteredMomentsByDate.add(moment);
            }
        }
        
        return filteredMomentsByDate;
    }

   public void addMoment(Moment moment) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addMoment'");
   }
}
