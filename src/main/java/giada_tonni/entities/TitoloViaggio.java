package giada_tonni.entities;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "titoli_viaggio")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TitoloViaggio {
    @Id
    @GeneratedValue
    @Column(name = "codice_univoco")

    protected UUID codiceUnivoco;

    @Column(name = "data_acquisto", nullable = false)
    protected LocalDate dataAcquisto;

    @Column(name = "rivenditore_id", nullable = false)
    protected UUID rivenditoreId;

    protected TitoloViaggio() {
    }

    protected TitoloViaggio(LocalDate dataAcquisto, UUID rivenditoreId) {
        this.dataAcquisto = dataAcquisto;
        this.rivenditoreId = rivenditoreId;
    }



    //GETTER AND SETTER

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

    public UUID getRivenditoreId() {
        return rivenditoreId;
    }

    public void setRivenditoreId(UUID rivenditoreId) {
        this.rivenditoreId = rivenditoreId;
    }

    @Override
    public String toString() {
        return "TitoloViaggio{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", dataAcquisto=" + dataAcquisto +
                ", rivenditoreId=" + rivenditoreId +
                '}';
    }
}

