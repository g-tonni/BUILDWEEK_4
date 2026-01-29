package giada_tonni;


import giada_tonni.DAO.*;

import giada_tonni.entities.TipoMezzo;
import giada_tonni.entities.Validita;
import giada_tonni.entities.TesseraUtente;
import giada_tonni.entities.Utenti;

import giada_tonni.entities.*;
import giada_tonni.exceptions.NotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import giada_tonni.exceptions.NotFoundException;

import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MainA {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        // System.out.println("Ciao");

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
/*
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
        System.out.println(numBigliettiPeriodo);*/


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

                            //QUA CAPIENZA
                            System.out.println("Inserisci la capienza del mezzo: ");
                            int capienza = Integer.parseInt(scanner.nextLine());

                            TipoMezzo tipoMezzo = null;
                            switch (num3) {
                                case 1: {
                                    // TRAM
                                    tipoMezzo = TipoMezzo.TRAM;
                                    break;
                                }
                                case 2: {
                                    // AUTOBUS
                                    tipoMezzo = TipoMezzo.AUTOBUS;
                                    break;
                                }

                                default: {
                                    System.out.println("devi scegliere 1 o 2");
                                    break;
                                }
                            }

                            if (tipoMezzo == null) break;

                            try {
                                //creazione oggetto mezzo
                                Mezzo nuovoMezzo = new Mezzo(capienza, tipoMezzo);
                                mezzoDAO.save(nuovoMezzo);
                            } catch (Exception e) {
                                System.out.println("dati errati" + e.getMessage());
                            }

                            break;
                        }


                        //INSERIMENTO MEZZO IN MANUTENZIONE
                        case 2: {
                            //Inserire un veicolo in manutenzione
                            System.out.println("inserisci mezzo in manutenzione");
                            System.out.println("ID MEZZO");
                            String mezzoiD = scanner.nextLine();

                            System.out.println("perchè è in manutenzione? es motore scoppiato");
                            String causa = scanner.nextLine();
                            System.out.println("data manutenzione prima però anno - mese - giorno con i cazzo di trattiti del cazzo");
                            LocalDate dataInizio = LocalDate.parse(scanner.nextLine());
                            System.out.println("qua metti se il mezzo non è più da riparare (quindi sistemato e in funzione). Se è ancora rotto, premi invio per continuare");
                            String fineStr = scanner.nextLine();
                            LocalDate dataFine = fineStr.isEmpty() ? null : LocalDate.parse(fineStr);

                            try {
                                Mezzo mezzo = mezzoDAO.findMezzoById(mezzoiD);
                                Manutenzione manutenzione = new Manutenzione(mezzo,causa,dataInizio,dataFine);
                                manutenzioneDAO.save(manutenzione);
                            } catch (IllegalArgumentException e){
                                System.out.println("id errato");
                            }catch (RuntimeException e ){
                                System.out.println(e.getMessage());
                            }catch (Exception e){
                                System.out.println("errore nell'isnerimento dati" + e.getMessage());
                            }
                            break;

                        }
                        case 3: {
                            //Aggiungere un nuovo punto vendita
                        }
                        case 4: {
                            //Aggiungere una nuova tratta
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
