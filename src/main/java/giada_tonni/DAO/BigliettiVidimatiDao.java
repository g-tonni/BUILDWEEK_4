package giada_tonni.DAO;

import giada_tonni.entities.BigliettoVidimato;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class BigliettiVidimatiDao {

    private EntityManager entityManager;

    public BigliettiVidimatiDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveBigliettoVidimato(BigliettoVidimato newBigliettoVidimato) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newBigliettoVidimato);
        transaction.commit();
        System.out.println("Biglietto Vidimato salvato");
    }

    public BigliettoVidimato findBigliettoVidimatoById(String bigliettoVidimatoId) throws NotFoundException {
        BigliettoVidimato found = entityManager.find(BigliettoVidimato.class, UUID.fromString(bigliettoVidimatoId));
        if (found == null)
            throw new NotFoundException("Il Biglietto Vidimato con id " + bigliettoVidimatoId + " non è stato trovato");
        return found;
    }

    public void deleteBigliettoVidimato(String bigliettoVidimatoId) {
        BigliettoVidimato found = this.findBigliettoVidimatoById(bigliettoVidimatoId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Biglietto Vidimato eliminato");
    }
}
