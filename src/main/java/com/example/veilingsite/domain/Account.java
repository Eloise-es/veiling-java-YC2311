package com.example.veilingsite.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;

        @ManyToMany
        List<Veilingstuk> favorieten;

        @OneToMany(mappedBy = "aanbieder")
        List<Veilingstuk> aangeboden = new ArrayList<Veilingstuk>();

        @OneToMany(mappedBy = "bieder")
        List<Bod> biedingen = new ArrayList<Bod>();

        String email;
        String password;
        String naam;
        String telefoon;
        String plaats;
        String postcode;



        public List<Veilingstuk> getFavorieten() {
                return favorieten;
        }

        public void setFavorieten(List<Veilingstuk> favorieten) {
                this.favorieten = favorieten;
        }

        public Account(String email, String password, String naam, String telefoon, String plaats, String postcode) {
                this.email = email;
                this.password = password;
                this.naam = naam;
                this.telefoon = telefoon;
                this.plaats = plaats;
                this.postcode = postcode;
        }

        public Account(String naam) {
        this.naam = naam;
        }

        public Account() {
        }

        @JsonManagedReference
        public List<Veilingstuk> getAangeboden() {
                return aangeboden;
        }

        public void setAangeboden(List<Veilingstuk> aangeboden) {
                this.aangeboden = aangeboden;
        }

        public List<Bod> getBiedingen() {return biedingen;}

        public void setBiedingen(List<Bod> biedingen) {
                this.biedingen = biedingen;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getNaam() {
                return naam;
        }

        public void setNaam(String naam) {
                this.naam = naam;
        }

        public String getTelefoon() {
                return telefoon;
        }

        public void setTelefoon(String telefoon) {
                this.telefoon = telefoon;
        }

        public String getPlaats() {
                return plaats;
        }

        public void setPlaats(String plaats) {
                this.plaats = plaats;
        }

        public String getPostcode() {
                return postcode;
        }

        public void setPostcode(String postcode) {
                this.postcode = postcode;
        }
}
