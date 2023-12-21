package com.example.veilingsite.view;

import com.example.veilingsite.domain.Bod;
import com.example.veilingsite.persist.BodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BodEndpoint {
    @Autowired
    BodService bs;

    // CREATE
    @PostMapping("veiling/{veilingID}/account/{accountID}/bod")
    public Bod maakBod(@PathVariable("veilingID") long veilingID, @PathVariable("accountID") long accountID, @RequestBody Bod bod) {
        System.out.println("bod aan het maken: €" + bod.getPrijsInEuro());
        return bs.createBod(veilingID, accountID, bod);
    }

    // GET
    @GetMapping("bod/{bodID}")
    public Bod getBod(@PathVariable("bodID") long bodID) {
        return bs.getBodByID(bodID);
    }

}
