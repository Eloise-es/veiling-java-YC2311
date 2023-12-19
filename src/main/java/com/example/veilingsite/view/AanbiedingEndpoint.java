package com.example.veilingsite.view;

import com.example.veilingsite.domain.Veilingstuk;
import com.example.veilingsite.persist.AanbiedingService;
import com.example.veilingsite.persist.AccountRepository;
import com.example.veilingsite.persist.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AanbiedingEndpoint {
    @Autowired
    AanbiedingService abs;

    @Autowired
    ItemService is;

    @Autowired
    AccountRepository ar;

    // CREATE
    @PostMapping("account/{accID}/aanbieden")
    public Veilingstuk maakVeilingstuk(@RequestBody Veilingstuk v, @PathVariable("accID") long accID) {
        System.out.println(v.getNaam());
        return abs.createVeilingstuk(v, accID);
    }

    // CREATE with image
    @PostMapping("account/{accID}/aanbieden/foto/{fotoID}")
    public Veilingstuk maakVeilingstukMetFoto(@RequestBody Veilingstuk v, @PathVariable("accID") long accID, @PathVariable("fotoID") long fotoID) {
        System.out.println(v.getNaam());
        return abs.createVeilingstuk(v, accID, fotoID);
    }
}
