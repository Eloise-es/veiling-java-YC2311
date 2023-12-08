package com.example.veilingsite.view;

import com.example.veilingsite.domain.Veilingstuk;
import com.example.veilingsite.persist.ItemFilterCriteria;
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

    // READ

    // get specific item by ID
    @GetMapping("veilingstuk/{id}")
    public Veilingstuk zoekVeilingstuk(@PathVariable("id") long id) {
        System.out.println("Veilingstuk gevonden.");
        return is.getVeilingstuk(id);
    }

    // get all items
    @GetMapping("veilingstukken")
    public Iterable<Veilingstuk> alleVeilingstukken() {
        System.out.println("Alle veilingstukken");
        return is.getVeilingstukken();
    }

    // get all in a category
    @GetMapping("veilingstukken/{categorie}")
    public Iterable<Veilingstuk> filterVeilingstukkenByCategorie(@PathVariable("categorie") String cat) {
        System.out.println("Veilingstukken van categorie " + cat);
        return is.filterVeilingstukkenByCategorie(cat);
    }

    // filter items (work in progress)
    @GetMapping("veilingstukken/filter")
    public Iterable<Veilingstuk> zoekVeilingstukken(@RequestParam (value = "tekst", required=false) String tekst,
                                                    @RequestParam (value = "categorie", required=false) String cat,
                                                    @RequestParam (value = "minGewicht", required=false) Integer minGewicht,
                                                    @RequestParam (value = "maxGewicht", required=false) Integer maxGewicht,
                                                    @RequestParam (value = "minHoogte", required=false) Integer minHoogte,
                                                    @RequestParam (value = "maxHoogte", required=false) Integer maxHoogte,
                                                    @RequestParam (value = "minBreedte", required=false) Integer minBreedte,
                                                    @RequestParam (value = "maxBreedte", required=false) Integer maxBreedte,
                                                    @RequestParam (value = "minLengte", required=false) Integer minLengte,
                                                    @RequestParam (value = "maxLengte", required=false) Integer maxLengte) {
        System.out.println("\nTekst:" + tekst);
        System.out.println("Categorie:" + cat);
        System.out.printf("Gewicht: Min = %d, Max = %d", minGewicht, maxGewicht);
        System.out.printf("\nHoogte: Min = %d, Max = %d", minHoogte, maxHoogte);
        System.out.printf("\nBreedte: Min = %d, Max = %d", minBreedte, maxBreedte);
        System.out.printf("\nLengte: Min = %d, Max = %d\n", minLengte, maxLengte);
        ItemFilterCriteria filterCriteria = new ItemFilterCriteria();
        filterCriteria.setTekst(tekst);
        filterCriteria.setCategorie(cat);
        filterCriteria.setMaxGewicht(maxGewicht);
        filterCriteria.setMinGewicht(minGewicht);
        filterCriteria.setMinHoogte(minHoogte);
        filterCriteria.setMaxHoogte(maxHoogte);
        filterCriteria.setMinBreedte(minBreedte);
        filterCriteria.setMaxBreedte(maxBreedte);
        filterCriteria.setMinLengte(minLengte);
        filterCriteria.setMaxLengte(maxLengte);

        return is.filterVeilingstukken(filterCriteria);
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
