package giada_tonni.DAO;

import giada_tonni.entities.StoricoVendite;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class StoricoVenditeDao {

    private EntityManager entityManager;

    public StoricoVenditeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveStoricoVendite(StoricoVendite newStoricoVendite) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newStoricoVendite);
        transaction.commit();
        System.out.println("Storico Vendite salvato");
    }

    public StoricoVendite findStoricoVenditeById(String storicoVenditeId) throws NotFoundException {
        StoricoVendite found = entityManager.find(StoricoVendite.class, UUID.fromString(storicoVenditeId));
        if (found == null)
            throw new NotFoundException("Lo Storico Vendite con id " + storicoVenditeId + " non è stato trovato");
        return found;
    }

    public void deleteStoricoVendite(String storicoVenditeId) {
        StoricoVendite found = this.findStoricoVenditeById(storicoVenditeId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Storico Vendite eliminato");
    }
}
