package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "titoli_viaggio")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_titolo_viaggio")
public abstract class TitoloViaggio {
    @Id
    @GeneratedValue
    @Column(name = "codice_univoco")

    protected UUID codiceUnivoco;

    @Column(name = "data_acquisto", nullable = false)
    protected LocalDate dataAcquisto;

    @ManyToOne
    @JoinColumn(name = "punto_vendita_id")
    protected PuntiVendita puntoVendita;

    protected TitoloViaggio() {
    }

    protected TitoloViaggio(LocalDate dataAcquisto, PuntiVendita puntoVendita) {
        this.dataAcquisto = dataAcquisto;
        this.puntoVendita = puntoVendita;

    }

    public TitoloViaggio(PuntiVendita puntoVendita) {
        this.dataAcquisto = LocalDate.now();
        this.puntoVendita = puntoVendita;
    }

    public UUID getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(UUID codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public PuntiVendita getPuntoVendita() {
        return puntoVendita;
    }

    public void setPuntoVendita(PuntiVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }

    @Override
    public String toString() {
        return "TitoloViaggio{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", dataAcquisto=" + dataAcquisto +
                ", puntoVendita=" + puntoVendita +
                '}';
    }
}

