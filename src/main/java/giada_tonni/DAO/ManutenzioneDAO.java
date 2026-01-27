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

        System.out.println("il mezzo in manutenzione è salvato: " + newManutenzione.getId());
    }

    // FIND BY ID
    public Manutenzione findById(UUID manutenzioneId) {
        Manutenzione found = entityManager.find(Manutenzione.class, manutenzioneId);
        if (found == null) throw new RuntimeException("il mezzo in Manutenzione con id " + manutenzioneId + " non è stato trovato");
        return found;
    }

    // DELETE
    public void findByIdAndDelete(UUID manutenzioneId) {
        Manutenzione found = this.findById(manutenzioneId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("il mezzo in manutenzione con " + manutenzioneId + " è stato deletato");
    }
}