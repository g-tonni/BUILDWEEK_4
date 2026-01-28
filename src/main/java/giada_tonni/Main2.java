package giada_tonni;


import giada_tonni.DAO.*;
import giada_tonni.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main2 {

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

        /*puntoVenditaDAO.savePuntiVendita(negozio1);
        puntoVenditaDAO.savePuntiVendita(negozio2);
        puntoVenditaDAO.savePuntiVendita(negozio3);
        puntoVenditaDAO.savePuntiVendita(negozio4);
        puntoVenditaDAO.savePuntiVendita(negozio5);
        puntoVenditaDAO.savePuntiVendita(distributore1);
        puntoVenditaDAO.savePuntiVendita(distributore2);
        puntoVenditaDAO.savePuntiVendita(distributore3);
        puntoVenditaDAO.savePuntiVendita(distributore4);
        puntoVenditaDAO.savePuntiVendita(distributore5);*/

        // *********************************** MEZZI

        Mezzo mezzo1 = new Mezzo(80, TipoMezzo.AUTOBUS);
        Mezzo mezzo2 = new Mezzo(120, TipoMezzo.AUTOBUS);
        Mezzo mezzo3 = new Mezzo(200, TipoMezzo.TRAM);
        Mezzo mezzo4 = new Mezzo(60, TipoMezzo.TRAM);
        Mezzo mezzo5 = new Mezzo(75, TipoMezzo.AUTOBUS);

        /*mezzoDAO.save(mezzo1);
        mezzoDAO.save(mezzo2);
        mezzoDAO.save(mezzo3);
        mezzoDAO.save(mezzo4);
        mezzoDAO.save(mezzo5);*/

        // *********************************** UTENTI

        Utenti utente1 = new Utenti("Luca", "Bianchi", LocalDate.of(1995, 3, 12));
        Utenti utente2 = new Utenti("Martina", "Rossi", LocalDate.of(1998, 11, 5));
        Utenti utente3 = new Utenti("Alessandro", "Ferrari", LocalDate.of(2001, 6, 24));
        Utenti utente4 = new Utenti("Giulia", "Conti", LocalDate.of(1993, 9, 18));
        Utenti utente5 = new Utenti("Federica", "Romano", LocalDate.of(2000, 1, 30));

        /*utentiDAO.saveUtente(utente1);
        utentiDAO.saveUtente(utente2);
        utentiDAO.saveUtente(utente3);
        utentiDAO.saveUtente(utente4);
        utentiDAO.saveUtente(utente5);*/

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

        /*try {

         */
        Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("2996a4ad-e372-4195-b3a8-1cd4d7546c37");
        Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("5bf97559-e84b-4c23-b936-a38c142447ad");
        Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("73acbcdf-a753-4d0c-831e-83c2e5e6a79c");
        Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("9586c0e6-6ef0-4a1a-84cd-28c5baba14cc");
        Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("e573a409-d4d8-4b46-a6d0-c435fdeee01d");
/*

            TesseraUtente tesseraTrovata1 = tessereDAO.findTesseraById("12cd8164-2b97-4f24-8b38-8ea0689d612d");
            TesseraUtente tesseraTrovata2 = tessereDAO.findTesseraById("2d593347-09a8-4cff-ba56-3139790b8483");
            TesseraUtente tesseraTrovata3 = tessereDAO.findTesseraById("5ad127b9-46e6-4e1f-982e-d805e034cb2c");

            */
        PuntiVendita puntiVenditaTrovato1 = puntoVenditaDAO.findPuntoVenditaById("023d460a-6753-41d0-8fe0-36414f91b077");
        PuntiVendita puntiVenditaTrovato2 = puntoVenditaDAO.findPuntoVenditaById("18f1eb3c-f19b-4717-a46b-744ef3b75a44");
        PuntiVendita puntiVenditaTrovato3 = puntoVenditaDAO.findPuntoVenditaById("1d0a6b98-4fee-4d05-99dc-e557ae0d7237");
        PuntiVendita puntiVenditaTrovato4 = puntoVenditaDAO.findPuntoVenditaById("32503268-29f3-4485-9d82-0bf0ef3e5d43");
        PuntiVendita puntiVenditaTrovato5 = puntoVenditaDAO.findPuntoVenditaById("7d09af9d-e10e-4542-a4bc-666349e940d3");
        PuntiVendita puntiVenditaTrovato6 = puntoVenditaDAO.findPuntoVenditaById("80e8849c-7c0c-47be-ba8f-f759ea5734a6");
        PuntiVendita puntiVenditaTrovato7 = puntoVenditaDAO.findPuntoVenditaById("909ec2e8-a070-46e1-a75c-cc35bbc9551a");
        PuntiVendita puntiVenditaTrovato8 = puntoVenditaDAO.findPuntoVenditaById("a4199762-1798-43bf-82e2-98793b5613ce");
        PuntiVendita puntiVenditaTrovato9 = puntoVenditaDAO.findPuntoVenditaById("bc36c343-8b8b-4365-9134-30d7e37d2e57");
        PuntiVendita puntiVenditaTrovato10 = puntoVenditaDAO.findPuntoVenditaById("c7cb7ff6-9582-4c41-abe9-4882dc8fb4a0"); /*

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
            */
/*        Biglietto biglietto6 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato6, mezzoTrovato1, LocalDate.of(2026, 1, 2));
        Biglietto biglietto7 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato3, mezzoTrovato1, LocalDate.of(2026, 1, 2));
        Biglietto biglietto8 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato2, mezzoTrovato1, LocalDate.of(2026, 1, 2));
        Biglietto biglietto9 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato2, mezzoTrovato1, LocalDate.of(2026, 1, 2));
        titoloViaggioDAO.save(biglietto6);
        titoloViaggioDAO.save(biglietto7);
        titoloViaggioDAO.save(biglietto8);
        titoloViaggioDAO.save(biglietto9);*/
        /*


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

        Tratta tratta1 = new Tratta("Roma Tiburtina", "Monte Rotondo", 30);
        Tratta tratta2 = new Tratta("Roma Termini", "Fiumicino Aeroporto", 45);
        Tratta tratta3 = new Tratta("Roma Ostiense", "Pomezia", 40);
        Tratta tratta4 = new Tratta("Roma Tiburtina", "Guidonia", 25);
        Tratta tratta5 = new Tratta("Roma Termini", "Civitavecchia", 70);

        /*trattaDAO.save(tratta1);
        trattaDAO.save(tratta2);
        trattaDAO.save(tratta3);
        trattaDAO.save(tratta4);
        trattaDAO.save(tratta5);*/

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

            /*storicoPercorsiDAO.saveStoricoPercorsi(storico1);
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
        } */


        entityManager.close();
        emf.close();
    }
}