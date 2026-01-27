package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tessere_utente")
public class TesseraUtente {
    @Id
    @GeneratedValue
    @Column(name = "numero_tessera")
    private UUID id;

    @Column(name = "data_emissione", nullable = false)
    private LocalDate dataEmissione;

    @Column(name = "data_scadenza", nullable = false)
    private LocalDate dataScadenza;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utenti utente;

    public TesseraUtente() {
    }

    public TesseraUtente(LocalDate dataEmissione, Utenti utente) {
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataEmissione.plusYears(1);
        this.utente = utente;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utenti getUtente() {
        return utente;
    }

    @Override
    public String toString() {
        return "TesseraUtente{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
