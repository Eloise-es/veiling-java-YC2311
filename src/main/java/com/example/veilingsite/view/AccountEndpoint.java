package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountEndpoint {
    @Autowired
    AccountService as;

    @GetMapping("/maak-account/{naam}")
    public Account maakAccount(@PathVariable("naam") String naam) {
        System.out.println("Hij doet het");
        Account a = as.createAccount();
        return a;
    }
}
