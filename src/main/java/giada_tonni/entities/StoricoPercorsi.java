package giada_tonni.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "percorsi")
public class StoricoPercorsi {

    @Id
    @GeneratedValue
    @Column(name = "storico_percorso_id")
    private UUID storicoPercorsoId;

    @Column(name = "tempo_percorso_effettivo")
    private long tempoEffettivo;

    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;

    public StoricoPercorsi() {
    }

    public StoricoPercorsi(long tempoEffettivo, Tratta tratta, Mezzo mezzo) {
        this.tempoEffettivo = tempoEffettivo;
        this.tratta = tratta;
        this.mezzo = mezzo;
    }

    public UUID getStoricoPercorsoId() {
        return storicoPercorsoId;
    }

    public long getTempoEffettivo() {
        return tempoEffettivo;
    }

    public void setTempoEffettivo(long tempoEffettivo) {
        this.tempoEffettivo = tempoEffettivo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "StoricoPercorsi{" +
                "storicoPercorsoId=" + storicoPercorsoId +
                ", tempoEffettivo=" + tempoEffettivo +
                ", tratta=" + tratta +
                ", mezzo=" + mezzo +
                '}';
    }
}
