package com.example.veilingsite.persist;

import java.time.LocalDate;

public class ItemFilterCriteria {
    private String tekst;
    private String categorie;
    private Integer maxGewicht;
    private Integer minGewicht;
    private Integer maxHoogte;
    private Integer minHoogte;
    private Integer maxBreedte;
    private Integer minBreedte;
    private Integer maxLengte;
    private Integer minLengte;
    private LocalDate before;
    private LocalDate after;

    // getters and setters


    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getMaxGewicht() {
        return maxGewicht;
    }

    public void setMaxGewicht(Integer maxGewicht) {
        this.maxGewicht = maxGewicht;
    }

    public Integer getMinGewicht() {
        return minGewicht;
    }

    public void setMinGewicht(Integer minGewicht) {
        this.minGewicht = minGewicht;
    }

    public Integer getMaxHoogte() {
        return maxHoogte;
    }

    public void setMaxHoogte(Integer maxHoogte) {
        this.maxHoogte = maxHoogte;
    }

    public Integer getMinHoogte() {
        return minHoogte;
    }

    public void setMinHoogte(Integer minHoogte) {
        this.minHoogte = minHoogte;
    }

    public Integer getMaxBreedte() {
        return maxBreedte;
    }

    public void setMaxBreedte(Integer maxBreedte) {
        this.maxBreedte = maxBreedte;
    }

    public Integer getMinBreedte() {
        return minBreedte;
    }

    public void setMinBreedte(Integer minBreedte) {
        this.minBreedte = minBreedte;
    }

    public Integer getMaxLengte() {
        return maxLengte;
    }

    public void setMaxLengte(Integer maxLengte) {
        this.maxLengte = maxLengte;
    }

    public Integer getMinLengte() {
        return minLengte;
    }

    public void setMinLengte(Integer minLengte) {
        this.minLengte = minLengte;
    }

    public LocalDate getBefore() {
        return before;
    }

    public void setBefore(LocalDate before) {
        this.before = before;
    }

    public LocalDate getAfter() {
        return after;
    }

    public void setAfter(LocalDate after) {
        this.after = after;
    }
}