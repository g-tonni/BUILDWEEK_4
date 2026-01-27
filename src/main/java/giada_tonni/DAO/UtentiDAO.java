package giada_tonni.DAO;

import giada_tonni.entities.Manutenzione;
import giada_tonni.entities.Utenti;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtentiDAO {
    private EntityManager em;

    public UtentiDAO(EntityManager em) {
        this.em = em;
    }
//    save

public void saveUtente (Utenti newUtente) {
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(newUtente);
    transaction.commit();
    System.out.println("L'utente " + newUtente.getNome() + " è stato salvato correttamente!");
}

// findById

    public Utenti findUtenteById(String utenteId) {
        Utenti found = em.find(Utenti.class,UUID.fromString(utenteId));
        if (found == null)
            throw new NotFoundException("L'utente con id " + utenteId + " non trovato!");
        return found;
    }


//    remove
    public void deleteUtenteById(String utenteId) {
        Utenti found = this.findUtenteById(utenteId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();

        System.out.println("L'utente è stato eliminato correttamente!");
    }







}
