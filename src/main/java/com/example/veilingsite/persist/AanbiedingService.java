package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AanbiedingService {

    @Autowired
    AccountRepository ar;

    @Autowired
    ItemRepository ir;


    public Veilingstuk createVeilingstuk(Veilingstuk veilingstuk, long accID) {
        Account a = ar.findById(accID).get();
        ir.save(veilingstuk);
        a.getAangeboden().add(veilingstuk);
        veilingstuk.setAanbieder(a);
        ar.save(a);
        return veilingstuk;
    }
}
