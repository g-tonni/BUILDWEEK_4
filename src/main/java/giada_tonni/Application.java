package giada_tonni;

import giada_tonni.DAO.PuntiVenditaDAO;
import giada_tonni.entities.PuntiVendita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        System.out.println("Ciao");
//        PuntiVenditaDAO puntoVendita = new PuntiVenditaDAO(entityManager);


        entityManager.close();
        emf.close();
    }
}
