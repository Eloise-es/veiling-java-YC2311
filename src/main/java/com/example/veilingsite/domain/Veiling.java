package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Veiling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "veilingstuk_id")
    private Veilingstuk veilingstuk;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veiling")
    @JsonManagedReference
    private List<Bod> biedingen = new ArrayList<Bod>();

    final static int STEP = 2;
    LocalDateTime startDatum;
    int duratieInMinuten;
    public enum VeilingStatus {
        SCHEDULED,
        OPEN,
        CLOSED
    }
    int openingsBodInEuro;
    int laatsteBodInEuro;
    int minimumBodInEuro;

    @JsonProperty("veilingstuk_id")
    public Long getVeilingstukId() { return veilingstuk != null ? veilingstuk.getId() : null;  }

    public Veiling(LocalDateTime startDatum, int duratieInMinuten, int openingsBodInEuro) {
        this.startDatum = startDatum;
        this.duratieInMinuten = duratieInMinuten;
        this.openingsBodInEuro = openingsBodInEuro;
        this.minimumBodInEuro = openingsBodInEuro + STEP;
    }

    public Veiling() {
    }

    @JsonBackReference
    public Veilingstuk getVeilingstuk() {
        return veilingstuk;
    }

    public void setVeilingstuk(Veilingstuk veilingstuk) {
        this.veilingstuk = veilingstuk;
    }

    @JsonManagedReference
    public List<Bod> getBiedingen() {
        return biedingen;
    }

    public void setBiedingen(List<Bod> biedingen) {
        this.biedingen = biedingen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private VeilingStatus veilingStatus;

    public VeilingStatus getVeilingStatus() {
        return veilingStatus;
    }

    public void setVeilingStatus(VeilingStatus veilingStatus) {
        this.veilingStatus = veilingStatus;
    }

    public LocalDateTime getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDateTime startDatum) {
        this.startDatum = startDatum;
    }

    public int getDuratieInMinuten() {
        return duratieInMinuten;
    }

    public void setDuratieInMinuten(int duratieInMinuten) {
        this.duratieInMinuten = duratieInMinuten;
    }

    public int getOpeningsBodInEuro() {
        return openingsBodInEuro;
    }

    public void setOpeningsBodInEuro(int openingsBodInEuro) {
        this.openingsBodInEuro = openingsBodInEuro;
    }

    public int getLaatsteBodInEuro() {
        return laatsteBodInEuro;
    }

    public void setLaatsteBodInEuro(int laatsteBodInEuro) throws IllegalArgumentException {

        if (laatsteBodInEuro >= minimumBodInEuro) {
            this.laatsteBodInEuro = laatsteBodInEuro;
            this.minimumBodInEuro = laatsteBodInEuro + STEP;
        } else throw new IllegalArgumentException("Bod is te laag.");

    }

    public int getMinimumBodInEuro() {
        return minimumBodInEuro;
    }

    public void setMinimumBodInEuro(int minimumBodInEuro) {
        this.minimumBodInEuro = minimumBodInEuro;
    }
}
