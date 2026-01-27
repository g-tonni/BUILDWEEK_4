package giada_tonni.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "punti_vendita")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_punto_vendita")
public abstract class PuntiVendita {
    @OneToMany(mappedBy = "puntoVendita")
    protected List<TitoloViaggio> titoloViaggioList = new ArrayList<>();
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


    public List<TitoloViaggio> getTitoloViaggioList() {
        return titoloViaggioList;
    }

    public void setTitoloViaggioList(List<TitoloViaggio> titoloViaggioList) {
        this.titoloViaggioList = titoloViaggioList;
    }

    public String getLocazione() {
        return locazione;
    }

    public void setLocazione(String locazione) {
        this.locazione = locazione;
    }

    @Override
    public String toString() {
        return "PuntiVendita{" +
                "idPuntoVendita=" + idPuntoVendita +
                ", locazione='" + locazione + '\'' +
                ", titoloViaggioList=" + titoloViaggioList +
                '}';
    }
}
