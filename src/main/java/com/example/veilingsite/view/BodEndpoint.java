package com.example.veilingsite.view;

import com.example.veilingsite.domain.Bod;
import com.example.veilingsite.persist.BodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodEndpoint {
    @Autowired
    BodService bs;

    // CREATE
    @PostMapping("veiling/{id}/bod")
    public Bod maakBod(@PathVariable("id") long veilingID, @RequestBody Bod bod) {
        System.out.println("bod aan het maken: €" + bod.getPrijsInEuro());
        return bs.createBod(veilingID, bod);
    }
}
