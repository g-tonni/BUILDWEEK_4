package giada_tonni.DAO;

import giada_tonni.entities.Manutenzione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    // FIND BY ID (manutenzione)
    public Manutenzione findManutenzioneById(String manutenzioneId) {
        UUID id = UUID.fromString(manutenzioneId);

        Manutenzione found = entityManager.find(Manutenzione.class, id);
        if (found == null)
            throw new RuntimeException(
                    "Il mezzo in manutenzione con id " + manutenzioneId + " non è stato trovato"
            );

        return found;
    }

    // lista manutenzioni con l'id del mezzo
    public List<Manutenzione> findManutenzioniByMezzoId(String mezzoId) {
        UUID mezzoUUID = UUID.fromString(mezzoId);
//prendo l'id del mezzo tornandomi una lista; poi
        //from prendo le manutnezioni, filtro con where la manutnezione per quel mezzo e poi ordino per data di inizio
        TypedQuery<Manutenzione> query = entityManager.createQuery(
                "SELECT m " +
                        "FROM Manutenzione m " +
                        "WHERE m.mezzo.id = :mezzoId " +
                        "ORDER BY m.dataInizio",
                Manutenzione.class
        );

        query.setParameter("mezzoId", mezzoUUID);
        //ritorno lista vuota se non trova nulla sennò mi da tutti i record delle manutenzioni del mezzo
        return query.getResultList();
    }


    // DELETE
    public void findManutenzioneByIdAndDelete(String manutenzioneId) {
        Manutenzione found = this.findManutenzioneById(manutenzioneId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Il mezzo in manutenzione con id " + manutenzioneId + " è stato cancellato");
    }
}
