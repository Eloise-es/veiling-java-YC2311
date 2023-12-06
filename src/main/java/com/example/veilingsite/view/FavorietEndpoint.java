package com.example.veilingsite.view;

import com.example.veilingsite.persist.FavorietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavorietEndpoint {
    @Autowired
    FavorietService fs;

    // favoriet toevoegen
    @GetMapping("account/{accID}/veilingstuk/{itemID}")
    public ResponseEntity<String> favoriet(@PathVariable("accID") long accID, @PathVariable("itemID") long itemID) {
        fs.addFavourite(accID, itemID);
        return ResponseEntity.ok("Favoriet toegevoegd.");
    }

    @DeleteMapping("account/{accID}/veilingstuk/{itemID}")
    public ResponseEntity<String> deleteFavoriet(@PathVariable("accID") long accID, @PathVariable("itemID") long itemID) {
        fs.removeFavourite(accID, itemID);
        return ResponseEntity.ok("Favoriet verwijderd.");
    }
}
