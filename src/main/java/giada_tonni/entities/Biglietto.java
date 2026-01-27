package giada_tonni.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "biglietti")
@PrimaryKeyJoinColumn(name = "codice_univoco")
public class Biglietto extends TitoloViaggio {

    @Column(name = "mezzo_id", nullable = false)
    private UUID mezzoId;

    @Column(name = "data_timbratura")
    private LocalDate dataTimbratura;

    public Biglietto() {
    }

    public Biglietto(LocalDate dataAcquisto, UUID rivenditoreId, UUID mezzoId) {
        super(dataAcquisto, rivenditoreId);
        this.mezzoId = mezzoId;
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

    public UUID getMezzoId() {
        return mezzoId;
    }

    public void setMezzoId(UUID mezzoId) {
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
