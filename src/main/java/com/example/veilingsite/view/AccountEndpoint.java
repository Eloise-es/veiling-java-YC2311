package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class AccountEndpoint {
    @Autowired
    AccountService as;

// CREATE - nieuwe account aanmaken
    @PostMapping("maak-account")
    public Account maakAccount(@RequestBody Account a) {
        System.out.println(a.getNaam() + " account gemaakt");
        return as.createAccount(a);
    }

// READ - alle accounts / account by id
    @GetMapping("/alle-accounts")
    public Iterable<Account> alleAccounts() {
        System.out.println("Alle accounts");
        return as.getAccounts();
    }

    @GetMapping("/account/{id}")
    public Account zoekAccount(@PathVariable("id") long id) {
        System.out.println("Account gevonden");
        return as.getAccount(id);
    }

// UPDATE
    @PutMapping("/account/{id}")
    public Account editAccount(@PathVariable("id") long id, @RequestBody Account a) {
        System.out.println("Account bijgewerkt");
        return as.updateAccount(id, a);
    }

// DELETE
    @DeleteMapping("/account/{id}")
    public Account verwijderAccount(@PathVariable("id") long id) {
        Account account = as.deleteAccount(id);
        System.out.println(account.getNaam() + " verwijderd.");
        return account;
    }

    // favoriet toevoegen

    @PostMapping("/account/{id}/favoriet/{itemID}")
    public ResponseEntity<String> voegFavorietToe(
            @PathVariable long id,
            @PathVariable long itemID) {
        // as.addFavourite(id, itemID); --> link item and bidder in table
        return ResponseEntity.ok("Favoriet toegevoegd.");
    }
}
