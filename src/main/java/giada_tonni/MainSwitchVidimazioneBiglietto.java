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
    break;
            }
