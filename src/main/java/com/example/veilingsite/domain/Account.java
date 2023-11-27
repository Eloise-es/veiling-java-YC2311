package com.example.veilingsite.domain;

import jakarta.persistence.*;

@Entity
public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;

        String email;
        String password;
        String naam;
        String telefoon;
        String plaats;
        String postcode;
//        LocalDate aanmaakDatum;

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
