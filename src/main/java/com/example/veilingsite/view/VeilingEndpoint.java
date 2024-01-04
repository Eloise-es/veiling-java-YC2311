package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Veiling;
import com.example.veilingsite.persist.VeilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VeilingEndpoint {

    @Autowired
    VeilingService vs;

    // CREATE
    @PostMapping("veilingstuk/{id}/veiling")
    public Veiling maakVeiling(@PathVariable("id") long itemID, @RequestBody Veiling veiling) {
        System.out.println("veiling aan het maken: " + veiling.getStartDatum());
        return vs.createVeiling(itemID, veiling);
    }

    // READ by id
    @GetMapping("veiling/{id}")
    public Veiling getVeiling(@PathVariable("id") long veilingID) {
        return vs.getVeilingByID(veilingID);
    }

    // READ + UPDATE alle veilingen
    @GetMapping("veilingen")
    public Iterable<Veiling> getVeilingen() {
        vs.updateAllVeilingStatus();
        return vs.getVeilingen();
    }

    // UPDATE
    @GetMapping("veiling/{id}/winnaar")
    public Account getWinnaar(@PathVariable("id") long veilingID) {
        return vs.getWinningAccount(veilingID);
    }

    // DELETE
    @DeleteMapping("veiling/{id}")
    public void verwijderVeiling(@PathVariable("id") long veilingID) {
        vs.deleteVeiling(veilingID);
    }
}
