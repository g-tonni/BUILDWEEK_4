package giada_tonni;

import giada_tonni.DAO.PuntiVenditaDAO;
import giada_tonni.entities.DistributoriAutomatici;
import giada_tonni.entities.Negozi;
import giada_tonni.entities.PuntiVendita;
import giada_tonni.entities.StatoDistributori;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main1 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager();

        System.out.println("Ciao dal main 1");
        PuntiVenditaDAO puntoVendita = new PuntiVenditaDAO(entityManager);

        // creazione e salvataggio punti vendita
        PuntiVendita negozio1 = new Negozi("Tabaccheria", "Piazza Garibaldi 10");
        PuntiVendita distributore1 = new DistributoriAutomatici(StatoDistributori.ATTIVO, "stazione Termini");

        //  puntoVendita.savePuntiVendita(negozio1);
        //  puntoVendita.savePuntiVendita(distributore1);
        entityManager.close();
        emf.close();

    }
}
