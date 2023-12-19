package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Veiling;
import com.example.veilingsite.domain.Veilingstuk;
import com.example.veilingsite.persist.AanbiedingService;
import com.example.veilingsite.persist.AccountRepository;
import com.example.veilingsite.persist.FotoService;
import com.example.veilingsite.persist.VeilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SeedEndpoint {
    @Autowired
    AanbiedingService abs;

    @Autowired
    AccountRepository ar;

    @Autowired
    VeilingService vs;

    @Autowired
    FotoService fs;

    // SEED DATABASE
    @PostMapping("seed")
    public ResponseEntity<String> seedDatabase() throws Exception {
        List<Account> accounts = new ArrayList<>();
        List<Veilingstuk> veilingstukken = new ArrayList<>();
        List<Veiling> veilingen = new ArrayList<>();

        // Maak accounts aan
        accounts.add(new Account("piotr.nowak@email.com", "hasło123", "Piotr Nowak", "0612345678", "Amsterdam", "1012AB"));
        accounts.add(new Account("olga.kovalenko@email.com", "geheim456", "Olga Kovalenko", "0612987654", "Rotterdam", "3012BC"));
        accounts.add(new Account("maartje@email.com", "voorbeeld123", "Maartje Smit", "0622221332", "Groningen", "9711AA"));
        accounts.add(new Account("hoekman@email.com", "password456", "Lucas Hoekstra", "0633245333", "Maastricht", "6211BC"));
        accounts.add(new Account("flowerpower@email.com", "p@ssw0rd789", "Fleur van der Laan", "0655889955", "Haarlem", "2011DE"));
        accounts.add(new Account("visserruub@email.com", "test5678", "Ruben Visser", "0699666899", "Arnhem", "6811FG"));
        accounts.add(new Account("adventure.seeker@email.com", "explore567", "Aylin Yılmaz", "0612456789", "Utrecht", "3581DE"));
        accounts.add(new Account("noa.ark@email.com", "pass123word", "Noa Kuijpers", "0600067930", "Leiden", "2311AB"));
        accounts.add(new Account("nadia.kowalczyk@email.com", "tajne567", "Nadia Kowalczyk", "0612456789", "Utrecht", "3581DE"));
        accounts.add(new Account("ivan.popov@email.com", "пароль789", "Ivan Popov", "0612765432", "Eindhoven", "5612YZ"));
        accounts.add(new Account("jan.devries@email.com", "wachtwoord123", "Jan de Vries", "0612345678", "Den Haag", "2591AA"));
        accounts.add(new Account("animallover88@email.com", "safepassword456", "Li Wei", "0612987654", "Rotterdam", "3012BC"));
        accounts.add(new Account("musicfanatic@email.com", "raga123", "Aarav Kapoor", "0612121212", "Den Haag", "2591AA"));
        accounts.add(new Account("sarah.jansen@email.com", "geheim456", "Sarah Jansen", "0612987654", "Rotterdam", "3012BC"));
        accounts.add(new Account("peter.bosman@email.com", "1234wachtwoord", "Peter Bosman", "0612121212", "Utrecht", "3581DE"));
        accounts.add(new Account("lisa.meijer@email.com", "wachtwoord567", "Lisa Meijer", "0612456789", "Groningen", "9711XX"));
        accounts.add(new Account("michael.kramer@email.com", "geheim987", "Michael Kramer", "0612765432", "Eindhoven", "5612YZ"));
        accounts.add(new Account("cem.yılmaz@email.com", "123şifre", "Cem Yılmaz", "0612121212", "Den Haag", "2591AA"));
        accounts.add(new Account("laura.pietersen@email.com", "wachtwoord246", "Laura Pietersen", "0612890432", "Amsterdam", "1071BA"));
        accounts.add(new Account("thomas.kok@email.com", "geheim321", "Thomas Kok", "0612765489", "Den Haag", "2517CD"));
        accounts.add(new Account("anne.vandijk@email.com", "123wachtwoord", "Anne van Dijk", "0612312312", "Rotterdam", "3031DE"));
        accounts.add(new Account("martijn.janssen@email.com", "wachtwoord789", "Martijn Janssen", "0612987654", "Utrecht", "3511AB"));
        accounts.add(new Account("sophie.dejong@email.com", "geheim654", "Sophie de Jong", "0612123456", "Groningen", "9712CC"));
        accounts.add(new Account("teatime_enthusiast@email.com", "cuppa123", "Alice Thompson", "0612345678", "Amsterdam", "1012AB"));
        accounts.add(new Account("bookworm@email.com", "pages789", "Emma Wilson", "0612765432", "Eindhoven", "5612YZ"));

        // Maak veilingstukken aan
        veilingstukken.add(new Veilingstuk("Smartphone", "Electronica", LocalDate.of(2020, 7, 10), "Een geavanceerde smartphone met uitstekende specificaties en een helder scherm.", 150, 7, 15, 0.5));
        veilingstukken.add(new Veilingstuk("Keukenmachine", "Huishouden", LocalDate.of(2018, 4, 22), "Een krachtige keukenmachine met verschillende hulpstukken om koken makkelijker te maken.", 3000, 25, 30, 40));
        veilingstukken.add(new Veilingstuk("Schilderij", "Kunst", LocalDate.of(1910, 5, 3), "Een prachtig schilderij uit de vroege 20e eeuw met levendige kleuren en een interessante compositie.", 2000, 70, 90, 4));
        veilingstukken.add(new Veilingstuk("Jurk", "Mode", LocalDate.of(1965, 9, 12), "Een elegante vintage jurk uit de jaren '60, met een uniek ontwerp en hoogwaardige materialen.", 800, 40, 30, 2));
        veilingstukken.add(new Veilingstuk("Ketting", "Sieraden", LocalDate.of(1980, 3, 25), "Een prachtige zilveren ketting met ingelegde edelstenen, een tijdloos stuk.", 500, 10, 5, 0.2));
        veilingstukken.add(new Veilingstuk("Tuinset", "Tuin", LocalDate.of(2015, 6, 7), "Een complete tuinset met tafel en stoelen, perfect voor buitenactiviteiten.", 15000, 120, 80, 70));
        veilingstukken.add(new Veilingstuk("Oldtimer auto", "Vervoer", LocalDate.of(1978, 12, 19), "Een klassieke auto uit de jaren '70, in goede staat en met een rijke historie.", 1200000, 180, 70, 50));
        veilingstukken.add(new Veilingstuk("Laptop", "Electronica", LocalDate.of(2019, 10, 5), "Een krachtige laptop geschikt voor zowel werk als entertainment.", 2000, 35, 25, 1));
        veilingstukken.add(new Veilingstuk("Koffiemachine", "Huishouden", LocalDate.of(2017, 3, 15), "Een geavanceerde koffiemachine die diverse koffiespecialiteiten kan bereiden.", 5000, 20, 30, 40));
        veilingstukken.add(new Veilingstuk("Beeldhouwwerk", "Kunst", LocalDate.of(1950, 11, 28), "Een uniek beeldhouwwerk gemaakt door een bekende kunstenaar uit de 20e eeuw.", 3000, 40, 40, 80));
        veilingstukken.add(new Veilingstuk("Kunstwerk", "Kunst", LocalDate.of(1932, 8, 15), "Dit prachtige schilderij uit de 18e eeuw is een meesterwerk van kleur en compositie. Met levendige penseelstreken en een rijke geschiedenis is dit een unieke vondst voor kunstliefhebbers.", 500, 60, 80, 2));
        veilingstukken.add(new Veilingstuk("Robotstofzuiger", "Huishouden", LocalDate.of(2022, 2, 8), "Deze robotstofzuiger, beter bekend als 'Stoffer de Robo', is jouw loyale metgezel in de strijd tegen stof en vuil. Hij glijdt soepel over vloeren, brengt een futuristisch tintje aan je huishouden én heeft een hekel aan stofbollen.", 5000, 30, 30, 8));
        veilingstukken.add(new Veilingstuk("Popart-schilderij", "Kunst", LocalDate.of(1960, 7, 23), "Dit kleurrijke popart-schilderij brengt de levendigheid van de jaren '60 tot leven op je muur. Geïnspireerd door de stijl van die tijd, mixt het vertrouwde beelden met een eigenzinnige twist.", 4000, 80, 120, 3));
        veilingstukken.add(new Veilingstuk("Strandfiets", "Vervoer", LocalDate.of(1985, 6, 14), "Deze 'Zandrace Turbo' strandfiets is gemaakt voor avontuurlijke ritten langs de kustlijn. Met zijn opvallende kleuren en breed stuur, brengt hij niet alleen snelheid maar ook een glimlach op je gezicht.", 15000, 150, 60, 100));
        veilingstukken.add(new Veilingstuk("Flitsende Zonnebril", "Mode", LocalDate.of(2000, 4, 30), "Deze zonnebril, ook bekend als 'De Verblindende Glimlach', is jouw ultieme accessoire voor een flitsende look. Gegarandeerd om zowel ogen als aandacht te trekken op zonnige dagen.", 300, 15, 7, 5));
        veilingstukken.add(new Veilingstuk("Theepot met Persoonlijkheid", "Sieraden", LocalDate.of(1957, 9, 2), "Deze theepot, met de naam 'Mevrouw Porselein', heeft een eigenzinnige persoonlijkheid. Ze houdt van langzame theeceremonies en vertelt graag verhalen uit vervlogen tijden.", 700, 20, 20, 20));
        veilingstukken.add(new Veilingstuk("Vintage LP-speler", "Electronica", LocalDate.of(1973, 12, 17), "Deze vintage LP-speler, ook wel 'De Platenprins', brengt het ritme van de jaren '70 terug. Met zijn krakende geluid en retro charme, biedt hij een nostalgische luisterervaring.", 6000, 40, 30, 10));
        veilingstukken.add(new Veilingstuk("Reusachtige Tuinkabouter", "Tuin", LocalDate.of(2010, 5, 9), "Deze reusachtige tuinkabouter, met de naam 'Gert de Groene Beschermheer', waakt over je tuin met zijn indrukwekkende grootte en zijn glimlach die de zon laat schijnen.", 20000, 100, 40, 40));
        veilingstukken.add(new Veilingstuk("Vintage Scooter", "Vervoer", LocalDate.of(1968, 8, 25), "Deze vintage scooter, liefkozend 'Sprint Snelheidspiraat' genoemd, brengt je terug naar de tijd van hippies en vrije geesten. Een symbool van vrijheid en stijl op twee wielen.", 70000, 180, 60, 100));
        veilingstukken.add(new Veilingstuk("Modeaccessoire van een Ster", "Mode", LocalDate.of(1995, 3, 11), "Dit modeaccessoire, gedragen door een beroemde ster uit de jaren '90, straalt nog steeds de glans van roem uit. Een uniek stuk dat de tijd heeft doorstaan.", 200, 10, 5, 3));
        veilingstukken.add(new Veilingstuk("Kunstzinnige Wandklok", "Kunst", LocalDate.of(1945, 10, 18), "Deze kunstzinnige wandklok, genaamd 'De Tijdreiziger', is meer dan alleen een tijdweergave. Hij brengt kunst en functionaliteit samen in een uniek ontwerp dat de tijd doet stilstaan.", 3000, 50, 50, 5));
        veilingstukken.add(new Veilingstuk("Tablet", "Electronica", LocalDate.of(2017, 10, 20), "Een veelzijdige tablet, ideaal voor werk en entertainment onderweg.", 600, 15, 20, 1));
        veilingstukken.add(new Veilingstuk("Koffiezetapparaat", "Huishouden", LocalDate.of(2019, 5, 12), "Een geavanceerd koffiezetapparaat voor de perfecte ochtendbrouwsels.", 2500, 25, 30, 40));
        veilingstukken.add(new Veilingstuk("Beeldhouwwerk II", "Kunst", LocalDate.of(1978, 8, 7), "Een abstract beeldhouwwerk dat de verbeelding prikkelt met zijn vloeiende vormen.", 1800, 50, 50, 70));
        veilingstukken.add(new Veilingstuk("Designerjas", "Mode", LocalDate.of(2005, 4, 23), "Een exclusieve designerjas met een tijdloos ontwerp en hoogwaardige materialen.", 1200, 45, 30, 5));
        veilingstukken.add(new Veilingstuk("Zilveren Armband", "Sieraden", LocalDate.of(1990, 9, 18), "Een prachtige zilveren armband met ingewikkelde details, een elegante toevoeging aan elke outfit.", 300, 8, 4, 0.2));
        veilingstukken.add(new Veilingstuk("Barbecuegrill", "Tuin", LocalDate.of(2020, 6, 30), "Een robuuste barbecuegrill perfect voor zomerse buitenfeestjes.", 8000, 100, 60, 80));
        veilingstukken.add(new Veilingstuk("Fiets", "Vervoer", LocalDate.of(2014, 3, 15), "Een betrouwbare stadsfiets voor dagelijks gebruik, in goede staat.", 5000, 120, 20, 70));
        veilingstukken.add(new Veilingstuk("Draadloze Koptelefoon", "Electronica", LocalDate.of(2018, 9, 8), "Een hoogwaardige draadloze koptelefoon met uitstekende geluidskwaliteit.", 300, 10, 15, 5));
        veilingstukken.add(new Veilingstuk("Stofzuiger", "Huishouden", LocalDate.of(2016, 7, 22), "Een krachtige stofzuiger met verschillende hulpstukken voor grondige reiniging.", 4000, 30, 35, 10));
        veilingstukken.add(new Veilingstuk("Olieverfschilderij", "Kunst", LocalDate.of(1955, 12, 3), "Een prachtig olieverfschilderij dat de schoonheid van de natuur vastlegt.", 2500, 80, 100, 4));

        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 14, 9, 45, 0), 1800, 150, 200, 205));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 17, 15, 0, 0), 2000, 300, 350, 355));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 19, 11, 30, 0), 1800, 80, 130, 135));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 22, 18, 15, 0), 2500, 450, 500, 505));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 25, 10, 0, 0), 1800, 200, 250, 255));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 2, 26, 12, 45, 0), 3600, 3, 53, 58));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 2, 29, 20, 0, 0), 2000, 4, 54, 59));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 3, 16, 30, 0), 1800, 2, 52, 57));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 28, 12, 45, 0), 3600, 120, 170, 175));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 31, 20, 0, 0), 2000, 350, 400, 405));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 1, 3, 16, 30, 0), 1800, 100, 150, 155));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 1, 6, 14, 0, 0), 2800, 280, 330, 335));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 1, 9, 9, 15, 0), 1800, 180, 230, 235));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 2, 11, 17, 45, 0), 1800, 5, 55, 60));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 2, 14, 13, 0, 0), 2000, 8, 58, 63));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 2, 17, 10, 30, 0), 2500, 7, 57, 62));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 14, 9, 45, 0), 1800, 150, 200, 205));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 17, 15, 0, 0), 2000, 300, 350, 355));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 19, 11, 30, 0), 1800, 80, 130, 135));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 22, 18, 15, 0), 2500, 450, 500, 505));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 25, 10, 0, 0), 1800, 200, 250, 255));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 28, 12, 45, 0), 3600, 120, 170, 175));
        veilingen.add(new Veiling(LocalDateTime.of(2023, 12, 31, 20, 0, 0), 2000, 350, 400, 405));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 1, 9, 9, 15, 0), 1800, 180, 230, 235));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 2, 20, 19, 15, 0), 1800, 6, 56, 61));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 2, 23, 11, 0, 0), 1800, 9, 59, 64));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 12, 17, 45, 0), 1800, 15, 0, 20));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 15, 13, 0, 0), 2000, 8, 0, 13));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 18, 10, 30, 0), 2500, 7, 0, 12));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 21, 19, 15, 0), 1800, 6, 0, 11));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 24, 11, 0, 0), 1800, 9, 0, 14));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 27, 12, 45, 0), 3600, 3, 0, 8));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 30, 20, 0, 0), 2000, 4, 0, 9));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 4, 2, 16, 30, 0), 1800, 2, 0, 7));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 4, 5, 14, 0, 0), 2800, 1, 0, 6));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 4, 8, 9, 15, 0), 1800, 7, 0, 12));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 6, 14, 0, 0), 2800, 1, 51, 56));
        veilingen.add(new Veiling(LocalDateTime.of(2024, 3, 9, 9, 15, 0), 1800, 7, 57, 62));

        // Opslaan van accounts en veilingstukken
        for (Account account : accounts) {
            ar.save(account);
        }

        int i = 0;
        for (Veilingstuk veilingstuk : veilingstukken) {
            Veilingstuk item = abs.createVeilingstuk(veilingstuk, (long) (Math.random()*25)+1);
            vs.createVeiling(item.getId(), veilingen.get(i));
            fs.saveFoto(item.getId(), "http://res.cloudinary.com/dzqkr91yz/image/upload/v1702896879/veilingsite/nt3oajkfrlb27remfkqa.png");
            i++;
        }
       return ResponseEntity.ok("Database seeded.");
    }
}
