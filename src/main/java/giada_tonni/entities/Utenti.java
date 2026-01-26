package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="utenti")
public class Utenti {
    @Id
    @GeneratedValue
    @Column(name="id_utente")
    private UUID id;

    private String nome;
    private String cognome;

    @Column(name="data_di_nascita")
    private LocalDate dataNascita;

    @OneToOne(mappedBy = "utente")
    private TesseraUtente tessera;

    public  Utenti(){
    }
    
    public Utenti(String nome, String cognome, LocalDate dataNascita){
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public TesseraUtente getTessera() {
        return tessera;
    }

    public void setTessera(TesseraUtente tessera) {
        this.tessera = tessera;
    }

    @Override
    public String toString() {
        return "Utenti{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
//                ", tessera=" + tessera +
                '}';
    }
}
