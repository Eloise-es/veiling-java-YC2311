package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Bieder;
import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository ar;

    @Autowired
    ItemRepository ir;

    // Account
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

        if (updatedAccount.getEmail() != null) account.setEmail(updatedAccount.getEmail());
        if (updatedAccount.getPassword() != null) account.setPassword(updatedAccount.getPassword());
        if (updatedAccount.getNaam() != null) account.setNaam(updatedAccount.getNaam());
        if (updatedAccount.getTelefoon() != null) account.setTelefoon(updatedAccount.getTelefoon());
        if (updatedAccount.getPlaats() != null) account.setPlaats(updatedAccount.getPlaats());
        if (updatedAccount.getPostcode() != null) account.setPostcode(updatedAccount.getPostcode());

        ar.save(account);
        return account;
    }

    public void deleteAccount(long id) {
        ar.deleteById(id);
    }

    // ******* Bieder ********
    public void createBiederAccount(Bieder b) {
        ar.save(b);
    }

}
