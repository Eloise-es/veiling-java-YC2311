package com.example.veilingsite.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Veilingstuk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToMany
    List<Bieder> aanFavorietenToegevoegd;

    String naam;
    String categorie;
    LocalDate productieDatum;
    String beschrijving;
    int gewicht;
    int breedte;
    int lengte;
    int hoogte;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Bieder> getAanFavorietenToegevoegd() {
        return aanFavorietenToegevoegd;
    }

    public void setAanFavorietenToegevoegd(List<Bieder> aanFavorietenToegevoegd) {
        this.aanFavorietenToegevoegd = aanFavorietenToegevoegd;
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
