package giada_tonni.DAO;

import giada_tonni.entities.*;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.*;


import java.util.UUID;

public class TrattaDAO {

    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE
    public void save(Tratta newTratta) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(newTratta);
        transaction.commit();

        System.out.println("Tratta salvata con id: " + newTratta.getTrattaId());
    }

    // FIND BY ID
    public Tratta findById(String trattaId) {
        Tratta found = em.find(Tratta.class, UUID.fromString(trattaId));
        if (found == null) throw new NotFoundException(trattaId);
        return found;
    }

    // DELETE
    public void findByIdAndDelete(String trattaId) {
        Tratta found = this.findById(trattaId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();

        System.out.println("Tratta con id " + trattaId + " eliminata");
    }
}