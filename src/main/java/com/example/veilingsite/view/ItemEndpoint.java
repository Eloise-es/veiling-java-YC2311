package com.example.veilingsite.view;

import com.example.veilingsite.domain.Veilingstuk;
import com.example.veilingsite.persist.ItemRepository;
import com.example.veilingsite.persist.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemEndpoint {
    @Autowired
    ItemService is;

    // CREATE
    @PostMapping("maak-veilingstuk")
    public Veilingstuk maakVeilingstuk(@RequestBody Veilingstuk v) {
        System.out.println(v.getNaam() + " veilingstuk gemaakt.");
        return is.createVeilingstuk(v);
    }

    // READ - all items / item by id
    @GetMapping("veilingstukken")
    public Iterable<Veilingstuk> alleVeilingstukken() {
        System.out.println("Alle veilingstukken");
        return is.getVeilingstukken();
    }

    @GetMapping("veilingstuk/{id}")
    public Veilingstuk zoekVeilingstuk(@PathVariable("id") long id) {
        System.out.println("Veilingstuk gevonden.");
        return is.getVeilingstuk(id);
    }

    // UPDATE
    @PutMapping("veilingstuk/{id}")
    public Veilingstuk editVeilingstuk(@PathVariable("id") long id, @RequestBody Veilingstuk v) {
        System.out.println("Veilingstuk bijgewerkt.");
        return is.updateVeilingstuk(id, v);
    }


    // DELETE
    @DeleteMapping("veilingstuk/{id}")
    public Veilingstuk verwijderVeilingstuk(@PathVariable("id") long id) {
        Veilingstuk v = is.deleteVeilingstuk(id);
        System.out.println(v.getNaam() + " verwijderd.");
        return v;
    }
}
