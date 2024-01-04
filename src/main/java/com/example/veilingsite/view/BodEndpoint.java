package com.example.veilingsite.view;

import com.example.veilingsite.domain.Bod;
import com.example.veilingsite.persist.BodService;
import com.example.veilingsite.persist.VeilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BodEndpoint {
    @Autowired
    BodService bs;

    @Autowired
    VeilingService vs;

    // CREATE
    @PostMapping("veiling/{veilingID}/account/{accountID}/bod")
    public ResponseEntity<?> maakBod(@PathVariable("veilingID") long veilingID, @PathVariable("accountID") long accountID, @RequestBody Bod bod) {
        System.out.println("bod aan het maken: €" + bod.getPrijsInEuro());
        vs.updateVeilingStatus(veilingID);
        try {
            return ResponseEntity.ok(bs.createBod(veilingID, accountID, bod));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e);
        }
    }

    // GET
    @GetMapping("bod/{bodID}")
    public Bod getBod(@PathVariable("bodID") long bodID) {
        return bs.getBodByID(bodID);
    }

}
