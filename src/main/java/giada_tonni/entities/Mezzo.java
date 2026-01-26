package giada_tonni.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="mezzi")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Mezzo {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name="id", nullable = false)
    protected UUID id;

    @Column(name="capienza", nullable = false)
    protected long capienza;


    @Enumerated(EnumType.STRING)
    @Column(name = "stato", nullable = false)
    protected StatoMezzo stato;


    //COSTRUTTORE + vuoto

    protected Mezzo(){}


    protected Mezzo(long capienza, StatoMezzo stato){
        this.capienza = capienza;
        this.stato = stato;
    }

}
