package com.example.veilingsite.domain;

public class UserCredentials {
    private String email;
    private String password;

    public boolean checkCredentials(Account a) {
        return (a.getEmail().equals(this.email)) && a.getPassword().equals(this.password);
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
}
