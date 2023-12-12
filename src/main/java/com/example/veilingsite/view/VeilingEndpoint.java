package com.example.veilingsite.view;

import com.example.veilingsite.domain.Veiling;
import com.example.veilingsite.persist.VeilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeilingEndpoint {

    @Autowired
    VeilingService vs;

    // CREATE
    @PostMapping("veilingstuk/{id}/veiling")
    public Veiling maakVeiling(@PathVariable("id") long itemID, @RequestBody Veiling veiling) {
        return vs.createVeiling(itemID, veiling);
    }
}
