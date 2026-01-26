package giada_tonni.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "storico_vendite")
public class StoricoVendite {

    @Id
    @GeneratedValue
    @Column(name = "storico_vendite_id")
    private UUID storicoVenditeId;

    @ManyToOne
    @JoinColumn(name = "punto_vendita_id")
    private PuntiVendita puntoVendita;

    @OneToOne
    @JoinColumn(name = "titolo_viaggio_id")
    private TitoloViaggio titoloViaggio;

    public StoricoVendite() {
    }

    public StoricoVendite(PuntiVendita puntoVendita, TitoloViaggio titoloViaggio) {
        this.puntoVendita = puntoVendita;
        this.titoloViaggio = titoloViaggio;
    }

    public UUID getStoricoVenditeId() {
        return storicoVenditeId;
    }

    public PuntiVendita getPuntoVendita() {
        return puntoVendita;
    }

    public void setPuntoVendita(PuntiVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }

    public TitoloViaggio getTitoloViaggio() {
        return titoloViaggio;
    }

    public void setTitoloViaggio(TitoloViaggio titoloViaggio) {
        this.titoloViaggio = titoloViaggio;
    }

    @Override
    public String toString() {
        return "StoricoVendite{" +
                "storicoVenditeId=" + storicoVenditeId +
                ", puntoVendita=" + puntoVendita +
                ", titoloViaggio=" + titoloViaggio +
                '}';
    }
}
