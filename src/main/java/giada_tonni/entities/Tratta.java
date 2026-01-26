package giada_tonni.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tratte")
public class Tratta {

    @Id
    @GeneratedValue
    @Column(name = "tratta_id")
    private UUID trattaId;

    @Column(name = "partenza", nullable = false)
    private String partenza;

    @Column(name = "capolinea", nullable = false)
    private String capolinea;

    @Column(name = "tempo_percorso_previsto", nullable = false)
    private long tempoPrevisto;

    public Tratta() {
    }

    public Tratta(String partenza, String capolinea, long tempoPrevisto) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.tempoPrevisto = tempoPrevisto;
    }

    public UUID getTrattaId() {
        return trattaId;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public long getTempoPrevisto() {
        return tempoPrevisto;
    }

    public void setTempoPrevisto(long tempoPrevisto) {
        this.tempoPrevisto = tempoPrevisto;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "trattaId=" + trattaId +
                ", partenza='" + partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoPrevisto=" + tempoPrevisto +
                '}';
    }
}
