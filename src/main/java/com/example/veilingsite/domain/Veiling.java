package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Veiling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "veilingstuk_id")
    private Veilingstuk veilingstuk;

    LocalDateTime startDatum;
    int duratieInSeconden;
    public enum VeilingStatus {
        SCHEDULED,
        OPEN,
        CLOSED
    }
    int openingsBodInEuros;
    int laatsteBodInEuros;
    int minimumBodInEuros;

    @JsonProperty("veilingstuk_id")
    public Long getVeilingstukId() { return veilingstuk != null ? veilingstuk.getId() : null;  }

    public Veiling(LocalDateTime startDatum, int duratieInSeconden, int openingsBodInEuros, int laatsteBodInEuros, int minimumBodInEuros) {
        this.startDatum = startDatum;
        this.duratieInSeconden = duratieInSeconden;
        this.openingsBodInEuros = openingsBodInEuros;
        this.laatsteBodInEuros = laatsteBodInEuros;
        this.minimumBodInEuros = minimumBodInEuros;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter + Setter voor veilingStatus
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

    public int getDuratieInSeconden() {
        return duratieInSeconden;
    }

    public void setDuratieInSeconden(int duratieInSeconden) {
        this.duratieInSeconden = duratieInSeconden;
    }

    public int getOpeningsBodInEuros() {
        return openingsBodInEuros;
    }

    public void setOpeningsBodInEuros(int openingsBodInEuros) {
        this.openingsBodInEuros = openingsBodInEuros;
    }

    public int getLaatsteBodInEuros() {
        return laatsteBodInEuros;
    }

    public void setLaatsteBodInEuros(int laatsteBodInEuros) {
        this.laatsteBodInEuros = laatsteBodInEuros;
    }

    public int getMinimumBodInEuros() {
        return minimumBodInEuros;
    }

    public void setMinimumBodInEuros(int minimumBodInEuros) {
        this.minimumBodInEuros = minimumBodInEuros;
    }
}
