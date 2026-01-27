package giada_tonni.DAO;

import giada_tonni.entities.Tratta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TrattaDAO {

    private final EntityManager entityManager;

    public TrattaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public void save(Tratta newTratta) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newTratta);
        transaction.commit();

        System.out.println("la tratta è stata salvata con id: " +
                newTratta.getTrattaId());
    }

    // FIND BY ID
    public Tratta findById(UUID trattaId) {
        Tratta found = entityManager.find(Tratta.class, trattaId);
        if (found == null)
            throw new RuntimeException("tratta con id " + trattaId + " non trovata");
        return found;
    }

    // DELETE
    public void findByIdAndDelete(UUID trattaId) {
        Tratta found = this.findById(trattaId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("la tratta con id " + trattaId + " è stata eliminata");
    }
}