package giada_tonni.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "biglietti_vidimati")
public class BigliettoVidimato {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "data_timbratura", nullable = false)
    private LocalDate dataTimbratura;

    @ManyToOne
    @JoinColumn(name = "mezzo_id", nullable = false)
    private Mezzo mezzo;

    @OneToOne
    @JoinColumn(name = "id_biglietto", nullable = false)
    private Biglietto biglietto;

    // costruttore vuoto
    public BigliettoVidimato() {
    }

    // costruttore
    public BigliettoVidimato(LocalDate dataTimbratura, Mezzo mezzo, Biglietto idBiglietto) {
        this.dataTimbratura = dataTimbratura;
        this.mezzo = mezzo;
        this.biglietto = biglietto;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataTimbratura() {
        return dataTimbratura;
    }

    public void setDataTimbratura(LocalDate dataTimbratura) {
        this.dataTimbratura = dataTimbratura;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public Biglietto getIdBiglietto() {
        return biglietto;
    }

    public void setIdBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    @Override
    public String toString() {
        return "BigliettoVidimato{" +
                "id=" + id +
                ", dataTimbratura=" + dataTimbratura +
                ", mezzo=" + (mezzo != null ? mezzo.getId() : null) +
                ", biglietto=" + biglietto +
                '}';
    }
}
