package giada_tonni;


import giada_tonni.DAO.*;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

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
           Utenti utenteTrovato1 = utentiDAO.findUtenteById("01020d11-1af5-4843-8fce-08f45646b69e");
            Utenti utenteTrovato2 = utentiDAO.findUtenteById("1f229ca4-1b7c-49b6-9950-d10106034476");
            Utenti utenteTrovato3 = utentiDAO.findUtenteById("75015b8a-6216-4ff8-9cff-a1e5b1cd8c54");


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

           Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("8fb0c1dc-513f-417e-b55a-500b508eeb4e");
            Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("b20bb331-58b9-471c-b080-ef5bdb4d48c3");
            Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("d80a47f2-8b97-4d2d-a471-e492bb96095a");
            Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("e3be4909-f576-4cc7-ace6-f150581369c8");
            Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("f2fa7b13-86b1-43a3-87c6-e503e419197f");


           TesseraUtente tesseraTrovata1 = tessereDAO.findTesseraById("12cd8164-2b97-4f24-8b38-8ea0689d612d");
            TesseraUtente tesseraTrovata2 = tessereDAO.findTesseraById("2d593347-09a8-4cff-ba56-3139790b8483");
            TesseraUtente tesseraTrovata3 = tessereDAO.findTesseraById("5ad127b9-46e6-4e1f-982e-d805e034cb2c");

PuntiVendita puntiVenditaTrovato1 = puntoVenditaDAO.findPuntoVenditaById("3b1502b6-a3d8-4e7a-b283-d17da62766f9");
            PuntiVendita puntiVenditaTrovato2 = puntoVenditaDAO.findPuntoVenditaById("3bf3a1a8-4931-4dc7-b4b7-96b051037f08");
            PuntiVendita puntiVenditaTrovato3 = puntoVenditaDAO.findPuntoVenditaById("3d8c198f-a606-4e22-aced-79d60ac3ac74");
            PuntiVendita puntiVenditaTrovato4 = puntoVenditaDAO.findPuntoVenditaById("57367e7f-60f2-4b5c-94ec-b8480fc35279");
            PuntiVendita puntiVenditaTrovato5 = puntoVenditaDAO.findPuntoVenditaById("81fcec6d-00c9-4e9d-9f98-2e9bc0cb8213");
            PuntiVendita puntiVenditaTrovato6 = puntoVenditaDAO.findPuntoVenditaById("9e34409f-4daa-4cf6-9973-1e4c2c155c0b");
            PuntiVendita puntiVenditaTrovato7 = puntoVenditaDAO.findPuntoVenditaById("b3fa4e58-06a4-4fdc-a4a7-f976dde81d5a");
            PuntiVendita puntiVenditaTrovato8 = puntoVenditaDAO.findPuntoVenditaById("cafb0c13-a8b2-4b12-b8bb-34c6ee542a1d");
            PuntiVendita puntiVenditaTrovato9 = puntoVenditaDAO.findPuntoVenditaById("cd38d081-9369-44cf-aa19-c6959fe4c53f");
            PuntiVendita puntiVenditaTrovato10 = puntoVenditaDAO.findPuntoVenditaById("fc893026-4536-4741-853f-e4aaa9890bb8");


            Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 1, 1), puntiVenditaTrovato1, tesseraTrovata1, Validita.SETTIMANALE);
            Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2025, 1, 1), puntiVenditaTrovato2, tesseraTrovata2, Validita.SETTIMANALE);
            Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2024, 2, 1), puntiVenditaTrovato3, tesseraTrovata3, Validita.MENSILE);
            Abbonamento abbonamento4 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato4, tesseraTrovata1, Validita.MENSILE);
            Abbonamento abbonamento5 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato5, tesseraTrovata2, Validita.SETTIMANALE);

            Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato6, mezzoTrovato1, LocalDate.of(2026, 1, 2));
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

           Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("8fb0c1dc-513f-417e-b55a-500b508eeb4e");
            Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("b20bb331-58b9-471c-b080-ef5bdb4d48c3");
            Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("d80a47f2-8b97-4d2d-a471-e492bb96095a");
            Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("e3be4909-f576-4cc7-ace6-f150581369c8");
            Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("f2fa7b13-86b1-43a3-87c6-e503e419197f");


   Tratta trattaTrovata1 = trattaDAO.findById("0aa26faf-97bf-4521-b0f4-962ed62294f1");
            Tratta trattaTrovata2 = trattaDAO.findById("ca209083-7038-4243-a6ca-73b62ed1841e");
            Tratta trattaTrovata3 = trattaDAO.findById("d6d0e58b-5027-4e71-9a02-57ba17662755");
            Tratta trattaTrovata4 = trattaDAO.findById("d8e233dc-fb64-478f-8881-4b6266fb0005");
            Tratta trattaTrovata5 = trattaDAO.findById("eb71739e-1bc4-4b94-a550-4e759acc9b1e");


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

        try {
            Double mediaPercorrenzaEffettiva = storicoPercorsiDAO.getMediaTrattaByMezzoId("b20bb331-58b9-471c-b080-ef5bdb4d48c3", "ca209083-7038-4243-a6ca-73b62ed1841e");
            System.out.println(mediaPercorrenzaEffettiva);
            boolean valid = titoloViaggioDAO.checkIfSubscriptionIsValid("5ad127b9-46e6-4e1f-982e-d805e034cb2c", "3962923b-2147-4fcd-bad6-1d03f871bab5");
            System.out.println("VALIDITA " + valid);
            long bigliettiVidimati = titoloViaggioDAO.bigliettiVidimatiMezzo("8fb0c1dc-513f-417e-b55a-500b508eeb4e");
            System.out.println("BIGLIETTI TIMBRATI " + bigliettiVidimati);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }


        titoloViaggioDAO.timbraBiglietto("8fb0c1dc-513f-417e-b55a-500b508eeb4e", "8c9e86a5-0d72-48f5-b418-7322a5ed4708");
        long numBigliettiPeriodo = titoloViaggioDAO.numeroBigliettiTimbratiPeriodo(LocalDate.of(2024, 1, 1), LocalDate.now());
        System.out.println(numBigliettiPeriodo);


        entityManager.close();
        emf.close();
    }
}
