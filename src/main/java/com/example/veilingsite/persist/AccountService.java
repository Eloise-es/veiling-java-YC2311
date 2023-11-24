package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository ar;

    public Account createAccount(Account account) {
        ar.save(account);
        return account;
    }

    public Iterable<Account> getAccounts() {
        return ar.findAll();
    }
    public Account getAccount(long id) {
        Optional<Account> account = ar.findById(id);
        return account.orElse(null);
    }

    public Account updateAccount(long id, Account updatedAccount) {
        if (ar.findById(id).isEmpty()) return null;
        Account account = ar.findById(id).get();

        account.setEmail(updatedAccount.getEmail());
        account.setPassword(updatedAccount.getPassword());
        account.setNaam(updatedAccount.getNaam());
        account.setTelefoonNummer(updatedAccount.getTelefoonNummer());
        account.setPlaats(updatedAccount.getPlaats());
        account.setPostcode(updatedAccount.getPostcode());

        ar.save(account);
        return account;
    }

    public void deleteAccount(long id) {
        ar.deleteById(id);
    }
}
