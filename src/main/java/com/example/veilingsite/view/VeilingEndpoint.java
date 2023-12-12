package com.example.veilingsite.view;

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
        System.out.println("veiling aan het maken");
        return vs.createVeiling(itemID, veiling);
    }

    // READ
    // READ by id
    @GetMapping("veiling/{id}")
    public Veiling getVeiling(@PathVariable("id") long veilingID) {
        return vs.getVeilingByID(veilingID);
    }

    // READ alle veilingen
    @GetMapping("veilingen")
    public Iterable<Veiling> getVeilingen() {
        return vs.getVeilingen();
    }

    // UPDATE

    // DELETE
    @DeleteMapping("veiling/{id}")
    public void verwijderVeiling(@PathVariable("id") long veilingID) {
        vs.deleteVeiling(veilingID);
    }
}
