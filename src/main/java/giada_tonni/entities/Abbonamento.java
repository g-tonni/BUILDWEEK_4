package giada_tonni.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "abbonamenti")
@PrimaryKeyJoinColumn(name = "codice_univoco")
public class Abbonamento extends TitoloViaggio {

    @Column(name = "id_tessera", nullable = false)
    private UUID idTessera;

    @Enumerated(EnumType.STRING)
    @Column(name = "validita", nullable = false)
    private Validita validita;

    @Column(name = "data_scadenza", nullable = false)
    private LocalDate scadenza;

    public Abbonamento() {
    }

    public Abbonamento(LocalDate dataAcquisto, UUID idTessera,
                       Validita validita, LocalDate scadenza) {
        super(dataAcquisto);
        this.idTessera = idTessera;
        this.validita = validita;
        this.scadenza = scadenza;
    }

    public UUID getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(UUID idTessera) {
        this.idTessera = idTessera;
    }

    public Validita getValidita() {
        return validita;
    }

    public void setValidita(Validita validita) {
        this.validita = validita;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "scadenza=" + scadenza +
                ", idTessera=" + idTessera +
                '}';
    }
}