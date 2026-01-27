package giada_tonni;

import giada_tonni.DAO.MezzoDAO;
import giada_tonni.entities.Mezzo;
import giada_tonni.entities.TipoMezzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        System.out.println("Ciao");

        // creazione mezzi
        MezzoDAO mezzoDAO = new MezzoDAO(entityManager);

        Mezzo mezzo1 = new Mezzo(80, TipoMezzo.AUTOBUS);
        Mezzo mezzo2 = new Mezzo(120, TipoMezzo.AUTOBUS);
        Mezzo mezzo3 = new Mezzo(200, TipoMezzo.TRAM);
        Mezzo mezzo4 = new Mezzo(60, TipoMezzo.TRAM);

        mezzoDAO.save(mezzo1);
        mezzoDAO.save(mezzo2);
        mezzoDAO.save(mezzo3);
        mezzoDAO.save(mezzo4);

        // test
        String mezzoId = mezzo1.getId().toString();
        Mezzo mezzoTrovato = mezzoDAO.findMezzoById(mezzoId);

        System.out.println("Trovo mezzo: " + mezzoTrovato);

        // chiusure
        entityManager.close();
        emf.close();
    }
}
