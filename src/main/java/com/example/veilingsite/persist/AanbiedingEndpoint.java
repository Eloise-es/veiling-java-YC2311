package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Veilingstuk;
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

    // CREATE
    @PostMapping("account/{accID}/aanbieden")
    public Veilingstuk maakVeilingstuk(@RequestBody Veilingstuk v, @PathVariable("accID") long accID) {
        System.out.println(v.getNaam());
        return abs.createVeilingstuk(v, accID);
    }
}
