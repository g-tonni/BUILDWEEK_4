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


    @Column(name = "id_biglietto", nullable = false)
    private UUID idBiglietto;

    // costruttore vuoto
    public BigliettoVidimato() {}

    // costruttore
    public BigliettoVidimato(LocalDate dataTimbratura, Mezzo mezzo, UUID idBiglietto) {
        this.dataTimbratura = dataTimbratura;
        this.mezzo = mezzo;
        this.idBiglietto = idBiglietto;
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

    public UUID getIdBiglietto() {
        return idBiglietto;
    }

    public void setIdBiglietto(UUID idBiglietto) {
        this.idBiglietto = idBiglietto;
    }

    @Override
    public String toString() {
        return "BigliettoVidimato{" +
                "id=" + id +
                ", dataTimbratura=" + dataTimbratura +
                ", mezzo=" + (mezzo != null ? mezzo.getId() : null) +
                ", idBiglietto=" + idBiglietto +
                '}';
    }
}
