package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository ar;

    public Account createAccount() {
        Account a = new Account();
        a.setNaam("Eloise");
        ar.save(a);
        return a;
    }
}
