package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.JwtTokenProvider;
import com.example.veilingsite.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountEndpoint {
    @Autowired
    AccountService as;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

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

    @GetMapping("/details")
    public ResponseEntity<?> getUserDetails(@RequestHeader("Authorization") String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            if (!jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
            }

            String email = jwtTokenProvider.getEmailFromToken(token);
            Account a = as.getAccountByEmail(email); // Fetch user details
            return ResponseEntity.ok(a);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

// UPDATE
    @PutMapping("/account/{id}")
    public Account editAccount(@PathVariable("id") long id, @RequestBody Account a) {
        System.out.println("Account bijgewerkt");
        return as.updateAccount(id, a);
    }

// DELETE
    @DeleteMapping("/account/{id}")
    public void verwijderAccount(@PathVariable("id") long id) {
        Account account = as.deleteAccount(id);
        System.out.println(account.getNaam() + " verwijderd.");
    }
}
