package giada_tonni;


import giada_tonni.DAO.*;
import giada_tonni.entities.*;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                            System.out.println("Inserisci l'id di un mezzo: ");
                            String mezzoId = scanner.nextLine();

                            List<StoricoPercorsi> storicoPercorsiDaMezzo = new ArrayList<>();
                            try {
                                storicoPercorsiDaMezzo = storicoPercorsiDAO.findPercorsiByMezzoId(mezzoId);
                            } catch (NotFoundException ex) {
                                System.out.println(ex.getMessage());
                            }

                            if (storicoPercorsiDaMezzo.size() == 0) {
                                System.out.println("Non sono stati trovati risultati relativi al mezzo inserito");
                            } else {
                                System.out.println("Risultati della ricerca: ");
                                storicoPercorsiDaMezzo.forEach(percorso -> {
                                    System.out.println("Id mezzo: " + percorso.getMezzo().getId() +
                                            " | Id tratta: " + percorso.getTratta().getTrattaId() +
                                            " | Partenza: " + percorso.getTratta().getPartenza() +
                                            " | Capolinea: " + percorso.getTratta().getCapolinea() +
                                            " | Tempo stimato di percorrenza: " + percorso.getTratta().getTempoPrevisto() +
                                            " | Tempo effettivo: " + percorso.getTempoEffettivo()
                                    );
                                });
                            }
                            continue;
                        }
                        case 10: {
                            //Calcolare media del tempo effettivo di percorrenza di una tratta
                            System.out.println("Inserisci l'id di un mezzo: ");
                            String mezzoId = scanner.nextLine();
                            System.out.println("Inserisci l'id di una tratta: ");
                            String trattaId = scanner.nextLine();
                            try {
                                Double tempoMedio = storicoPercorsiDAO.getMediaTrattaByMezzoId(mezzoId, trattaId);
                                System.out.println("Il tempo medio di percorrenza della tratta è di " + tempoMedio);
                            } catch (NotFoundException ex) {
                                System.out.println(ex.getMessage());
                            }
                            continue;
                            // "b20bb331-58b9-471c-b080-ef5bdb4d48c3"	"ca209083-7038-4243-a6ca-73b62ed1841e"
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
