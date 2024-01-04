package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository ar;



    // CREATE
    public Account createAccount(Account account) {
        ar.save(account);
        return account;
    }

    // READ
    public Iterable<Account> getAccounts() {
        return ar.findAll();
    }
    public Account getAccount(long id) {
        Optional<Account> account = ar.findById(id);
        return account.orElse(null);
    }
    public Account getAccountByEmail(String email) {
        return ar.findByEmail(email).get();
    }


    // UPDATE
    public Account updateAccount(long id, Account updatedAccount) {
        Optional<Account> optionalAccount = ar.findById(id);
        if (optionalAccount.isEmpty()) return null;
        Account account = optionalAccount.get();

        if (updatedAccount.getEmail() != null) account.setEmail(updatedAccount.getEmail());
        if (updatedAccount.getPassword() != null) account.setPassword(updatedAccount.getPassword());
        if (updatedAccount.getNaam() != null) account.setNaam(updatedAccount.getNaam());
        if (updatedAccount.getTelefoon() != null) account.setTelefoon(updatedAccount.getTelefoon());
        if (updatedAccount.getPlaats() != null) account.setPlaats(updatedAccount.getPlaats());
        if (updatedAccount.getPostcode() != null) account.setPostcode(updatedAccount.getPostcode());

        ar.save(account);
        return account;
    }

    // DELETE
    public Account deleteAccount(long id) {
        Account a = ar.findById(id).get();
        ar.deleteById(id);
        return a;
    }

}
