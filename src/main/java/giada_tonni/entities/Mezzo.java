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
    @Column(name = "tipo", nullable = false)
    protected TipoMezzo tipo;

    // COSTRUTTORE vuoto
    public Mezzo() {
    }

    // COSTRUTTORE
    public Mezzo(long capienza, TipoMezzo tipo) {
        this.capienza = capienza;
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
                ", tipo=" + tipo +
                '}';
    }
}
