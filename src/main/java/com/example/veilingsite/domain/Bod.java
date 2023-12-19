package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Bod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "veiling_id")
    @JsonIgnore
    Veiling veiling;

    int prijsInEuro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Veiling getVeiling() {
        return veiling;
    }

    public void setVeiling(Veiling veiling) {
        this.veiling = veiling;
    }

    public int getPrijsInEuro() {
        return prijsInEuro;
    }

    public void setPrijsInEuro(int prijsInEuro) {
        this.prijsInEuro = prijsInEuro;
    }
}
