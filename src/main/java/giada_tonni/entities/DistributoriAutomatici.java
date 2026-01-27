package giada_tonni.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "distibutori_automatici")
@DiscriminatorValue("Distributore")
public class DistributoriAutomatici extends PuntiVendita {
    //ATTRIBUTI
    @Enumerated(EnumType.STRING)
    @Column(name = "stato_distibutori", nullable = false)
    private StatoDistributori statoDistributori;


    //COSTRUTTORI
    public DistributoriAutomatici() {
    }

    public DistributoriAutomatici(StatoDistributori statoDistributori, String locazione) {
        super(locazione);
        this.statoDistributori = statoDistributori;
    }
    //GETTER E SETTER

    public StatoDistributori getStatoDistributori() {
        return statoDistributori;
    }

    public void setStatoDistributori(StatoDistributori statoDistributori) {
        this.statoDistributori = statoDistributori;
    }
}
