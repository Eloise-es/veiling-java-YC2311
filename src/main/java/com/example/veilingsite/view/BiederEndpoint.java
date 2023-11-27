package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Bieder;
import com.example.veilingsite.persist.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BiederEndpoint {
    @Autowired
    AccountService as;

    @PostMapping("/account/{id}/favoriet/{itemID}")
    public ResponseEntity<String> voegFavorietToe(
            @PathVariable long id,
            @PathVariable long itemID) {
        // as.addFavourite(id, itemID); --> link item and bidder in table
        return ResponseEntity.ok("Favoriet toegevoegd.");
    }

    // CREATE - nieuwe account aanmaken
    @PostMapping("maak-account/bieder")
    public void maakAccount(@RequestBody Bieder bieder) {
        as.createBiederAccount(bieder);
        ;
    }
}
