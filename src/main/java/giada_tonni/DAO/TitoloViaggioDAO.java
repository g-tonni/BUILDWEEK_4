package giada_tonni.DAO;

import giada_tonni.entities.*;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.*;


import java.util.UUID;

public class TitoloViaggioDAO {

    private final EntityManager em;

    public TitoloViaggioDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE
    public void save(TitoloViaggio newTitolo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newTitolo);
        transaction.commit();

        System.out.println("Titolo di viaggio salvato con id: " + newTitolo.getCodiceUnivoco());
    }

    // FIND BY ID
    public TitoloViaggio findById(String titoloId) {
        UUID id = UUID.fromString(titoloId);

        Biglietto b = em.find(Biglietto.class, id);
        if (b != null) return b;

        Abbonamento a = em.find(Abbonamento.class, id);
        if (a != null) return a;

        throw new NotFoundException(titoloId);
    }

    // DELETE
    public void findByIdAndDelete(String titoloId) {
        TitoloViaggio found = this.findById(titoloId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();

        System.out.println("Titolo di viaggio con id " + titoloId + " eliminato");
    }
}