package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "biglietti")
@DiscriminatorValue("Biglietto")
@PrimaryKeyJoinColumn(name = "codice_univoco")
public class Biglietto extends TitoloViaggio {

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzoId;

    @Column(name = "data_timbratura")
    private LocalDate dataTimbratura;

    public Biglietto() {
    }

    public Biglietto(LocalDate dataAcquisto, PuntiVendita rivenditoreId, Mezzo
            mezzoId, LocalDate dataTimbratura) {
        super(dataAcquisto, rivenditoreId);
        this.mezzoId = mezzoId;
        this.dataTimbratura = dataTimbratura;
    }

    public boolean isValido() {
        return dataTimbratura == null;
    }

    public void timbra() {
        this.dataTimbratura = LocalDate.now();
    }

    // GETTER AND SETTER


    public LocalDate getDataTimbratura() {
        return dataTimbratura;
    }

    public void setDataTimbratura(LocalDate dataTimbratura) {
        this.dataTimbratura = dataTimbratura;
    }

    public Mezzo getMezzoId() {
        return mezzoId;
    }

    public void setMezzoId(Mezzo mezzoId) {
        this.mezzoId = mezzoId;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "dataTimbratura=" + dataTimbratura +
                ", mezzoId=" + mezzoId +
                '}';
    }
}
