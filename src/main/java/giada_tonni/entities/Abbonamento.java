package giada_tonni.entities;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
@PrimaryKeyJoinColumn(name = "id")
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

    public Abbonamento(LocalDate dataAcquisto, UUID rivenditoreId,
                       UUID idTessera, Validita validita, LocalDate scadenza) {
        super(dataAcquisto, rivenditoreId);
        this.idTessera = idTessera;
        this.validita = validita;
        this.scadenza = scadenza;
    }

    //GETTER AND SETTER


    public UUID getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(UUID idTessera) {
        this.idTessera = idTessera;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public Validita getValidita() {
        return validita;
    }

    public void setValidita(Validita validita) {
        this.validita = validita;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "idTessera=" + idTessera +
                ", validita=" + validita +
                ", scadenza=" + scadenza +
                '}';
    }
}