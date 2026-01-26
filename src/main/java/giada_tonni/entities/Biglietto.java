package giada_tonni.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "biglietti")
@PrimaryKeyJoinColumn(name = "codice_univoco")
public class Biglietto extends TitoloViaggio {

    @Column(name = "valido", nullable = false)
    private boolean valido = true;

    public Biglietto() {
    }

    public Biglietto(LocalDate dataAcquisto) {
        super(dataAcquisto);
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "valido=" + valido +
                '}';
    }
}
