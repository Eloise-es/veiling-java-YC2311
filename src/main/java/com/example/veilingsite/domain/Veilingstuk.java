package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Veilingstuk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account aanbieder;

    @OneToMany(mappedBy = "veilingstuk")
    List<Veiling> veilingen = new ArrayList<Veiling>();

    String naam;
    String categorie;
    LocalDate productieDatum;
    String beschrijving;
    double gewicht;
    double breedte;
    double lengte;
    double hoogte;

    @JsonBackReference
    public Account getAanbieder() {
        return aanbieder;
    }

    public Veilingstuk(String naam, String categorie, LocalDate productieDatum, String beschrijving, double gewicht, double breedte, double lengte, double hoogte) {
        this.naam = naam;
        this.categorie = categorie;
        this.productieDatum = productieDatum;
        this.beschrijving = beschrijving;
        this.gewicht = gewicht;
        this.breedte = breedte;
        this.lengte = lengte;
        this.hoogte = hoogte;
    }

    public Veilingstuk() {}

    @JsonManagedReference
    public List<Veiling> getVeilingen() {
        return veilingen;
    }

    public void setVeilingen(List<Veiling> veilingen) {
        this.veilingen = veilingen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAanbieder(Account aanbieder) {
        this.aanbieder = aanbieder;
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

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public double getHoogte() {
        return hoogte;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }
}
