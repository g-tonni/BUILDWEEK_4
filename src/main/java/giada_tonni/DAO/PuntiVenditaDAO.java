package giada_tonni.DAO;

import giada_tonni.entities.PuntiVendita;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.UUID;

public class PuntiVenditaDAO {
    private final EntityManager entityManager;

    public PuntiVenditaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void savePuntiVendita(PuntiVendita newPuntoVendita) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPuntoVendita);
        transaction.commit();
        System.out.println("Il punto vendita: " + newPuntoVendita.getIdPuntoVendita() + " è stato salvato correttamente.");
    }

    public PuntiVendita findPuntoVenditaById(String idPuntoVendita) {
        try {
            return entityManager.createQuery("SELECT p FROM PuntiVendita p WHERE p.idPuntoVendita= :idPuntoVendita", PuntiVendita.class)
                    .setParameter("idPuntoVendita", UUID.fromString(idPuntoVendita))
                    .getSingleResult();
        } catch (NoResultException exception) {
            throw new NotFoundException("Punto vendita non trovato.");
        }
    }

    public void deletePuntoVenditaById(String idPuntoVendita) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("DELETE FROM PuntiVendita p WHERE p.idPuntoVendita= :idPuntiVendota");
        query.setParameter("idPuntoVendita", UUID.fromString(idPuntoVendita));

        int deleted = query.executeUpdate();
        transaction.commit();
        if (deleted > 0) {
            System.out.println("Ho rimosso: " + deleted + " punti vendita.");
        } else {

            System.out.println("Nessun punto vendita con id: " + idPuntoVendita + " trovato.");
            throw new NotFoundException("Il Punto Vendita con id " + idPuntoVendita + " non è stato trovato");
        }
    }
}
