package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account bieder;

    int prijsInEuro;


    public Account getBieder() {
        return bieder;
    }

    @JsonProperty("bieder_id")
    public Long getBiederId() { return bieder != null ? bieder.getId() : null;  }

    @JsonProperty("bieder_naam")
    public String getBiederNaam() { return bieder != null ? bieder.getNaam() : null;}

    @JsonProperty("veilingstuk_id")
    public Long getVeilingstukId() { return veiling != null ? veiling.getVeilingstuk().getId() : null;  }

    @JsonProperty("veilingstuk_naam")
    public String getVeilingstukNaam() { return veiling != null ? veiling.getVeilingstuk().getNaam() : null;}

    public void setBieder(Account bieder) {
        this.bieder = bieder;
    }

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
