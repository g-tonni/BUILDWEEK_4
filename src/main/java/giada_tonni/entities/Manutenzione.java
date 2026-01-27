package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "manutenzioni")
public class Manutenzione {

    @Id
    @GeneratedValue
    @Column(name = "manutenzione_id")
    private UUID manutenzioneId;

    @ManyToOne
    @JoinColumn(name = "id_mezzo", nullable = false)
    private Mezzo mezzo;

    @Column(name = "causa", nullable = false)
    private String causa;

    @Column(name = "data_inizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    // costruttore vuoto
    public Manutenzione() {
    }

    // costruttore
    public Manutenzione(Mezzo mezzo, String causa, LocalDate dataInizio, LocalDate dataFine) {
        this.mezzo = mezzo;
        this.causa = causa;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public UUID getId() {
        return manutenzioneId;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "manutenzioneId=" + manutenzioneId +
                ", mezzo=" + (mezzo != null ? mezzo.getId() : null) +
                ", causa='" + causa + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
