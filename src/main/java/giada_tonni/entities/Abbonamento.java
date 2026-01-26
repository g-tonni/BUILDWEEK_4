package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
@PrimaryKeyJoinColumn(name = "codice_univoco")
public class Abbonamento extends TitoloViaggio {

    @ManyToOne
    @JoinColumn(name = "id_tessera", nullable = false)
    private TesseraUtente tesseraUtente;

    @Enumerated(EnumType.STRING)
    @Column(name = "validita", nullable = false)
    private Validita validita;

    @Column(name = "data_scadenza", nullable = false)
    private LocalDate scadenza;

    public Abbonamento() {
    }

    public Abbonamento(LocalDate dataAcquisto, TesseraUtente tesseraUtente,
                       Validita validita, LocalDate scadenza) {
        super(dataAcquisto);
        this.tesseraUtente = tesseraUtente;
        this.validita = validita;
        this.scadenza = scadenza;
    }

    public TesseraUtente getIdTessera() {
        return tesseraUtente;
    }

    public Validita getValidita() {
        return validita;
    }

    public void setValidita(Validita validita) {
        this.validita = validita;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "scadenza=" + scadenza +
                ", idTessera=" + tesseraUtente +
                '}';
    }
}