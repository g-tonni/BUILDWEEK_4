package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
@DiscriminatorValue("Abbonamento")
@PrimaryKeyJoinColumn(name = "id")
public class Abbonamento extends TitoloViaggio {

    @ManyToOne
    @JoinColumn(name = "id_tessera", nullable = false)
    private TesseraUtente idTessera;

    @Enumerated(EnumType.STRING)
    @Column(name = "validita", nullable = false)
    private Validita validita;

    @Column(name = "data_scadenza", nullable = false)
    private LocalDate scadenza;

    public Abbonamento() {
    }

    public Abbonamento(LocalDate dataAcquisto, PuntiVendita puntoVendita,
                       TesseraUtente idTessera, Validita validita) {
        super(dataAcquisto, puntoVendita);
        this.idTessera = idTessera;
        this.validita = validita;
        if (validita.equals(Validita.SETTIMANALE)) this.scadenza = dataAcquisto.plusWeeks(1);
        else this.scadenza = dataAcquisto.plusMonths(1);
    }

    //GETTER AND SETTER


    public TesseraUtente getIdTessera() {
        return idTessera;
    }


    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public Validita getValidita() {
        return validita;
    }

    public void setValidita(Validita validita) {
        this.validita = validita;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "idTessera=" + idTessera +
                ", validita=" + validita +
                ", scadenza=" + scadenza +
                '}';
    }
}