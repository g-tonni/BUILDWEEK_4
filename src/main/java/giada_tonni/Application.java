package giada_tonni;


import giada_tonni.DAO.*;
import giada_tonni.entities.*;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Application {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("buildweek4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        PuntiVenditaDAO puntoVenditaDAO = new PuntiVenditaDAO(entityManager);
        MezzoDAO mezzoDAO = new MezzoDAO(entityManager);
        UtentiDAO utentiDAO = new UtentiDAO(entityManager);
        TessereDAO tessereDAO = new TessereDAO(entityManager);
        TitoloViaggioDAO titoloViaggioDAO = new TitoloViaggioDAO(entityManager);
        ManutenzioneDAO manutenzioneDAO = new ManutenzioneDAO(entityManager);
        TrattaDAO trattaDAO = new TrattaDAO(entityManager);
        StoricoPercorsiDAO storicoPercorsiDAO = new StoricoPercorsiDAO(entityManager);


        System.out.println("Seleziona 1 se sei un Utente o 2 se sei un Amministratore: ");
        int num = Integer.parseInt(scanner.nextLine());
        // PRIMA SCELTA
        switch (num) {
            case 1: {
                while (true) {
                    System.out.println("Che operazione vuoi svolgere?");
                    System.out.println("1- Acquistare un biglietto o un abbonamento.");
                    System.out.println("2- Rinnovare una tessera.");
                    System.out.println("3- Verificare la validità dell'abbonamento.");
                    System.out.println("4- Vidimare un biglietto.");
                    System.out.println("0- Per annullare l'operazione.");
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

                            int num3 = 0;
                            PuntiVendita puntoVenditaSelezionato = null;

                            num3 = Integer.parseInt(scanner.nextLine());
                            if (num3 >= listaPuntiVendita.size()) {
                                System.out.println("Numero inserito non valido.");
                                continue;
                            } else {
                                puntoVenditaSelezionato = listaPuntiVendita.get(num3);
                            }


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
                                    // ACQUISTA ABBONAMENTO

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

                                    // FACCIO SCEGLIERE SE ABBONAMENTO MENSILE O SETTIMANALE
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

                                    System.out.println("La variabile validità: " + validita);
                                    Abbonamento abbonamentoCreato = new Abbonamento(puntoVenditaSelezionato, tesseraDefinitiva, validita);


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

                            // RINNOVARE TESSERE
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

                            // VERIFICA VALIDITA' ABBONAMENTO TRAMITE TESSERA
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
                            // VIDIMARE BIGLIETTO
                            System.out.println("Vidimare il biglietto");

                            System.out.print("ID  biglietto: ");
                            String bigliettoID = scanner.nextLine();

                            System.out.print("ID mezzo: ");
                            String mezzoID = scanner.nextLine();

                            try {
                                titoloViaggioDAO.timbraBiglietto(mezzoID, bigliettoID);

                            } catch (NotFoundException e) {
                                System.out.println(e.getMessage());

                            }
                            continue;
                        }
                        default: {
                            System.out.println("Valore inserito non valido");

                        }
                    }
                }
                break;
            }
            case 2: {
                while (true) {
                    System.out.println("Scegli quale operazione vuoi effettuare: ");
                    System.out.println("1- Aggiungere un nuovo mezzo.");
                    System.out.println("2- Inserire un veicolo in manutenzione.");
                    System.out.println("3- Aggiungere un nuovo punto vendita.");
                    System.out.println("4- Aggiungere una nuova tratta");
                    System.out.println("5- Settare lo stato di un distributore.");
                    System.out.println("6- Ottenere risultati del numero di biglietti e abbonamenti acquistati.");
                    System.out.println("7- Verificare i periodi di manutenzione e servizio di un mezzo.");
                    System.out.println("8- Ottenere il numero di biglietti vidimati in base al periodo.");
                    System.out.println("9- Ottenere il numero di biglietti vidimati in base al mezzo.");
                    System.out.println("10- Ottenere numero di volte in cui un mezzo percorre una tratta e tempo effettivo di percorrenza.");
                    System.out.println("11- Calcolare media del tempo effettivo di percorrenza di una tratta.");
                    System.out.println("0- Per annullare l'operazione.");

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
                            String mezzoiD = "stringa";
                            try {
                                System.out.println("ID MEZZO");
                                mezzoiD = scanner.nextLine();
                                UUID provaId = UUID.fromString(mezzoiD);
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                                continue;
                            }

                            System.out.println("Perchè è in manutenzione? Es. avaria motore");
                            String causa = scanner.nextLine();
                            System.out.println("Data inizio manutenzione ( anno - mese - giorno )");
                            LocalDate dataInizio = LocalDate.now();
                            LocalDate dataFine = LocalDate.now();
                            try {
                                dataInizio = LocalDate.parse(scanner.nextLine());
                                System.out.println("Inserire data fine manutenzione. Se è ancora in manutenzione, premere invio");
                                String fineStr = scanner.nextLine();
                                dataFine = fineStr.isEmpty() ? null : LocalDate.parse(fineStr);
                            } catch (DateTimeException ex) {
                                System.out.println(ex.getMessage());
                                continue;
                            }


                            try {
                                Mezzo mezzo = mezzoDAO.findMezzoById(mezzoiD);
                                Manutenzione manutenzione = new Manutenzione(mezzo, causa, dataInizio, dataFine);
                                manutenzioneDAO.save(manutenzione);
                            } catch (IllegalArgumentException e) {
                                System.out.println("id errato");
                            } catch (RuntimeException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Errore nell'inserimento dati" + e.getMessage());
                            }
                            break;

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
                                    } else if (statoNuovoDistributore == 1) {
                                        statoDistributori = StatoDistributori.ATTIVO;
                                    } else {
                                        System.out.println("Valore non valido");
                                        continue;
                                    }

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

                            continue;
                        }
                        case 5: {
                            try {
                                System.out.println("Inserisci ID del distributore automatico:");
                                String idDistributore = scanner.nextLine();

                                PuntiVendita pv = puntoVenditaDAO.findPuntoVenditaById(idDistributore);

                                if (!(pv instanceof DistributoriAutomatici)) {
                                    System.out.println("L'ID inserito non appartiene a un distributore automatico.");
                                    break;
                                }

                                DistributoriAutomatici distributore = (DistributoriAutomatici) pv;

                                System.out.println("Stato attuale: " + distributore.getStatoDistributori());
                                System.out.println("Scegli nuovo stato: 1 = ATTIVO, 2 = FUORI_SERVIZIO");
                                int scelta = Integer.parseInt(scanner.nextLine());

                                StatoDistributori nuovoStato;
                                if (scelta == 1) nuovoStato = StatoDistributori.ATTIVO;
                                else if (scelta == 2) nuovoStato = StatoDistributori.FUORI_SERVIZIO;
                                else {
                                    System.out.println("Valore inserito non valido.");
                                    break;
                                }

                                entityManager.getTransaction().begin();
                                distributore.setStatoDistributori(nuovoStato);
                                entityManager.getTransaction().commit();

                                System.out.println("Stato distributore aggiornato a: " + nuovoStato);

                            } catch (NotFoundException ex) {
                                System.out.println(ex.getMessage());
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Valore inserito non valido.");
                            }

                            break;
                        }


                        case 6: {
                            // Ottenere risultati del numero di biglietti e abbonamenti acquistati
                            try {
                                System.out.println("Inserisci ID del punto vendita:");
                                String idPuntoVendita = scanner.nextLine();
                                UUID provaId = UUID.fromString(idPuntoVendita);

                                System.out.println("Inserisci data inizio (YYYY-MM-DD):");
                                LocalDate dataInizio = LocalDate.parse(scanner.nextLine());

                                System.out.println("Inserisci data fine (YYYY-MM-DD):");
                                LocalDate dataFine = LocalDate.parse(scanner.nextLine());

                                List<TitoloViaggio> titoli = titoloViaggioDAO.tracciaTitoliEmessi(idPuntoVendita, dataInizio, dataFine);

                                long biglietti = titoli.stream().filter(t -> t instanceof Biglietto).count();
                                long abbonamenti = titoli.stream().filter(t -> t instanceof Abbonamento).count();

                                System.out.println("RISULTATI:");
                                System.out.println("Biglietti acquistati: " + biglietti);
                                System.out.println("Abbonamenti acquistati: " + abbonamenti);
                                System.out.println("Totale titoli emessi: " + (biglietti + abbonamenti));

                            } catch (NotFoundException ex) {
                                System.out.println(ex.getMessage());
                            } catch (IllegalArgumentException ex) {
                                System.out.println("Errore: controlla UUID e formato date (YYYY-MM-DD).");
                            } catch (DateTimeException ex) {
                                System.out.println(ex.getMessage());
                            }

                            break;
                        }
                        case 7: {
                            //Verificare i periodi di manutenzione e servizio di un mezzo
                            System.out.println("Inserisci l'ID del mezzo: ");
                            String mezzoID = scanner.nextLine();
                            try {
                                List<Manutenzione> listaManutenzioniMezzo = manutenzioneDAO.findManutenzioniByMezzoId(mezzoID);
                                if (listaManutenzioniMezzo.isEmpty()) {
                                    System.out.println("Questo mezzo non ha subito nessuna manutenzione ");
                                } else {
                                    System.out.println("La lista di manutenzioni per questo mezzo è: ");
                                    listaManutenzioniMezzo.forEach(System.out::println);
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println("Id mezzo inserito non valido");
                            }
                            continue;
                        }
                        case 8: {
                            //Ottenere il numero di biglietti vidimati (in base a periodo)
                            System.out.println("Inserisci il periodo per ottenere i biglietti vidimati");
                            try {
                                System.out.println("Data iniziale: ");
                                LocalDate dataInizio = LocalDate.parse(scanner.nextLine());
                                System.out.println("Data finale: ");
                                LocalDate dataFine = LocalDate.parse(scanner.nextLine());
                                long numeroBiglietti = titoloViaggioDAO.numeroBigliettiTimbratiPeriodo(dataInizio, dataFine);

                                System.out.println("Il numero di biglietti vidimati da " + dataInizio + " al " + dataFine + " è di " + numeroBiglietti);
                            } catch (NotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Date inserite non valide");
                            } catch (DateTimeParseException ex) {
                                System.out.println(ex.getMessage());
                            }
                            continue;
                        }
                        case 9: {
                            //Ottenere il numero di biglietti vidimati (in base al mezzo)
                            System.out.println("Inserisci l'id del mezzo: ");
                            String mezzoID = scanner.nextLine();
                            try {
                                long numeroBiglietti = titoloViaggioDAO.bigliettiVidimatiMezzo(mezzoID);

                                System.out.println("Il numero di biglietti vidimati sul mezzo con id:  " + mezzoID + " è di  " + numeroBiglietti);
                            } catch (NotFoundException e) {
                                System.out.println(e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            continue;
                        }
                        case 10: {
                            //Ottenere numero di volte in cui un mezzo percorre una tratta e tempo effettivo di percorrenza
                            System.out.println("Inserisci l'id di un mezzo: ");
                            String mezzoId = scanner.nextLine();

                            List<StoricoPercorsi> storicoPercorsiDaMezzo = new ArrayList<>();
                            try {
                                storicoPercorsiDaMezzo = storicoPercorsiDAO.findPercorsiByMezzoId(mezzoId);
                            } catch (NotFoundException ex) {
                                System.out.println(ex.getMessage());
                            }

                            storicoPercorsiDaMezzo.forEach(percorso -> {
                                System.out.println("Id mezzo: " + percorso.getMezzo().getId() +
                                        " | Id tratta: " + percorso.getTratta().getTrattaId() +
                                        " | Partenza: " + percorso.getTratta().getPartenza() +
                                        " | Capolinea: " + percorso.getTratta().getCapolinea() +
                                        " | Tempo stimato di percorrenza: " + percorso.getTratta().getTempoPrevisto() +
                                        " | Tempo effettivo: " + percorso.getTempoEffettivo()
                                );
                            });
                            continue;
                        }
                        case 11: {
                            //Calcolare media del tempo effettivo di percorrenza di una tratta
                            try {
                                System.out.println("Inserisci l'id di un mezzo: ");
                                String mezzoId = scanner.nextLine();
                                UUID mezzoIdUU = UUID.fromString(mezzoId);
                                System.out.println("Inserisci l'id di una tratta: ");
                                String trattaId = scanner.nextLine();
                                UUID trattaIdUU = UUID.fromString(trattaId);
                                Double tempoMedio = storicoPercorsiDAO.getMediaTrattaByMezzoId(mezzoId, trattaId);
                                System.out.println("Il tempo medio di percorrenza della tratta è di " + tempoMedio + " minuti");
                            } catch (NotFoundException ex) {
                                System.out.println(ex.getMessage());
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            }
                            continue;

                        }
                        default: {
                            System.out.println("Valore inserito non valido");

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