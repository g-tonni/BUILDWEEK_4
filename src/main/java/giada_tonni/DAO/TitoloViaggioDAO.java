package giada_tonni.DAO;

import giada_tonni.entities.Abbonamento;
import giada_tonni.entities.Biglietto;
import giada_tonni.entities.Mezzo;
import giada_tonni.entities.TitoloViaggio;
import giada_tonni.exceptions.NotFoundException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TitoloViaggioDAO {

    private final EntityManager em;

    public TitoloViaggioDAO(EntityManager em) {
        this.em = em;
    }

    // SAVE
    public void save(TitoloViaggio newTitolo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(newTitolo);
        transaction.commit();

        System.out.println("Titolo di viaggio salvato con id: " + newTitolo.getCodiceUnivoco());
    }

    // FIND BY ID
    public TitoloViaggio findById(String titoloId) throws NotFoundException {
        UUID id = UUID.fromString(titoloId);

        Biglietto b = em.find(Biglietto.class, id);
        if (b != null) return b;

        Abbonamento a = em.find(Abbonamento.class, id);
        if (a != null) return a;

        throw new NotFoundException(titoloId);
    }

    //METODO per CONTROLLARE VALIDITA' ABBONAMENTO
    public boolean checkIfSubscriptionIsValid(String idTessera, String idAbbonamento) throws NotFoundException {

        try {
            TypedQuery<Abbonamento> query = em.createQuery(
                            "SELECT a " +
                                    "FROM Abbonamento a " +
                                    "WHERE a.idTessera.id = :idTessera " +
                                    "AND a.codiceUnivoco= :idAbbonamento", Abbonamento.class)
                    .setParameter("idTessera", UUID.fromString(idTessera))
                    .setParameter("idAbbonamento", UUID.fromString(idAbbonamento));
            Abbonamento abbTrovato = query.getSingleResult();
            if (abbTrovato.getScadenza().isBefore(LocalDate.now())) return false;
            else return true;

        } catch (NoResultException exception) {
            throw new NotFoundException("Abbonamento non trovato.");
        } catch (IllegalArgumentException ex) {
            throw new NotFoundException("Abbonamento non trovato.");
        }
    }


    // TRACCIA TITOLI EMESSI
    public List<TitoloViaggio> tracciaTitoliEmessi(String idPuntoVendita, LocalDate dataInizio, LocalDate dataFine) {
        return em.createQuery(
                        "SELECT t FROM TitoloViaggio t WHERE t.puntoVendita.idPuntoVendita = :idPuntoVendita AND t.dataAcquisto >= :dataInizio AND t.dataAcquisto <= :dataFine ORDER BY t.dataAcquisto ", TitoloViaggio.class
                )

                .setParameter("idPuntoVendita", UUID.fromString(idPuntoVendita))
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getResultList();
    }


    // NUMERO BIGLIETTI VIDIMATI DATO UN MEZZO
    public long bigliettiVidimatiMezzo(String mezzoID) throws NotFoundException {
        try {
            long numero = em.createQuery(
                            "SELECT COUNT(b) FROM Biglietto b WHERE b.mezzoId.id = :mezzoId AND b.dataTimbratura IS NOT NULL", Long.class
                    )
                    .setParameter("mezzoId", UUID.fromString(mezzoID))
                    .getSingleResult();
            if (numero == 0) throw new NotFoundException("Id inserito non valido");
            return numero;
        } catch (IllegalArgumentException ex) {
            throw new NotFoundException("Id mezzo non valido");
        }
    }


    // VIDIMARE BIGLIETTO
    public void timbraBiglietto(String mezzoId, String bigliettoId) throws NotFoundException {
        try {
            LocalDate oggi = LocalDate.now();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Mezzo mezzoTrovato = em.find(Mezzo.class, UUID.fromString(mezzoId));
            if (mezzoTrovato == null) throw new NotFoundException("id non valido");

            Query query = em.createQuery("UPDATE Biglietto b SET b.dataTimbratura = :oggi, b.mezzoId = :mezzoId WHERE b.codiceUnivoco = :bigliettoId AND b.dataTimbratura IS NULL")
                    .setParameter("mezzoId", mezzoTrovato)
                    .setParameter("oggi", oggi)
                    .setParameter("bigliettoId", UUID.fromString(bigliettoId));

            int bigliettoAggiornato = query.executeUpdate();
            if (bigliettoAggiornato == 0) throw new NotFoundException("nessun biglietto timbrato");

            transaction.commit();
            System.out.println("Biglietto vidimato");
        } catch (NotFoundException ex) {
            throw new NotFoundException("Biglietto non timbrato");
        } catch (IllegalArgumentException ex) {
            throw new NotFoundException("Uno degli id non è valido.");
        }
    }

    // NUMERO BILIETTI VIDIMATI DATO UN PERIODO
    public long numeroBigliettiTimbratiPeriodo(LocalDate dataInizio, LocalDate dataFine) throws NotFoundException {
        long numero = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataTimbratura IS NOT NULL AND b.dataTimbratura >= :dataInizio AND b.dataTimbratura <= :dataFine", Long.class)
                .setParameter("dataInizio", dataInizio)
                .setParameter("dataFine", dataFine)
                .getSingleResult();
        if (numero == 0) throw new NotFoundException("Non ci sono biglitti vidimati per il periodo selezionato");
        else return numero;
    }

    // DELETE
    public void findByIdAndDelete(String titoloId) {
        TitoloViaggio found = this.findById(titoloId);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();

        System.out.println("Titolo di viaggio con id " + titoloId + " eliminato");
    }
}