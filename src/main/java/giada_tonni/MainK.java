package giada_tonni;


import giada_tonni.DAO.*;
import giada_tonni.entities.*;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainK {

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
        Negozi negozio1 = new Negozi("Tabaccheria", "Piazza Garibaldi 10");
        Negozi negozio2 = new Negozi("Edicola", "Via Nazionale 45");
        Negozi negozio3 = new Negozi("Cartoleria", "Corso Vittorio Emanuele 12");
        Negozi negozio4 = new Negozi("Minimarket", "Via del Corso 88");
        Negozi negozio5 = new Negozi("Souvenir Shop", "Piazza di Spagna 3");
        DistributoriAutomatici distributore1 = new DistributoriAutomatici(StatoDistributori.ATTIVO, "Stazione Termini");
        DistributoriAutomatici distributore2 = new DistributoriAutomatici(StatoDistributori.FUORI_SERVIZIO, "Metro Colosseo");
        DistributoriAutomatici distributore3 = new DistributoriAutomatici(StatoDistributori.ATTIVO, "Ospedale San Giovanni");
        DistributoriAutomatici distributore4 = new DistributoriAutomatici(StatoDistributori.FUORI_SERVIZIO, "Università La Sapienza");
        DistributoriAutomatici distributore5 = new DistributoriAutomatici(StatoDistributori.ATTIVO, "Aeroporto Fiumicino - Terminal 1");

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

        Mezzo mezzo1 = new Mezzo(80, TipoMezzo.AUTOBUS);
        Mezzo mezzo2 = new Mezzo(120, TipoMezzo.AUTOBUS);
        Mezzo mezzo3 = new Mezzo(200, TipoMezzo.TRAM);
        Mezzo mezzo4 = new Mezzo(60, TipoMezzo.TRAM);
        Mezzo mezzo5 = new Mezzo(75, TipoMezzo.AUTOBUS);

//        mezzoDAO.save(mezzo1);
//        mezzoDAO.save(mezzo2);
//        mezzoDAO.save(mezzo3);
//        mezzoDAO.save(mezzo4);
//        mezzoDAO.save(mezzo5);

        // *********************************** UTENTI

        Utenti utente1 = new Utenti("Luca", "Bianchi", LocalDate.of(1995, 3, 12));
        Utenti utente2 = new Utenti("Martina", "Rossi", LocalDate.of(1998, 11, 5));
        Utenti utente3 = new Utenti("Alessandro", "Ferrari", LocalDate.of(2001, 6, 24));
        Utenti utente4 = new Utenti("Giulia", "Conti", LocalDate.of(1993, 9, 18));
        Utenti utente5 = new Utenti("Federica", "Romano", LocalDate.of(2000, 1, 30));

//        utentiDAO.saveUtente(utente1);
//        utentiDAO.saveUtente(utente2);
//        utentiDAO.saveUtente(utente3);
//        utentiDAO.saveUtente(utente4);
//        utentiDAO.saveUtente(utente5);

        // *********************************** TESSERE

//        try {
//            Utenti utenteTrovato1 = utentiDAO.findUtenteById("04181913-f050-4d15-ae4f-2feb93cbd945");
//            Utenti utenteTrovato2 = utentiDAO.findUtenteById("440cbb15-111d-40d7-8a17-dd488ab6fb71");
//            Utenti utenteTrovato3 = utentiDAO.findUtenteById("5c6aa819-b6e2-44c7-b3b5-3ebd3d7913a3");
//
//            TesseraUtente tessera1 = new TesseraUtente(LocalDate.of(2025, 4, 1), utenteTrovato1);
//            TesseraUtente tessera2 = new TesseraUtente(LocalDate.of(2024, 12, 1), utenteTrovato2);
//            TesseraUtente tessera3 = new TesseraUtente(LocalDate.of(2023, 7, 1), utenteTrovato3);
//
//            tessereDAO.saveTessera(tessera1);
//            tessereDAO.saveTessera(tessera2);
//           tessereDAO.saveTessera(tessera3);
//
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        // *********************************** ABBONAMENTI, BIGLIETTI E MANUTENZIONI

        try {

            Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("00dbc6df-ca26-40de-a2ab-0af2e462aaff");
            Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("098779bb-d032-4adb-817e-8bd6a617f6c3");
            Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("2c50d14e-3c36-4ac2-a4c5-9bb379434a1a");
            Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("7e3d2c18-5f4a-4340-884b-536879d62f8c");
            Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("8dffc9cb-9d02-4d59-a26e-54a30d8124e6");

            TesseraUtente tesseraTrovata1 = tessereDAO.findTesseraById("061f4e9c-5c1f-4817-b3ab-cf216cea7849");
            TesseraUtente tesseraTrovata2 = tessereDAO.findTesseraById("6bf05096-eb20-4a24-b4dd-d725a7aed8c7");
            TesseraUtente tesseraTrovata3 = tessereDAO.findTesseraById("f93954d8-0b35-43d3-a3b9-e370e88c6ddd");

            PuntiVendita puntiVenditaTrovato1 = puntoVenditaDAO.findPuntoVenditaById("03ec6866-a22c-4821-b7af-c7de2edb457d");
            PuntiVendita puntiVenditaTrovato2 = puntoVenditaDAO.findPuntoVenditaById("14e98ab2-ed01-4688-8600-0819c02b3786");
            PuntiVendita puntiVenditaTrovato3 = puntoVenditaDAO.findPuntoVenditaById("251a4ec8-414e-45ef-a0ef-5655e8ecd3df");
            PuntiVendita puntiVenditaTrovato4 = puntoVenditaDAO.findPuntoVenditaById("6876efe5-61d0-401a-90f2-81e7cec6aadc");
            PuntiVendita puntiVenditaTrovato5 = puntoVenditaDAO.findPuntoVenditaById("85ac4e58-8eba-4069-a57c-e3b310328307");
            PuntiVendita puntiVenditaTrovato6 = puntoVenditaDAO.findPuntoVenditaById("9f9ab176-5454-44db-947a-5ca57253f316");
            PuntiVendita puntiVenditaTrovato7 = puntoVenditaDAO.findPuntoVenditaById("aa34b174-687a-4658-ac0f-80706c6cb132");
            PuntiVendita puntiVenditaTrovato8 = puntoVenditaDAO.findPuntoVenditaById("ab5d61f5-bf2c-45cc-b3b6-35aa6d72d02f");
            PuntiVendita puntiVenditaTrovato9 = puntoVenditaDAO.findPuntoVenditaById("cb4c8cd5-c68d-45e7-ba37-88fa4917cfc4");
            PuntiVendita puntiVenditaTrovato10 = puntoVenditaDAO.findPuntoVenditaById("e341bc7d-5907-4416-9b78-0ef886e48983");


            Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 1, 1), puntiVenditaTrovato1, tesseraTrovata1, Validita.SETTIMANALE);
            Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2025, 1, 1), puntiVenditaTrovato2, tesseraTrovata2, Validita.SETTIMANALE);
            Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2024, 2, 1), puntiVenditaTrovato3, tesseraTrovata3, Validita.MENSILE);
            Abbonamento abbonamento4 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato4, tesseraTrovata1, Validita.MENSILE);
            Abbonamento abbonamento5 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato5, tesseraTrovata2, Validita.SETTIMANALE);

            /*Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato6, mezzoTrovato1, LocalDate.of(2026, 1, 2));
            Biglietto biglietto2 = new Biglietto(LocalDate.of(2024, 1, 1), puntiVenditaTrovato7, mezzoTrovato2, LocalDate.of(2026, 1, 2));
            Biglietto biglietto3 = new Biglietto(LocalDate.of(2026, 2, 1), puntiVenditaTrovato8, null, null);
            Biglietto biglietto4 = new Biglietto(LocalDate.of(2023, 5, 2), puntiVenditaTrovato9, null, null);
            Biglietto biglietto5 = new Biglietto(LocalDate.of(2026, 1, 4), puntiVenditaTrovato10, mezzoTrovato3, LocalDate.now());*/

            Manutenzione manutenzione1 = new Manutenzione(mezzoTrovato1, "Motore", LocalDate.of(2023, 2, 4), LocalDate.of(2023, 3, 3));
            Manutenzione manutenzione2 = new Manutenzione(mezzoTrovato2, "Freni", LocalDate.of(2023, 4, 10), LocalDate.of(2023, 4, 18));
            Manutenzione manutenzione3 = new Manutenzione(mezzoTrovato3, "Impianto elettrico", LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 12));
            Manutenzione manutenzione4 = new Manutenzione(mezzoTrovato4, "Cambio", LocalDate.of(2025, 11, 5), null);
            Manutenzione manutenzione5 = new Manutenzione(mezzoTrovato5, "Sospensioni", LocalDate.of(2026, 1, 1), null);

//            titoloViaggioDAO.save(abbonamento1);
//            titoloViaggioDAO.save(abbonamento2);
//            titoloViaggioDAO.save(abbonamento3);
//            titoloViaggioDAO.save(abbonamento4);
//            titoloViaggioDAO.save(abbonamento5);
//
//            titoloViaggioDAO.save(biglietto1);
//            titoloViaggioDAO.save(biglietto2);
//            titoloViaggioDAO.save(biglietto3);
//            titoloViaggioDAO.save(biglietto4);
//            titoloViaggioDAO.save(biglietto5);
//
//            manutenzioneDAO.save(manutenzione1);
//            manutenzioneDAO.save(manutenzione2);
//            manutenzioneDAO.save(manutenzione3);
//            manutenzioneDAO.save(manutenzione4);
//            manutenzioneDAO.save(manutenzione5);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        // *********************************** TRATTE

        Tratta tratta1 = new Tratta("Roma Tiburtina", "Monte Rotondo", 30);
        Tratta tratta2 = new Tratta("Roma Termini", "Fiumicino Aeroporto", 45);
        Tratta tratta3 = new Tratta("Roma Ostiense", "Pomezia", 40);
        Tratta tratta4 = new Tratta("Roma Tiburtina", "Guidonia", 25);
        Tratta tratta5 = new Tratta("Roma Termini", "Civitavecchia", 70);

//        trattaDAO.save(tratta1);
//        trattaDAO.save(tratta2);
//        trattaDAO.save(tratta3);
//        trattaDAO.save(tratta4);
//        trattaDAO.save(tratta5);

        try {

            Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("00dbc6df-ca26-40de-a2ab-0af2e462aaff");
            Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("098779bb-d032-4adb-817e-8bd6a617f6c3");
            Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("2c50d14e-3c36-4ac2-a4c5-9bb379434a1a");
            Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("7e3d2c18-5f4a-4340-884b-536879d62f8c");
            Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("8dffc9cb-9d02-4d59-a26e-54a30d8124e6");


            Tratta trattaTrovata1 = trattaDAO.findById("657afc13-3735-474b-a025-70b743ccad24");
            Tratta trattaTrovata2 = trattaDAO.findById("a20d5bc2-3f9c-49f6-9c90-bc91ef6e71d8");
            Tratta trattaTrovata3 = trattaDAO.findById("b5cf0553-6772-48e0-9d90-ffe6485148c1");
            Tratta trattaTrovata4 = trattaDAO.findById("e7be991a-1298-4502-aa3b-0ddc16a8438b");
            Tratta trattaTrovata5 = trattaDAO.findById("f3290fba-6503-4267-a103-e0afddd14c13");


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

//            storicoPercorsiDAO.saveStoricoPercorsi(storico1);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico2);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico3);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico4);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico5);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico6);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico7);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico8);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico9);
//            storicoPercorsiDAO.saveStoricoPercorsi(storico10);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }


        storicoPercorsiDAO.findPercorsiByMezzoId("7e3d2c18-5f4a-4340-884b-536879d62fc").forEach(storicoPercorsi -> System.out.println(storicoPercorsi));

        System.out.println(storicoPercorsiDAO.getMediaTrattaByMezzoId("7e3d2c18-5f4a-4340-884b-536879d62f8c", "e7be991a-1298-4502-aa3b-0ddc16a8438b"));

        entityManager.close();
        emf.close();
    }
}
