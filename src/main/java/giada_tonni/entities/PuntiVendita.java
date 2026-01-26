package giada_tonni.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "punti_vendita")
public abstract class PuntiVendita {
    //ATTRIBUTI
    @Id
    @GeneratedValue
    private UUID idPuntoVendita;

    @Column(name = "locazione", nullable = false)
    private String locazione;

    //COSTRUTTORI
    public PuntiVendita() {
    }

    public PuntiVendita(String locazione) {
        this.locazione = locazione;
    }

    //GETTER E SETTER


    public UUID getIdPuntoVendita() {
        return idPuntoVendita;
    }

    public String getLocazione() {
        return locazione;
    }

    public void setLocazione(String locazione) {
        this.locazione = locazione;
    }
}
