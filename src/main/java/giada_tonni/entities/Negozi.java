package giada_tonni.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "negozi")
public class Negozi extends PuntiVendita {
    //ATTRIBUTI
    @Column(name = "titolo", nullable = false)
    private String titolo;
    @Enumerated(EnumType.STRING)
    @Column(name = "stato_negozio", nullable = false)
    private StatoNegozio statoNegozio;

    //COSTRUTTORI
    public Negozi() {
    }

    public Negozi(String titolo, String locazione) {
        super(locazione);
        this.titolo = titolo;
        this.statoNegozio = StatoNegozio.APERTO;
    }

    //GETTER E SETTER

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public StatoNegozio getStatoNegozio() {
        return statoNegozio;
    }

    public void setStatoNegozio(StatoNegozio statoNegozio) {
        this.statoNegozio = statoNegozio;
    }
}
