package com.example.veilingsite.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bieder extends Account {

    @ManyToMany(mappedBy = "aanFavorietenToegevoegd")
    List<Veilingstuk> favorieten;

    public List<Veilingstuk> getVeilingstukken() {
        return favorieten;
    }

    public void setVeilingstukken(List<Veilingstuk> favorieten) {
        this.favorieten = favorieten;
    }
}
