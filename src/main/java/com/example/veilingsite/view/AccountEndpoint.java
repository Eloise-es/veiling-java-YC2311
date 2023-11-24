package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class AccountEndpoint {
    @Autowired
    AccountService as;

    @GetMapping("/account/{id}")
    public Account zoekAccount(@PathVariable("id") long id) {
        System.out.println("Hij doet het");
        return as.getAccount(id);
    }

    @GetMapping("/alle-accounts")
    public String getAccounts() {
        System.out.println("Hij doet het");
        return "hi";
    }

    @PostMapping("maak-account")
    public Account maakAccount(@RequestBody Account a) {
        System.out.println(a.getNaam());
        return as.createAccount(a);

    }
}
