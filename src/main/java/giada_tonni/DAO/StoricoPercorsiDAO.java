package giada_tonni.DAO;

import giada_tonni.entities.StoricoPercorsi;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.UUID;

public class StoricoPercorsiDAO {
    private final EntityManager entityManager;

    public StoricoPercorsiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveStoricoPercorsi(StoricoPercorsi newStoricoPercorsi) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newStoricoPercorsi);
        transaction.commit();
        System.out.println("Percorso: " + newStoricoPercorsi.getStoricoPercorsoId() + " è stato salvato correttamente.");
    }

    public StoricoPercorsi findStoricoPercorsiById(String storicoPercorsiId) {
        try {
            return entityManager.createQuery("SELECT s FROM StoricoPercorsi s WHERE s.storicoPercorsoId = :storicoPercorsiId", StoricoPercorsi.class)
                    .setParameter("storicoPercorsiId", UUID.fromString(storicoPercorsiId))
                    .getSingleResult();
        } catch (NoResultException exception) {
            throw new NotFoundException("Percorso non trovato.");
        }
    }

    public void deleteStoricoPercorsiById(String storicoPercorsiId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("DELETE FROM StoricoPercorsi s WHERE s.storicoPercorsoId= :storicoPercorsiId");
        query.setParameter("storicoPercorsiId", UUID.fromString(storicoPercorsiId));

        int deleted = query.executeUpdate();
        transaction.commit();
        if (deleted > 0) {
            System.out.println("Ho rimosso: " + deleted + " percorsi.");
        } else {

            System.out.println("Nessun percorso con id: " + storicoPercorsiId + " trovato.");
            throw new NotFoundException("Lo Storico Percorsi con id " + storicoPercorsiId + " non è stato trovato");
        }
    }
}
