package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Veilingstuk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account aanbieder;

    String naam;
    String categorie;
    LocalDate productieDatum;
    String beschrijving;
    int gewicht;
    int breedte;
    int lengte;
    int hoogte;

    @JsonBackReference
    public Account getAanbieder() {
        return aanbieder;
    }

    public void setAanbieder(Account aanbieder) {
        this.aanbieder = aanbieder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LocalDate getProductieDatum() {
        return productieDatum;
    }

    public void setProductieDatum(LocalDate productieDatum) {
        this.productieDatum = productieDatum;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        this.breedte = breedte;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        this.hoogte = hoogte;
    }
}
