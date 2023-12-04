package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.veilingsite.domain.Account;

@Service
public class FavorietService {
    @Autowired
    AccountRepository ar;

    @Autowired
    ItemRepository ir;

    public void addFavourite(long accID, long itemID) {
        Account a = ar.findById(accID).get();
        Veilingstuk v = ir.findById(itemID).get();
        a.getFavorieten().add(v);
        ar.save(a);
    }

    public void removeFavourite(long accID, long itemID) {
        Account a = ar.findById(accID).get();
        Veilingstuk v = ir.findById(itemID).get();
        a.getFavorieten().remove(v);
        ar.save(a);
    }
}
