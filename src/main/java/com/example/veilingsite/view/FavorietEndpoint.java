package com.example.veilingsite.view;

import com.example.veilingsite.persist.FavorietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavorietEndpoint {
    @Autowired
    FavorietService fs;

    @GetMapping("account/{accID}/veilingstuk/{itemID}")
    public void favoriet(@PathVariable("accID") long accID, @PathVariable("itemID") long itemID) {
        fs.koppel(accID, itemID);
    }
}
