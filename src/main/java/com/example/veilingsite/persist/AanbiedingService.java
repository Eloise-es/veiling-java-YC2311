package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Foto;
import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AanbiedingService {

    @Autowired
    AccountRepository ar;

    @Autowired
    ItemRepository ir;

    @Autowired
    FotoRepository fr;


    public Veilingstuk createVeilingstuk(Veilingstuk v, long accID) {
        Account a = ar.findById(accID).get();
        ir.save(v);
        a.getAangeboden().add(v);
        v.setAanbieder(a);
        ar.save(a);
        return v;
    }

    public Veilingstuk createVeilingstuk(Veilingstuk v, long accID, long fotoID) {
        // get account and photo
        Account a = ar.findById(accID).get();
        Foto f = fr.findById(fotoID).get();
        // save item
        ir.save(v);
        // join account and item
        a.getAangeboden().add(v);
        v.setAanbieder(a);
        // join item and photo
        v.getFotos().add(f);
        f.setVeilingstuk(v);
        // save all
        ar.save(a);
        fr.save(f);
        // return item
        return ir.save(v);
    }
}

