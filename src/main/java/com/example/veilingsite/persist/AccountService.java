package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository ar;

    public Account createAccount(Account a) {
        ar.save(a);
        return a;
    }

    public Account getAccount(long id) {
        Optional<Account> a = ar.findById(id);
        return a.orElse(null);
    }
}
