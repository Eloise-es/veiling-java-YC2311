package com.example.veilingsite.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Aanbieder extends Account {
    @OneToMany
    List<Veilingstuk> veilingstukken;
}
