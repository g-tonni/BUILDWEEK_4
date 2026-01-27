package giada_tonni.DAO;

import giada_tonni.entities.TitoloViaggio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TitoloViaggioDAO {

    private final EntityManager entityManager;

    public TitoloViaggioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SAVE
    public void save(TitoloViaggio newTitolo) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(newTitolo);
        transaction.commit();

        System.out.println("il titolo di viaggio è stato salvato con codice: " +
                newTitolo.getCodiceUnivoco());
    }

    // FIND BY ID
    public TitoloViaggio findById(UUID titoloId) {
        TitoloViaggio found = entityManager.find(TitoloViaggio.class, titoloId);
        if (found == null)
            throw new RuntimeException("titolo di viaggio con id " + titoloId + " non trovato");
        return found;
    }

    // DELETE
    public void findByIdAndDelete(UUID titoloId) {
        TitoloViaggio found = this.findById(titoloId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("il titolo di viaggio con id " + titoloId + " è stato eliminato");
    }
}