package giada_tonni;

import giada_tonni.DAO.*;
import giada_tonni.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main1 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        System.out.println("Ciao");

        PuntiVenditaDAO puntoVenditaDAO = new PuntiVenditaDAO(entityManager);
        MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
        UtentiDAO utentiDAO = new UtentiDAO(entityManager);
        TessereDAO tessereDAO = new TessereDAO(entityManager);
        TitoloViaggioDAO titoloViaggioDAO = new TitoloViaggioDAO(entityManager);
        ManutenzioneDAO manutenzioneDAO = new ManutenzioneDAO(entityManager);
        TrattaDAO trattaDAO = new TrattaDAO(entityManager);
        StoricoPercorsiDAO storicoPercorsiDAO = new StoricoPercorsiDAO(entityManager);

        // *********************************** PUNTI VENDITA
//        Negozi negozio1 = new Negozi("Tabaccheria", "Piazza Garibaldi 10");
//        Negozi negozio2 = new Negozi("Edicola", "Via Nazionale 45");
//        Negozi negozio3 = new Negozi("Cartoleria", "Corso Vittorio Emanuele 12");
//        Negozi negozio4 = new Negozi("Minimarket", "Via del Corso 88");
//        Negozi negozio5 = new Negozi("Souvenir Shop", "Piazza di Spagna 3");
//        DistributoriAutomatici distributore1 = new DistributoriAutomatici(StatoDistributori.ATTIVO, "Stazione Termini");
//        DistributoriAutomatici distributore2 = new DistributoriAutomatici(StatoDistributori.FUORI_SERVIZIO, "Metro Colosseo");
//        DistributoriAutomatici distributore3 = new DistributoriAutomatici(StatoDistributori.ATTIVO, "Ospedale San Giovanni");
//        DistributoriAutomatici distributore4 = new DistributoriAutomatici(StatoDistributori.FUORI_SERVIZIO, "Università La Sapienza");
//        DistributoriAutomatici distributore5 = new DistributoriAutomatici(StatoDistributori.ATTIVO, "Aeroporto Fiumicino - Terminal 1");

//        puntoVenditaDAO.savePuntiVendita(negozio1);
//        puntoVenditaDAO.savePuntiVendita(negozio2);
//        puntoVenditaDAO.savePuntiVendita(negozio3);
//        puntoVenditaDAO.savePuntiVendita(negozio4);
//        puntoVenditaDAO.savePuntiVendita(negozio5);
//        puntoVenditaDAO.savePuntiVendita(distributore1);
//        puntoVenditaDAO.savePuntiVendita(distributore2);
//        puntoVenditaDAO.savePuntiVendita(distributore3);
//        puntoVenditaDAO.savePuntiVendita(distributore4);
//        puntoVenditaDAO.savePuntiVendita(distributore5);

        // *********************************** MEZZI

//        Mezzo mezzo1 = new Mezzo(80, TipoMezzo.AUTOBUS);
//        Mezzo mezzo2 = new Mezzo(120, TipoMezzo.AUTOBUS);
//        Mezzo mezzo3 = new Mezzo(200, TipoMezzo.TRAM);
//        Mezzo mezzo4 = new Mezzo(60, TipoMezzo.TRAM);
//        Mezzo mezzo5 = new Mezzo(75, TipoMezzo.AUTOBUS);
//
//        mezzoDAO.save(mezzo1);
//        mezzoDAO.save(mezzo2);
//        mezzoDAO.save(mezzo3);
//        mezzoDAO.save(mezzo4);
//        mezzoDAO.save(mezzo5);

        // *********************************** UTENTI

//        Utenti utente1 = new Utenti("Luca", "Bianchi", LocalDate.of(1995, 3, 12));
//        Utenti utente2 = new Utenti("Martina", "Rossi", LocalDate.of(1998, 11, 5));
//        Utenti utente3 = new Utenti("Alessandro", "Ferrari", LocalDate.of(2001, 6, 24));
//        Utenti utente4 = new Utenti("Giulia", "Conti", LocalDate.of(1993, 9, 18));
//        Utenti utente5 = new Utenti("Federica", "Romano", LocalDate.of(2000, 1, 30));

//        utentiDAO.saveUtente(utente1);
//        utentiDAO.saveUtente(utente2);
//        utentiDAO.saveUtente(utente3);
//        utentiDAO.saveUtente(utente4);
//        utentiDAO.saveUtente(utente5);

        // *********************************** TESSERE

       /* try {
            Utenti utenteTrovato1 = utentiDAO.findUtenteById("0800dede-85d9-4ded-ad48-b43d0c16e173");
            Utenti utenteTrovato2 = utentiDAO.findUtenteById("786e3404-9842-437f-89ae-5151f205ff38");
            Utenti utenteTrovato3 = utentiDAO.findUtenteById("ae3878ef-c9a2-40fb-9e23-d15a0c3d39b7");


            TesseraUtente tessera1 = new TesseraUtente(LocalDate.of(2025, 4, 1), utenteTrovato1);
            TesseraUtente tessera2 = new TesseraUtente(LocalDate.of(2024, 12, 1), utenteTrovato2);
            TesseraUtente tessera3 = new TesseraUtente(LocalDate.of(2023, 7, 1), utenteTrovato3);

            tessereDAO.saveTessera(tessera1);
            tessereDAO.saveTessera(tessera2);
            tessereDAO.saveTessera(tessera3);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }*/

        // *********************************** ABBONAMENTI, BIGLIETTI E MANUTENZIONI

       /* try {

            Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("002235fa-4404-4a36-9e7e-22f688652a80");
            Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("5d738645-44ec-4c51-ae3a-593083bf8b1c");
            Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("746b25c8-7977-4ec4-8e53-6b0c51002177");
            Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("af8c3e86-dd1c-47a1-b27f-f4a028029904");
            Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("f4461536-00f1-4342-bd14-309218ec99a4");


            TesseraUtente tesseraTrovata1 = tessereDAO.findTesseraById("2fc6f395-a71d-4f22-98ca-0322dbf9aff5");
            TesseraUtente tesseraTrovata2 = tessereDAO.findTesseraById("495b8508-8dd9-4f26-93f8-113ec0363023");
            TesseraUtente tesseraTrovata3 = tessereDAO.findTesseraById("dacc58e8-3579-4de4-8524-88df4447da0c");


            PuntiVendita puntiVenditaTrovato1 = puntoVenditaDAO.findPuntoVenditaById("4e37fed0-3639-4c6f-964b-4848be862c83");
            PuntiVendita puntiVenditaTrovato2 = puntoVenditaDAO.findPuntoVenditaById("5a5a121f-4e61-4361-a296-4333882fb44f");
            PuntiVendita puntiVenditaTrovato3 = puntoVenditaDAO.findPuntoVenditaById("730db7ee-7e21-4641-8e99-692ac87ed489");
            PuntiVendita puntiVenditaTrovato4 = puntoVenditaDAO.findPuntoVenditaById("7ba73ecd-cd02-4ce8-978e-3da26b1c92f2");
            PuntiVendita puntiVenditaTrovato5 = puntoVenditaDAO.findPuntoVenditaById("94cf2121-777e-4d19-add3-485ea6c69461");
            PuntiVendita puntiVenditaTrovato6 = puntoVenditaDAO.findPuntoVenditaById("aa6e11c8-580f-455d-82d8-a34042f31002");
            PuntiVendita puntiVenditaTrovato7 = puntoVenditaDAO.findPuntoVenditaById("c0bc0294-3b66-4c77-a192-f9de9447e065");
            PuntiVendita puntiVenditaTrovato8 = puntoVenditaDAO.findPuntoVenditaById("c237f2da-64e5-40ba-8797-bed89208f91f");
            PuntiVendita puntiVenditaTrovato9 = puntoVenditaDAO.findPuntoVenditaById("ed898e3e-bece-4c7c-8583-ae8279ee4908");
            PuntiVendita puntiVenditaTrovato10 = puntoVenditaDAO.findPuntoVenditaById("fe7334b4-b361-4811-b12d-2c6697228c89");


            Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 1, 1), puntiVenditaTrovato1, tesseraTrovata1, Validita.SETTIMANALE);
            Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2025, 1, 1), puntiVenditaTrovato2, tesseraTrovata2, Validita.SETTIMANALE);
            Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2024, 2, 1), puntiVenditaTrovato3, tesseraTrovata3, Validita.MENSILE);
            Abbonamento abbonamento4 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato4, tesseraTrovata1, Validita.MENSILE);
            Abbonamento abbonamento5 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato5, tesseraTrovata2, Validita.SETTIMANALE);

          /*  Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato6, mezzoTrovato1, LocalDate.of(2026, 1, 2));
            Biglietto biglietto2 = new Biglietto(LocalDate.of(2024, 1, 1), puntiVenditaTrovato7, mezzoTrovato2, LocalDate.of(2026, 1, 2));
            Biglietto biglietto3 = new Biglietto(LocalDate.of(2026, 2, 1), puntiVenditaTrovato8, null, null);
            Biglietto biglietto4 = new Biglietto(LocalDate.of(2023, 5, 2), puntiVenditaTrovato9, null, null);
            Biglietto biglietto5 = new Biglietto(LocalDate.of(2026, 1, 4), puntiVenditaTrovato10, mezzoTrovato3, LocalDate.now());

            Manutenzione manutenzione1 = new Manutenzione(mezzoTrovato1, "Motore", LocalDate.of(2023, 2, 4), LocalDate.of(2023, 3, 3));
            Manutenzione manutenzione2 = new Manutenzione(mezzoTrovato2, "Freni", LocalDate.of(2023, 4, 10), LocalDate.of(2023, 4, 18));
            Manutenzione manutenzione3 = new Manutenzione(mezzoTrovato3, "Impianto elettrico", LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 12));
            Manutenzione manutenzione4 = new Manutenzione(mezzoTrovato4, "Cambio", LocalDate.of(2025, 11, 5), null);
            Manutenzione manutenzione5 = new Manutenzione(mezzoTrovato5, "Sospensioni", LocalDate.of(2026, 1, 1), null);

            titoloViaggioDAO.save(abbonamento1);
            titoloViaggioDAO.save(abbonamento2);
            titoloViaggioDAO.save(abbonamento3);
            titoloViaggioDAO.save(abbonamento4);
            titoloViaggioDAO.save(abbonamento5);

            titoloViaggioDAO.save(biglietto1);
            titoloViaggioDAO.save(biglietto2);
            titoloViaggioDAO.save(biglietto3);
            titoloViaggioDAO.save(biglietto4);
            titoloViaggioDAO.save(biglietto5);

            manutenzioneDAO.save(manutenzione1);
            manutenzioneDAO.save(manutenzione2);
            manutenzioneDAO.save(manutenzione3);
            manutenzioneDAO.save(manutenzione4);
            manutenzioneDAO.save(manutenzione5);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }*/

        // *********************************** TRATTE

//        Tratta tratta1 = new Tratta("Roma Tiburtina", "Monte Rotondo", 30);
//        Tratta tratta2 = new Tratta("Roma Termini", "Fiumicino Aeroporto", 45);
//        Tratta tratta3 = new Tratta("Roma Ostiense", "Pomezia", 40);
//        Tratta tratta4 = new Tratta("Roma Tiburtina", "Guidonia", 25);
//        Tratta tratta5 = new Tratta("Roma Termini", "Civitavecchia", 70);

//        trattaDAO.save(tratta1);
//        trattaDAO.save(tratta2);
//        trattaDAO.save(tratta3);
//        trattaDAO.save(tratta4);
//        trattaDAO.save(tratta5);

       /* try {

            Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("002235fa-4404-4a36-9e7e-22f688652a80");
            Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("5d738645-44ec-4c51-ae3a-593083bf8b1c");
            Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("746b25c8-7977-4ec4-8e53-6b0c51002177");
            Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("af8c3e86-dd1c-47a1-b27f-f4a028029904");
            Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("f4461536-00f1-4342-bd14-309218ec99a4");


            Tratta trattaTrovata1 = trattaDAO.findById("24a724ab-e4ab-41e7-b17f-7d366effe9bb");
            Tratta trattaTrovata2 = trattaDAO.findById("6c7c9f26-8d38-4d17-939f-d5c9020e463d");
            Tratta trattaTrovata3 = trattaDAO.findById("6e1a5862-8238-48f1-bfe9-bf87638718b5");
            Tratta trattaTrovata4 = trattaDAO.findById("deba4fdf-7bcf-475c-9589-7d12dc4c55c6");
            Tratta trattaTrovata5 = trattaDAO.findById("fecb07ba-3813-43ae-a3d3-042093449f00");


            StoricoPercorsi storico1 = new StoricoPercorsi(40, trattaTrovata1, mezzoTrovato1);
            StoricoPercorsi storico2 = new StoricoPercorsi(35, trattaTrovata1, mezzoTrovato1);
            StoricoPercorsi storico3 = new StoricoPercorsi(50, trattaTrovata2, mezzoTrovato2);
            StoricoPercorsi storico4 = new StoricoPercorsi(45, trattaTrovata2, mezzoTrovato2);
            StoricoPercorsi storico5 = new StoricoPercorsi(30, trattaTrovata3, mezzoTrovato3);
            StoricoPercorsi storico6 = new StoricoPercorsi(28, trattaTrovata3, mezzoTrovato3);
            StoricoPercorsi storico7 = new StoricoPercorsi(55, trattaTrovata4, mezzoTrovato4);
            StoricoPercorsi storico8 = new StoricoPercorsi(52, trattaTrovata4, mezzoTrovato4);
            StoricoPercorsi storico9 = new StoricoPercorsi(60, trattaTrovata5, mezzoTrovato5);
            StoricoPercorsi storico10 = new StoricoPercorsi(58, trattaTrovata5, mezzoTrovato5);

            storicoPercorsiDAO.saveStoricoPercorsi(storico1);
            storicoPercorsiDAO.saveStoricoPercorsi(storico2);
            storicoPercorsiDAO.saveStoricoPercorsi(storico3);
            storicoPercorsiDAO.saveStoricoPercorsi(storico4);
            storicoPercorsiDAO.saveStoricoPercorsi(storico5);
            storicoPercorsiDAO.saveStoricoPercorsi(storico6);
            storicoPercorsiDAO.saveStoricoPercorsi(storico7);
            storicoPercorsiDAO.saveStoricoPercorsi(storico8);
            storicoPercorsiDAO.saveStoricoPercorsi(storico9);
            storicoPercorsiDAO.saveStoricoPercorsi(storico10);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }*/

        //checkIfSubscriptionIsValid

        /*boolean isNotValid = titoloViaggioDAO.checkIfSubscriptionIsValid("dacc58e8-3579-4de4-8524-88df4447da0c", "b166d6df-b34c-4864-8ce7-a7a814a77fff");
        System.out.println(isNotValid);
        boolean isValid = titoloViaggioDAO.checkIfSubscriptionIsValid("2fc6f395-a71d-4f22-98ca-0322dbf9aff5", "2c9d3509-46cd-4201-9127-e278905c135f");
        System.out.println(isValid);*/

        //Niccolò esempio
        List<TitoloViaggio>titoliViaggiEmessi = titoloViaggioDAO.tracciaTitoliEmessi("023d460a-6753-41d0-8fe0-36414f91b077", LocalDate.of(2024,1,1),LocalDate.now());

        System.out.println(titoliViaggiEmessi);


        entityManager.close();
        emf.close();
    }
}
