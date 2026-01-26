package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="tessere_utente")
public class TesseraUtente {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="numero_tessera",nullable = false,unique = true)
    private Long numeroTessera;

    @Column(name="data_emissione",nullable = false)
    private LocalDate dataEmissione;

    @Column(name="data_scadenza",nullable = false)
    private LocalDate dataScadenza;

    @ManyToOne
    @JoinColumn(name="id_utente",nullable = false)
    private Utenti utente;

    public TesseraUtente() {
    }

    public TesseraUtente(Long numeroTessera, LocalDate dataEmissione, LocalDate dataScadenza) {
        this.numeroTessera = numeroTessera;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataEmissione.plusDays(1);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(Long numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utenti getUtente() {
        return utente;
    }

    @Override
    public String toString() {
        return "TesseraUtente{" +
                "id=" + id +
                ", numeroTessera=" + numeroTessera +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}
