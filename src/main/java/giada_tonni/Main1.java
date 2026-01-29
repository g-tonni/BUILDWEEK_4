package giada_tonni;

import giada_tonni.DAO.*;
import giada_tonni.entities.*;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
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
//
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

        try {
            Utenti utenteTrovato1 = utentiDAO.findUtenteById("0800dede-85d9-4ded-ad48-b43d0c16e173");
            Utenti utenteTrovato2 = utentiDAO.findUtenteById("786e3404-9842-437f-89ae-5151f205ff38");
            Utenti utenteTrovato3 = utentiDAO.findUtenteById("ae3878ef-c9a2-40fb-9e23-d15a0c3d39b7");


            TesseraUtente tessera1 = new TesseraUtente(LocalDate.of(2025, 4, 1), utenteTrovato1);
            TesseraUtente tessera2 = new TesseraUtente(LocalDate.of(2024, 12, 1), utenteTrovato2);
            TesseraUtente tessera3 = new TesseraUtente(LocalDate.of(2023, 7, 1), utenteTrovato3);

//            tessereDAO.saveTessera(tessera1);
//            tessereDAO.saveTessera(tessera2);
//            tessereDAO.saveTessera(tessera3);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        // *********************************** ABBONAMENTI, BIGLIETTI E MANUTENZIONI

        try {

            Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("002235fa-4404-4a36-9e7e-22f688652a80");
            Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("5d738645-44ec-4c51-ae3a-593083bf8b1c");
            Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("746b25c8-7977-4ec4-8e53-6b0c51002177");
            Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("af8c3e86-dd1c-47a1-b27f-f4a028029904");
            Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("f4461536-00f1-4342-bd14-309218ec99a4");

//
//            TesseraUtente tesseraTrovata1 = tessereDAO.findTesseraById("2fc6f395-a71d-4f22-98ca-0322dbf9aff5");
//            TesseraUtente tesseraTrovata2 = tessereDAO.findTesseraById("495b8508-8dd9-4f26-93f8-113ec0363023");
//            TesseraUtente tesseraTrovata3 = tessereDAO.findTesseraById("dacc58e8-3579-4de4-8524-88df4447da0c");


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


//            Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 1, 1), puntiVenditaTrovato1, tesseraTrovata1, Validita.SETTIMANALE);
//            Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2025, 1, 1), puntiVenditaTrovato2, tesseraTrovata2, Validita.SETTIMANALE);
//            Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2024, 2, 1), puntiVenditaTrovato3, tesseraTrovata3, Validita.MENSILE);
//            Abbonamento abbonamento4 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato4, tesseraTrovata1, Validita.MENSILE);
//            Abbonamento abbonamento5 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato5, tesseraTrovata2, Validita.SETTIMANALE);

//            Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato6, mezzoTrovato1, LocalDate.of(2026, 1, 2));
//            Biglietto biglietto2 = new Biglietto(LocalDate.of(2024, 1, 1), puntiVenditaTrovato7, mezzoTrovato2, LocalDate.of(2026, 1, 2));
//            Biglietto biglietto3 = new Biglietto(LocalDate.of(2026, 2, 1), puntiVenditaTrovato8, null, null);
//            Biglietto biglietto4 = new Biglietto(LocalDate.of(2023, 5, 2), puntiVenditaTrovato9, null, null);
//            Biglietto biglietto5 = new Biglietto(LocalDate.of(2026, 1, 4), puntiVenditaTrovato10, mezzoTrovato3, LocalDate.now());
//            Biglietto biglietto6 = new Biglietto(LocalDate.of(2026, 1, 5), puntiVenditaTrovato1, mezzoTrovato1, LocalDate.of(2026, 1, 6));
//            Biglietto biglietto7 = new Biglietto(LocalDate.of(2026, 1, 7), puntiVenditaTrovato1, mezzoTrovato2, LocalDate.of(2026, 1, 8));
//            Biglietto biglietto8 = new Biglietto(LocalDate.of(2026, 1, 9), puntiVenditaTrovato3, mezzoTrovato3, LocalDate.of(2026, 1, 10));
//            Biglietto biglietto9 = new Biglietto(LocalDate.of(2026, 1, 9), puntiVenditaTrovato3, mezzoTrovato1, LocalDate.of(2026, 1, 10));
//            Biglietto biglietto10 = new Biglietto(LocalDate.of(2026, 1, 9), puntiVenditaTrovato3, mezzoTrovato1, null);
            Biglietto biglietto11 = new Biglietto(LocalDate.of(2026, 1, 3), puntiVenditaTrovato6);

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
//            titoloViaggioDAO.save(biglietto6);
//            titoloViaggioDAO.save(biglietto7);
//            titoloViaggioDAO.save(biglietto8);
//            titoloViaggioDAO.save(biglietto9);
//            titoloViaggioDAO.save(biglietto10);
            titoloViaggioDAO.save(biglietto11);

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

        //checkIfSubscriptionIsValid

        /*boolean isNotValid = titoloViaggioDAO.checkIfSubscriptionIsValid("dacc58e8-3579-4de4-8524-88df4447da0c", "b166d6df-b34c-4864-8ce7-a7a814a77fff");
        System.out.println(isNotValid);
        boolean isValid = titoloViaggioDAO.checkIfSubscriptionIsValid("2fc6f395-a71d-4f22-98ca-0322dbf9aff5", "2c9d3509-46cd-4201-9127-e278905c135f");
        System.out.println(isValid);*/

        //Niccolò esempio
        //List<TitoloViaggio>titoliViaggiEmessi = titoloViaggioDAO.tracciaTitoliEmessi("023d460a-6753-41d0-8fe0-36414f91b077", LocalDate.of(2024,1,1),LocalDate.now());

        //System.out.println(titoliViaggiEmessi);

        long totBigliettiVidimati = titoloViaggioDAO.bigliettiVidimatiMezzo("002235fa-4404-4a36-9e7e-22f688652a80");
        System.out.println(totBigliettiVidimati);
        System.out.println("Seleziona 1 se sei un Utente o 2 se sei un Amministratore: ");
        int num = Integer.parseInt(scanner.nextLine());
        // PRIMA SCELTA
        switch (num) {
            case 1: {
                while (true) {
                    System.out.println("Che operazione vuoi svolgere?");
                    System.out.println("1-Acquistare un biglietto o un abbonamento.");
                    System.out.println("2-Rinnovare una tessera.");
                    System.out.println("3-Verificare la validità dell'abbonamento.");
                    System.out.println("4-Vidimare un biglietto.");
                    int num2 = Integer.parseInt(scanner.nextLine());
                    if (num2 == 0) break;
                    // SCELTA OPERAZIONI UTENTE
                    switch (num2) {
                        case 1: {
                            //RECUPERARE I PUNTI VENDITA

                            List<PuntiVendita> listaPuntiVendita = puntoVenditaDAO.getPuntiVenditaList();
                            System.out.println("Scegli il punto vendita: ");
                            for (int i = 1; i < listaPuntiVendita.size(); i++) {
                                System.out.println(i + " - " + listaPuntiVendita.get(i - 1).getLocazione());
                            }
                            int num3 = Integer.parseInt(scanner.nextLine());
                            PuntiVendita puntoVenditaSelezionato = listaPuntiVendita.get(num3);

                            System.out.println("Scegli 1 per acquistare un biglietto, 2 un abbonamento: ");
                            int num4 = Integer.parseInt(scanner.nextLine());
                            switch (num4) {
                                case 1: {
                                    // ACQUISTA BIGLIETTO (UTILIZZARE COSTRUTTORE SENZA DATA ACQUISTO)
                                    Biglietto bigliettoCreato = new Biglietto(puntoVenditaSelezionato);
                                    titoloViaggioDAO.save(bigliettoCreato);
                                    System.out.println("Biglietto acquistato.");


                                    continue;
                                }
                                case 2: {
                                    // ACQUISTA ABBONAMENTO (UTILIZZARE COSTRUTTORE SENZA DATA ACQUISTO)

                                    System.out.println("Inserisci numero tessera: ");
                                    String tesseraUtente = scanner.nextLine();

                                    // FARE IL TESSERA.FINDBYID CON NUMERO TESSERA INSERITO
                                    TesseraUtente tesseraDefinitiva;
                                    try {
                                        TesseraUtente tesseraTrovata = tessereDAO.findTesseraById(tesseraUtente);
                                        if (tesseraTrovata.getDataScadenza().isBefore(LocalDate.now())) {
                                            System.out.println("Tessera scaduta");
                                            continue;
                                        } else {
                                            tesseraDefinitiva = tesseraTrovata;
                                        }


                                    } catch (NotFoundException ex) {
                                        System.out.println(ex.getMessage());
                                        continue;

                                    }
                                    // SE ID NON VALIDO MESSAGGIO DI ERRORE ( TRY CATCH )
                                    // SE ID E' VALIDO MA LA TESSERA E' SCADUTA ( CONFRONTO DATA SCADENZA TESSERA CON DATA DI OGGI )
                                    //TESSERA VALIDA 2ac0d88c-5be0-4216-9c5e-1a054ca3c9ae
                                    //

                                    // SE TUTTO VA BENE FACCIO SCEGLIERE SE ABBONAMENTO MENSILE O SETTIMANALE
                                    System.out.println("Scegli 1 per un abbonamento settimanale, 2 un abbonamento mensile: ");
                                    int num5 = Integer.parseInt(scanner.nextLine());
                                    Validita validita = Validita.SETTIMANALE;
                                    switch (num5) {
                                        case 1: {
                                            // ABBONAMENTO SETTIMANALE
                                            validita = Validita.SETTIMANALE;
                                            break;
                                        }
                                        case 2: {
                                            // ABBONAMENTO MENSILE
                                            validita = Validita.MENSILE;
                                            break;
                                        }
                                        default: {
                                            System.out.println("Valore inserito non valido");
                                        }
                                    }
                                    // Abbonamento abbonamento = ecc....
                                    System.out.println("La variabile validità: " + validita);
                                    Abbonamento abbonamentoCreato = new Abbonamento(puntoVenditaSelezionato, tesseraDefinitiva, validita);

                                    // titoloViaggioDao.save(abbonamento)
                                    titoloViaggioDAO.save(abbonamentoCreato);
                                    System.out.println("Abbonamento acquistato!");
                                    continue;
                                }
                                default: {
                                    System.out.println("Valore inserito non valido");
                                }
                            }


                        }
                        case 2: {
                            // RINNOVARE TESSERE ( CREARNE UNA NUOVA CON COSTRUTTORE SENZA DATA EMISSIONE )

                            {


                                System.out.println("Inserisci il numero della tessera da rinnovare:");
                                String tesseraId = scanner.nextLine();
                                Utenti utente;
                                try {
                                    TesseraUtente vecchiaTessera = tessereDAO.findTesseraById(tesseraId);
                                    if (vecchiaTessera.getDataScadenza().isAfter(LocalDate.now())) {
                                        System.out.println("La tessera è ancora valida, non è possibile generarne una nuova.");
                                        continue;
                                    } else utente = vecchiaTessera.getUtente();

                                } catch (NotFoundException ex) {
                                    System.out.println(ex.getMessage());
                                    continue;
                                }


                                TesseraUtente nuovaTessera = new TesseraUtente(LocalDate.now(), utente);

                                tessereDAO.saveTessera(nuovaTessera);

                                System.out.println(
                                        "Tessera rinnovata con successo!" +
                                                "Nuovo numero tessera: " + nuovaTessera.getId() +
                                                " Data scadenza: " + nuovaTessera.getDataScadenza()
                                );


                                continue;
                            }


                        }
                        case 3: {
                            // VERIFICA VALIDITA' ABBONAMENTO TRAMITE TESSERA ( METODO PRONTO CHIAMATO  checkIfSubscriptionIsValid )
                            System.out.println("Inserire ID tessera: ");
                            String tesseraID = scanner.nextLine();

                            System.out.println("Inserire ID abbonamento: ");
                            String abbonamentoID = scanner.nextLine();

                            try {
                                boolean validitaAbbonamento = titoloViaggioDAO.checkIfSubscriptionIsValid(tesseraID, abbonamentoID);

                                if (validitaAbbonamento) {
                                    System.out.println("L'abbonamento inserito è valido.");
                                } else {
                                    System.out.println("L'abbonamento inserito non è valido");
                                }
                            } catch (NotFoundException ex) {

                                System.out.println("Abbonamento non trovato,ricontrollare ID inseriti");
                            }
                            continue;
                        }
                        case 4: {
                            // VIDIMARE BIGLIETTO ( METODO GIA' PRONTO CHIAMATO timbraBiglietto );
                            System.out.println("Vidimare il biglietto");

                            System.out.print("ID  biglietto: ");
                            String bigliettoID = scanner.nextLine();

                            System.out.print("ID mezzo: ");
                            String mezzoID = scanner.nextLine();

                            try {
                                // validazione
//                                UUID.fromString(bigliettoID);
//                                UUID.fromString(mezzoID);

                                titoloViaggioDAO.timbraBiglietto(mezzoID, bigliettoID);

                            } catch (NotFoundException e) {
                                System.out.println(e.getMessage());

                            }
                            continue;
                            //biglietto  2e8e3102-8bf1-4a26-9e58-cea3ba78dc32
                            //mezzo 002235fa-4404-4a36-9e7e-22f688652a80
                        }
                        default: {
                            System.out.println("Valore inserito non valido");
                            continue;
                        }
                    }
                }
                break;
            }
            case 2: {
                while (true) {
                    System.out.println("Scegli quale operazione vuoi effettuare: ");
                    System.out.println("1-Aggiungere un nuovo mezzo.");
                    System.out.println("2-Inserire un veicolo in manutenzione.");
                    System.out.println("3-Aggiungere un nuovo punto vendita.");
                    System.out.println("4-Aggiungere una nuova tratta");
                    System.out.println("5-Settare lo stato di un distributore.");
                    System.out.println("6-Ottenere risultati del numero di biglietti e abbonamenti acquistati.");
                    System.out.println("7-Verificare i periodi di manutenzione e servizio di un mezzo.");
                    System.out.println("8-Ottenere il numero di biglietti vidimati (in base a periodo e mezzo).");
                    System.out.println("9-Ottenere numero di volte in cui un mezzo percorre una tratta e tempo effettivo di percorrenza.");
                    System.out.println("10-Calcolare media del tempo effettivo di percorrenza di una tratta.");

                    int num2 = Integer.parseInt(scanner.nextLine());
                    if (num2 == 0) break;
                    // SCELTA OPERAZIONI AMMINISTRATORE
                    switch (num2) {

                        case 1: {

                            //TRAM O BUS?
                            System.out.println("Premi 1 se il veicolo è un TRAM, 2 se è un AUTOBUS.");
                            int num3 = Integer.parseInt(scanner.nextLine());
                            TipoMezzo tipoMezzo;
                            switch (num3) {
                                case 1: {
                                    // TRAM
                                    tipoMezzo = TipoMezzo.TRAM;
                                }
                                case 2: {
                                    // AUTOBUS
                                    tipoMezzo = TipoMezzo.AUTOBUS;
                                }

                                default: {
                                    System.out.println("Valore inserito non valido");

                                }
                            }
                            //Qui si crea il mezzo
                        }
                        case 2: {
                            //Inserire un veicolo in manutenzione

                        }
                        case 3: {
                            //Aggiungere un nuovo punto vendita
                            System.out.println("Premi 1 per aggiungere un negozio, 2 per aggiungere un distributore");
                            int sceltaCase3 = Integer.parseInt(scanner.nextLine());
                            StatoDistributori statoDistributori;
                            switch (sceltaCase3) {
                                case 1: {
                                    System.out.println("Nome negozio: ");
                                    String nomeNegozio = scanner.nextLine();

                                    System.out.println("Locazione del negozio: ");
                                    String locationNegozio = scanner.nextLine();
                                    Negozi nuovoNegozio = new Negozi(nomeNegozio, locationNegozio);
                                    puntoVenditaDAO.savePuntiVendita(nuovoNegozio);
                                    continue;
                                }
                                case 2: {
                                    System.out.println("Premi 1 se il distributore è gia ATTIVO, 2 SE è FUORI_SERVIZIO");
                                    int statoNuovoDistributore = Integer.parseInt(scanner.nextLine());
                                    if (statoNuovoDistributore == 2) {
                                        statoDistributori = StatoDistributori.FUORI_SERVIZIO;
                                    } else statoDistributori = StatoDistributori.ATTIVO;


                                    System.out.println("Locazione del distributore: ");
                                    String locationDistributore = scanner.nextLine();

                                    DistributoriAutomatici nuovoDistributore = new DistributoriAutomatici(statoDistributori, locationDistributore);
                                    puntoVenditaDAO.savePuntiVendita(nuovoDistributore);

                                    continue;

                                }
                                default: {
                                    System.out.println("Valore inserito non valido.");
                                }

                            }
                        }
                        case 4: {
                            //Aggiungere una nuova tratta
                            System.out.println("Stazione di partenza: ");
                            String stazioneDiPartenza = scanner.nextLine();

                            System.out.println("Capolinea: ");
                            String capolinea = scanner.nextLine();

                            System.out.println("Tempo di percorrenza in minuti previsto: ");
                            int tempoPercorrenzaPrevisto = Integer.parseInt(scanner.nextLine());

                            Tratta trattaCreata = new Tratta(stazioneDiPartenza, capolinea, tempoPercorrenzaPrevisto);

                            trattaDAO.save(trattaCreata);
                        }
                        case 5: {
                            //Settare lo stato di un distributore
                        }
                        case 6: {
                            //Ottenere risultati del numero di biglietti e abbonamenti acquistati
                        }
                        case 7: {
                            //Verificare i periodi di manutenzione e servizio di un mezzo
                        }
                        case 8: {
                            //Ottenere il numero di biglietti vidimati (in base a periodo e mezzo)
                        }
                        case 9: {
                            //Ottenere numero di volte in cui un mezzo percorre una tratta e tempo effettivo di percorrenza
                        }
                        case 10: {
                            //Calcolare media del tempo effettivo di percorrenza di una tratta
                        }
                        default: {
                            System.out.println("Valore inserito non valido");
                            continue;
                        }
                    }

                }
                break;
            }

            default: {
                System.out.println("Valore inserito non valido");
            }
        }

        entityManager.close();
        emf.close();
    }
}
