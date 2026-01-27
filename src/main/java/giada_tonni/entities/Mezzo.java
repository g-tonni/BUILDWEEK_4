package giada_tonni.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "mezzi")
@Inheritance(strategy = InheritanceType.JOINED)

public class Mezzo {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", nullable = false)
    protected UUID id;

    @Column(name = "capienza", nullable = false)
    protected long capienza;


    @Enumerated(EnumType.STRING)
    @Column(name = "stato", nullable = false)
    protected StatoMezzo stato;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    protected TipoMezzo tipo;

    //COSTRUTTORE + vuoto

    protected Mezzo() {
    }


    protected Mezzo(long capienza, StatoMezzo stato, TipoMezzo tipo) {
        this.capienza = capienza;
        this.stato = stato;
        this.tipo = tipo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getCapienza() {
        return capienza;
    }

    public void setCapienza(long capienza) {
        this.capienza = capienza;
    }

    public StatoMezzo getStato() {
        return stato;
    }

    public void setStato(StatoMezzo stato) {
        this.stato = stato;
    }

    public TipoMezzo getTipo() {
        return tipo;
    }

    public void setTipo(TipoMezzo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "id=" + id +
                ", capienza=" + capienza +
                ", stato=" + stato +
                ", tipo=" + tipo +
                '}';
    }
}
