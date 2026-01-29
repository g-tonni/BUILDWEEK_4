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
import java.util.UUID;

public class MainA {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        System.out.println("Ciao ANtonio ");

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

       // puntoVenditaDAO.savePuntiVendita(negozio1);
       // puntoVenditaDAO.savePuntiVendita(negozio2);
       // puntoVenditaDAO.savePuntiVendita(negozio3);
       // puntoVenditaDAO.savePuntiVendita(negozio4);
       // puntoVenditaDAO.savePuntiVendita(negozio5);
       // puntoVenditaDAO.savePuntiVendita(distributore1);
       // puntoVenditaDAO.savePuntiVendita(distributore2);
       // puntoVenditaDAO.savePuntiVendita(distributore3);
       // puntoVenditaDAO.savePuntiVendita(distributore4);
       // puntoVenditaDAO.savePuntiVendita(distributore5);

        // *********************************** MEZZI

        Mezzo mezzo1 = new Mezzo(80, TipoMezzo.AUTOBUS);
        Mezzo mezzo2 = new Mezzo(120, TipoMezzo.AUTOBUS);
        Mezzo mezzo3 = new Mezzo(200, TipoMezzo.TRAM);
        Mezzo mezzo4 = new Mezzo(60, TipoMezzo.TRAM);
        Mezzo mezzo5 = new Mezzo(75, TipoMezzo.AUTOBUS);

      // mezzoDAO.save(mezzo1);
      // mezzoDAO.save(mezzo2);
      // mezzoDAO.save(mezzo3);
      // mezzoDAO.save(mezzo4);
      // mezzoDAO.save(mezzo5);

        // *********************************** UTENTI

        Utenti utente1 = new Utenti("Luca", "Bianchi", LocalDate.of(1995, 3, 12));
        Utenti utente2 = new Utenti("Martina", "Rossi", LocalDate.of(1998, 11, 5));
        Utenti utente3 = new Utenti("Alessandro", "Ferrari", LocalDate.of(2001, 6, 24));
        Utenti utente4 = new Utenti("Giulia", "Conti", LocalDate.of(1993, 9, 18));
        Utenti utente5 = new Utenti("Federica", "Romano", LocalDate.of(2000, 1, 30));

       // utentiDAO.saveUtente(utente1);
       // utentiDAO.saveUtente(utente2);
       // utentiDAO.saveUtente(utente3);
       // utentiDAO.saveUtente(utente4);
       // utentiDAO.saveUtente(utente5);
//
        // *********************************** TESSERE

     //  try {
     //     Utenti utenteTrovato1 = utentiDAO.findUtenteById("01020d11-1af5-4843-8fce-08f45646b69e");
     //     Utenti utenteTrovato2 = utentiDAO.findUtenteById("1f229ca4-1b7c-49b6-9950-d10106034476");
     //     Utenti utenteTrovato3 = utentiDAO.findUtenteById("75015b8a-6216-4ff8-9cff-a1e5b1cd8c54");

     //     TesseraUtente tessera1 = new TesseraUtente(LocalDate.of(2025, 4, 1), utenteTrovato1);
     //     TesseraUtente tessera2 = new TesseraUtente(LocalDate.of(2024, 12, 1), utenteTrovato2);
     //     TesseraUtente tessera3 = new TesseraUtente(LocalDate.of(2023, 7, 1), utenteTrovato3);

     //     tessereDAO.saveTessera(tessera1);
     //     tessereDAO.saveTessera(tessera2);
     //     tessereDAO.saveTessera(tessera3);

     // } catch (NotFoundException ex) {
     //     System.out.println(ex.getMessage());
     //   }

        // *********************************** ABBONAMENTI, BIGLIETTI E MANUTENZIONI
//
       // try {
//ok//
           Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("4c82ed32-1798-4d35-9b60-7d00cabb29bd");
          Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("6e7c88c9-67e0-4b63-a7b0-1da6deddd146");
           Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("73686913-7f04-4567-9837-8801a5b14cf6");
           Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("7557c6f7-2336-4653-997f-f023c939cbe3");
           Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("b1f2b0b5-c108-40e6-a660-8534730044be");
//
//
//ok//
       //     TesseraUtente tesseraTrovata1 = tessereDAO.findTesseraById("265b1d86-4a21-4dcd-9286-7fba66dfc771");
       //     TesseraUtente tesseraTrovata2 = tessereDAO.findTesseraById("616166c6-564c-49d8-aa2f-6679c0c3d738");
       //     TesseraUtente tesseraTrovata3 = tessereDAO.findTesseraById("78351890-8115-48ae-8471-768865dca6ca");
//
//
//ok//
       //    PuntiVendita puntiVenditaTrovato1 = puntoVenditaDAO.findPuntoVenditaById("05a62364-c2d1-409c-ab5d-39e403f631f5");
 // PuntiVendita puntiVenditaTrovato2 = puntoVenditaDAO.findPuntoVenditaById("1449a3d5-50d2-4095-92ea-7a4d5759e378");
 // PuntiVendita puntiVenditaTrovato3 = puntoVenditaDAO.findPuntoVenditaById("1824ea96-9513-470e-a303-fda59fc34dd3");
 // PuntiVendita puntiVenditaTrovato4 = puntoVenditaDAO.findPuntoVenditaById("1a2441b2-9570-4665-9b59-fd308cd96de1");
 // PuntiVendita puntiVenditaTrovato5 = puntoVenditaDAO.findPuntoVenditaById("396a9fe1-dbea-4466-93a8-1e9c693aeb4e");
 // PuntiVendita puntiVenditaTrovato6 = puntoVenditaDAO.findPuntoVenditaById("3f5a6118-23a0-4bb9-b313-bea2d983ee6f");
 // PuntiVendita puntiVenditaTrovato7 = puntoVenditaDAO.findPuntoVenditaById("56260fba-7b45-4856-bdee-4372a7d24d52");
 // PuntiVendita puntiVenditaTrovato8 = puntoVenditaDAO.findPuntoVenditaById("569e7218-df62-4f7c-86f3-8dbf1664fc0a");
 // PuntiVendita puntiVenditaTrovato9 = puntoVenditaDAO.findPuntoVenditaById("6023adcd-5f76-462f-a739-3ec9cc1c0dfd");
 // PuntiVendita puntiVenditaTrovato10 = puntoVenditaDAO.findPuntoVenditaById("676fb684-e609-4bac-90c0-28eafb41178c");


           // Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2026, 1, 1), puntiVenditaTrovato1, tesseraTrovata1, Validita.SETTIMANALE);
           // Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2025, 1, 1), puntiVenditaTrovato2, tesseraTrovata2, Validita.SETTIMANALE);
           // Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2024, 2, 1), puntiVenditaTrovato3, tesseraTrovata3, Validita.MENSILE);
           // Abbonamento abbonamento4 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato4, tesseraTrovata1, Validita.MENSILE);
           // Abbonamento abbonamento5 = new Abbonamento(LocalDate.now(), puntiVenditaTrovato5, tesseraTrovata2, Validita.SETTIMANALE);
//
           // Biglietto biglietto1 = new Biglietto(LocalDate.of(2026, 1, 1), puntiVenditaTrovato6, mezzoTrovato1, LocalDate.of(2026, 1, 2));
           // Biglietto biglietto2 = new Biglietto(LocalDate.of(2024, 1, 1), puntiVenditaTrovato7, mezzoTrovato2, LocalDate.of(2026, 1, 2));
           // Biglietto biglietto3 = new Biglietto(LocalDate.of(2026, 2, 1), puntiVenditaTrovato8, null, null);
           // Biglietto biglietto4 = new Biglietto(LocalDate.of(2023, 5, 2), puntiVenditaTrovato9, null, null);
           // Biglietto biglietto5 = new Biglietto(LocalDate.of(2026, 1, 4), puntiVenditaTrovato10, mezzoTrovato3, LocalDate.now());


//MANUTENZIONI
            Manutenzione manutenzione1 = new Manutenzione(mezzoTrovato1, "Motore", LocalDate.of(2023, 2, 4), LocalDate.of(2023, 3, 3));
            Manutenzione manutenzione2 = new Manutenzione(mezzoTrovato2, "Freni", LocalDate.of(2023, 4, 10), LocalDate.of(2023, 4, 18));
            Manutenzione manutenzione3 = new Manutenzione(mezzoTrovato3, "Impianto elettrico", LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 12));
            Manutenzione manutenzione4 = new Manutenzione(mezzoTrovato4, "Cambio", LocalDate.of(2025, 11, 5), null);
            Manutenzione manutenzione5 = new Manutenzione(mezzoTrovato5, "Sospensioni", LocalDate.of(2026, 1, 1), null);
//
           // titoloViaggioDAO.save(abbonamento1);
           // titoloViaggioDAO.save(abbonamento2);
           // titoloViaggioDAO.save(abbonamento3);
           // titoloViaggioDAO.save(abbonamento4);
           // titoloViaggioDAO.save(abbonamento5);
//
           // titoloViaggioDAO.save(biglietto1);
           // titoloViaggioDAO.save(biglietto2);
           // titoloViaggioDAO.save(biglietto3);
           // titoloViaggioDAO.save(biglietto4);
           // titoloViaggioDAO.save(biglietto5);

// SAVE MANUTENZIONI

           //  manutenzioneDAO.save(manutenzione1);
          //  manutenzioneDAO.save(manutenzione2);
          //  manutenzioneDAO.save(manutenzione3);
          //  manutenzioneDAO.save(manutenzione4);
          //  manutenzioneDAO.save(manutenzione5);

      // } catch (NotFoundException ex) {
      //     System.out.println(ex.getMessage());
      // }

      // // *********************************** TRATTE

      Tratta tratta1 = new Tratta("Roma Tiburtina", "Monte Rotondo", 30);
       Tratta tratta2 = new Tratta("Roma Termini", "Fiumicino Aeroporto", 45);
       Tratta tratta3 = new Tratta("Roma Ostiense", "Pomezia", 40);
       Tratta tratta4 = new Tratta("Roma Tiburtina", "Guidonia", 25);
       Tratta tratta5 = new Tratta("Roma Termini", "Civitavecchia", 70);

      // trattaDAO.save(tratta1);
      // trattaDAO.save(tratta2);
      // trattaDAO.save(tratta3);
      // trattaDAO.save(tratta4);
      // trattaDAO.save(tratta5);

       try {

//ripetizione da cancellare
        // Mezzo mezzoTrovato1 = mezzoDAO.findMezzoById("4c82ed32-1798-4d35-9b60-7d00cabb29bd");
        //  Mezzo mezzoTrovato2 = mezzoDAO.findMezzoById("6e7c88c9-67e0-4b63-a7b0-1da6deddd146");
        //  Mezzo mezzoTrovato3 = mezzoDAO.findMezzoById("73686913-7f04-4567-9837-8801a5b14cf6");
        //  Mezzo mezzoTrovato4 = mezzoDAO.findMezzoById("7557c6f7-2336-4653-997f-f023c939cbe3");
        //  Mezzo mezzoTrovato5 = mezzoDAO.findMezzoById("b1f2b0b5-c108-40e6-a660-8534730044be");
//

          //Lista manutenzioni
           //mezzo 1
           List<Manutenzione> manutenzioniMezzo1=
                   manutenzioneDAO.findManutenzioniByMezzoId(mezzoTrovato1.getId().toString());
           System.out.println("il mezzo:   " + mezzoTrovato1.getId()+ "                ");
           System.out.println("ha avuto questo numero di manutenzioni:   " + manutenzioniMezzo1.size());

//mezzo 2
           List<Manutenzione> manutenzioniMezzo2=
                   manutenzioneDAO.findManutenzioniByMezzoId(mezzoTrovato2.getId().toString());
           System.out.println("il mezzo:   " + mezzoTrovato2.getId()+ "                ");
           System.out.println("ha avuto questo numero di manutenzioni:   " + manutenzioniMezzo2.size());

//mezzo 3
           List<Manutenzione> manutenzioniMezzo3=
                   manutenzioneDAO.findManutenzioniByMezzoId(mezzoTrovato3.getId().toString());
           System.out.println("il mezzo:   " + mezzoTrovato3.getId()+ "                ");
           System.out.println("ha avuto questo numero di manutenzioni:   " + manutenzioniMezzo3.size());
//mezzo 4
           List<Manutenzione> manutenzioniMezzo4=
                   manutenzioneDAO.findManutenzioniByMezzoId(mezzoTrovato4.getId().toString());
           System.out.println("il mezzo:   " + mezzoTrovato4.getId()+ "                ");
           System.out.println("ha avuto questo numero di manutenzioni:   " + manutenzioniMezzo4.size());
//mezzo 5
           List<Manutenzione> manutenzioniMezzo5=
                   manutenzioneDAO.findManutenzioniByMezzoId(mezzoTrovato5.getId().toString());
           System.out.println("il mezzo:   " + mezzoTrovato5.getId()+ "                ");
           System.out.println("ha avuto questo numero di manutenzioni:   " + manutenzioniMezzo5.size());


         //TRATTE E STORICO
          Tratta trattaTrovata1 = trattaDAO.findById("4b361eac-f7d3-4e79-a27e-ca06e4ae5b9b");
          Tratta trattaTrovata2 = trattaDAO.findById("92f4d888-8acb-469e-ae83-ea9cb25c85ed");
          Tratta trattaTrovata3 = trattaDAO.findById("af53b954-452a-4055-885b-22f905f62ed5");
          Tratta trattaTrovata4 = trattaDAO.findById("b01fa4a6-c1bb-4e51-bec7-0d9e79b0b77f");
         Tratta trattaTrovata5 = trattaDAO.findById("f6f18b32-3186-42ed-9fd3-6a910af52eb8");
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

      //     storicoPercorsiDAO.saveStoricoPercorsi(storico1);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico2);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico3);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico4);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico5);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico6);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico7);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico8);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico9);
      //     storicoPercorsiDAO.saveStoricoPercorsi(storico10);

      } catch (NotFoundException ex) {
           System.out.println(ex.getMessage());
       }
        System.out.println("Seleziona 1 se sei un Utente o 2 se sei un Amministratore: ");
        Scanner scanner = null;
        int num = Integer.parseInt(scanner.nextLine());
        // PRIMA SCELTA
        switch (num) {
            case 1: {
                while (true) {
                    int num2 = Integer.parseInt(scanner.nextLine());
                    if (num2 == 0) break;
                    // SCELTA OPERAZIONI UTENTE
                    switch (num2) {
                        case 1: {
                            // SCELTA PUNTO ACQUISTO, CON ACQUISTO BIGLETTO O ABBONAMENTO
                            System.out.println("Scegli 1 per acquistare da un rivenditore, 2 da un distributore: ");
                            int num3 = Integer.parseInt(scanner.nextLine());
                            switch (num3) {
                                case 1: {
                                    // RECUPERA ELENCO RIVENDITORI

                                    System.out.println("Scegli 1 per acquistare un biglietto, 2 un abbonamento: ");
                                    int num4 = Integer.parseInt(scanner.nextLine());
                                    switch (num4) {
                                        case 1: {
                                            // ACQUISTA BIGLIETTO (UTILIZZARE COSTRUTTORE SENZA DATA ACQUISTO)

                                        }
                                        case 2: {
                                            // ACQUISTA ABBONAMENTO (UTILIZZARE COSTRUTTORE SENZA DATA ACQUISTO)
                                            System.out.println("Inserisci numero tessera: ");
                                            // FARE IL TESSERA.FINDBYID CON NUMERO TESSERA INSERITO
                                            // SE ID NON VALIDO MESSAGGIO DI ERRORE ( TRY CATCH )
                                            // SE ID E' VALIDO MA LA TESSERA E' SCADUTA ( CONFRONTO DATA SCADENZA TESSERA CON DATA DI OGGI )
                                            // SE TUTTO VA BENE FACCIO SCEGLIERE SE ABBONAMENTO MENSILE O SETTIMANALE
                                            System.out.println("Scegli 1 per un abbonamento settimanale, 2 un abbonamento mensile: ");
                                            int num5 = Integer.parseInt(scanner.nextLine());
                                            Validita validita;
                                            switch (num5) {
                                                case 1: {
                                                    // ABBONAMENTO SETTIMANALE
                                                    validita = Validita.SETTIMANALE;
                                                }
                                                case 2: {
                                                    // ABBONAMENTO MENSILE
                                                    validita = Validita.MENSILE;

                                                }
                                                default: {
                                                    System.out.println("Valore inserito non valido");
                                                }
                                            }
                                            // Abbonamento abbonamento = ecc....
                                            // titoloViaggioDao.save(abbonamento)
                                            // System.out.println("Abbonamento acquistato!");
                                        }
                                        default: {
                                            System.out.println("Valore inserito non valido");
                                        }
                                    }


                                }
                                case 2: {
                                    // RECUPERA ELENCO DISTRIBUTORI ( ACQUISTO UGUALE A ELENCO RIVENDITORI )

                                }
                                default: {
                                    System.out.println("Valore inserito non valido");
                                }

                            }

                        }
                        case 2: {
                            // RINNOVARE TESSERE ( CREARNE UNA NUOVA CON COSTRUTTORE SENZA DATA EMISSIONE )

                        }
                        case 3: {
                            // VERIFICA VALIDITA' ABBONAMENTO TRAMITE TESSERA ( METODO PRONTO CHIAMATO  checkIfSubscriptionIsValid )

                        }
                        case 4: {
                            // VIDIMARE BIGLIETTO
                            System.out.println("Vidimare il biglietto");

                            System.out.print("ID  biglietto: ");
                            String bigliettoID = scanner.nextLine();

                            System.out.print("ID mezzo: ");
                            String mezzoID = scanner.nextLine();

                            try {
                                // validazione
                                UUID.fromString(bigliettoID);
                                UUID.fromString(mezzoID);

                                titoloViaggioDAO.timbraBiglietto(bigliettoID, mezzoID);

                                System.out.println("biglietto timbrato");

                            } catch (IllegalArgumentException e) {
                                System.out.println("id biglietto errato");

                            } catch (NotFoundException e) {
                                System.out.println(e.getMessage());

                            } catch (Exception e) {
                                System.out.println("errore nella timrbatura " + e.getMessage());
                            }

                            break;
                        }


                        default: {
                            System.out.println("Valore inserito non valido");
                            continue;
                        }
                    }
                }
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
            }
            default: {
                System.out.println("Valore inserito non valido");
            }
        }



        entityManager.close();
        emf.close();
    }
}
