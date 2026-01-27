package giada_tonni.DAO;

import giada_tonni.entities.Mezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class MezzoDAO {

    private final EntityManager entityManager;

    public MezzoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public void save(Mezzo newMezzo) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newMezzo);
        transaction.commit();

        System.out.println("Il Mezzo è inserito correttamente nel DB: " + newMezzo.getId());
    }

    // FIND BY ID
    public Mezzo findMezzoById(String mezzoId) {
        UUID id = UUID.fromString(mezzoId);

        Mezzo found = entityManager.find(Mezzo.class, id);
        if (found == null)
            throw new RuntimeException("Mezzo con id " + mezzoId + " non trovato");

        return found;
    }

    // DELETE
    public void findMezzoByIdAndDelete(String mezzoId) {
        Mezzo found = this.findById(mezzoId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Il mezzo con id " + mezzoId + " è stato cancellato");
    }
}
