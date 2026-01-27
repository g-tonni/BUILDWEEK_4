package giada_tonni.DAO;

import giada_tonni.entities.TesseraUtente;
import giada_tonni.entities.Utenti;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class TessereDAO {
   private EntityManager em;

   public TessereDAO(EntityManager em) {
       this.em = em;
   }

    //    save

    public void saveTessera (TesseraUtente newTessera) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(newTessera);

        transaction.commit();

        System.out.println("L'utente " + newTessera.getNumeroTessera() + " è stata salvata correttamente!");
    }

// findById

    public TesseraUtente findTesseraById(UUID tesseraId) {
        TesseraUtente found = em.find(TesseraUtente.class, tesseraId);
        if (found == null)
            throw new NotFoundException("Tessera con id : " + tesseraId + " non trovata!");
        return found;
    }


    //    remove
    public void deleteTesseraById(UUID tesseraId) {
        TesseraUtente found = em.find(TesseraUtente.class, tesseraId);
        if (found == null) {
            throw new NotFoundException("Tessera con id : " + tesseraId + " non trovata!");
        }
        em.remove(found);
    }

}
