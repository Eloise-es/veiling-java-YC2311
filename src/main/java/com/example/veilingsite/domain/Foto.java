package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "veilingstuk_id")
    private Veilingstuk veilingstuk;

    String url;
    String altText;

    public Foto(String imageUrl) {
        this.url = imageUrl;
    }

    public Foto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonBackReference
    public Veilingstuk getVeilingstuk() {
        return veilingstuk;
    }

    public void setVeilingstuk(Veilingstuk veilingstuk) {
        this.veilingstuk = veilingstuk;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}
