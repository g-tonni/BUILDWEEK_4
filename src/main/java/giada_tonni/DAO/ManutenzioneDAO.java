package giada_tonni.DAO;

import giada_tonni.entities.Manutenzione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class ManutenzioneDAO {

    private final EntityManager entityManager;

    public ManutenzioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public void save(Manutenzione newManutenzione) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newManutenzione);
        transaction.commit();

        System.out.println("Il mezzo in manutenzione è salvato: " + newManutenzione.getId());
    }

    // FIND BY ID
    public Manutenzione findById(String manutenzioneId) {
        UUID id = UUID.fromString(manutenzioneId);

        Manutenzione found = entityManager.find(Manutenzione.class, id);
        if (found == null)
            throw new RuntimeException(
                    "Il mezzo in manutenzione con id " + manutenzioneId + " non è stato trovato"
            );

        return found;
    }

    // DELETE
    public void findByIdAndDelete(String manutenzioneId) {
        Manutenzione found = this.findById(manutenzioneId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Il mezzo in manutenzione con id " + manutenzioneId + " è stato cancellato");
    }
}
