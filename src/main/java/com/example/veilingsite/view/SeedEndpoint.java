package com.example.veilingsite.view;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Foto;
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
        List<Foto> fotos = new ArrayList<>();

        // Maak accounts aan
        accounts.add(new Account("eloise.es@outlook.com", "hello", "Eloise Salmon", "0612345678", "Amsterdam", "1012AB"));
        accounts.add(new Account("olga.kovalenko@email.com", "geheim456", "Olga Kovalenko", "0612987654", "Rotterdam", "3012BC"));
        accounts.add(new Account("maartje@email.com", "maartje", "Maartje Smit", "0622221332", "Groningen", "9711AA"));
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
        accounts.add(new Account("laura.pietersen@email.com", "laura", "Laura Pietersen", "0612890432", "Amsterdam", "1071BA"));
        accounts.add(new Account("thomas.kok@email.com", "geheim321", "Thomas Kok", "0612765489", "Den Haag", "2517CD"));
        accounts.add(new Account("anne.vandijk@email.com", "123wachtwoord", "Anne van Dijk", "0612312312", "Rotterdam", "3031DE"));
        accounts.add(new Account("martijn.janssen@email.com", "wachtwoord789", "Martijn Janssen", "0612987654", "Utrecht", "3511AB"));
        accounts.add(new Account("sophie.dejong@email.com", "geheim654", "Sophie de Jong", "0612123456", "Groningen", "9712CC"));
        accounts.add(new Account("teatime_enthusiast@email.com", "cuppa123", "Alice Thompson", "0612345678", "Amsterdam", "1012AB"));
        accounts.add(new Account("bookworm@email.com", "pages789", "Emma Wilson", "0612765432", "Eindhoven", "5612YZ"));
        System.out.println("Accounts aangemaakt");

        // Maak veilingstukken aan
        veilingstukken.add(new Veilingstuk("Keukenmachine", "Huishouden", LocalDate.of(2018, 4, 22), "Een krachtige keukenmachine met verschillende hulpstukken om koken makkelijker te maken.", 3000, 25, 30, 40));
        veilingstukken.add(new Veilingstuk("Smartphone", "Electronica", LocalDate.of(2020, 7, 10), "Een geavanceerde smartphone met uitstekende specificaties en een helder scherm.", 150, 7, 15, 0.5));
        veilingstukken.add(new Veilingstuk("Schilderij", "Kunst", LocalDate.of(1910, 5, 3), "Een prachtig schilderij uit de vroege 20e eeuw met levendige kleuren en een interessante compositie.", 2000, 70, 90, 4));
        veilingstukken.add(new Veilingstuk("Jurk", "Mode", LocalDate.of(1965, 9, 12), "Een elegante vintage jurk uit de jaren '60, met een uniek ontwerp en hoogwaardige materialen.", 800, 40, 30, 2));
        veilingstukken.add(new Veilingstuk("Ketting", "Sieraden", LocalDate.of(1980, 3, 25), "Een prachtige zilveren ketting met ingelegde edelstenen, een tijdloos stuk.", 500, 10, 5, 0.2));
        veilingstukken.add(new Veilingstuk("Tuinset", "Tuin", LocalDate.of(2015, 6, 7), "Een complete tuinset met tafel en stoelen, perfect voor buitenactiviteiten.", 15000, 120, 80, 70));
        veilingstukken.add(new Veilingstuk("Oldtimer auto", "Vervoer", LocalDate.of(1978, 12, 19), "Een klassieke auto uit de jaren '70, in goede staat en met een rijke historie.", 1200000, 180, 70, 50));
        veilingstukken.add(new Veilingstuk("Laptop", "Electronica", LocalDate.of(2019, 10, 5), "Een krachtige laptop geschikt voor zowel werk als entertainment.", 2000, 35, 25, 1));
        veilingstukken.add(new Veilingstuk("Koffiemachine", "Huishouden", LocalDate.of(2017, 3, 15), "Een geavanceerde koffiemachine die diverse koffiespecialiteiten kan bereiden.", 5000, 20, 30, 40));
        veilingstukken.add(new Veilingstuk("Fiets", "Vervoer", LocalDate.of(2014, 3, 15), "Een betrouwbare stadsfiets voor dagelijks gebruik, in goede staat.", 5000, 120, 20, 70));
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
        veilingstukken.add(new Veilingstuk("Draadloze Koptelefoon", "Electronica", LocalDate.of(2018, 9, 8), "Een hoogwaardige draadloze koptelefoon met uitstekende geluidskwaliteit.", 300, 10, 15, 5));
        veilingstukken.add(new Veilingstuk("Stofzuiger", "Huishouden", LocalDate.of(2016, 7, 22), "Een krachtige stofzuiger met verschillende hulpstukken voor grondige reiniging.", 4000, 30, 35, 10));
        veilingstukken.add(new Veilingstuk("Olieverfschilderij", "Kunst", LocalDate.of(1955, 12, 3), "Een prachtig olieverfschilderij dat de schoonheid van de natuur vastlegt.", 2500, 80, 100, 4));
        System.out.println("Veilingstukken aangemaakt");

        veilingen.add(new Veiling(LocalDateTime.now(), 30, 150));
        veilingen.add(new Veiling(LocalDateTime.now().plusHours(3), 20, 300));
        veilingen.add(new Veiling(LocalDateTime.now().minusDays(2), 30, 80));
        veilingen.add(new Veiling(LocalDateTime.now().minusDays(3), 30, 450));
        veilingen.add(new Veiling(LocalDateTime.now().minusDays(4), 30, 200));
        veilingen.add(new Veiling(LocalDateTime.now().minusDays(5), 30, 3));
        veilingen.add(new Veiling(LocalDateTime.now().minusDays(1), 30, 4));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(1), 30, 2));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(2), 30, 120));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(3), 30, 350));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(4), 30, 100));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(5), 30, 280));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(5), 30, 180));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(20), 30, 5));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(30), 30, 8));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(10), 30, 7));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(9), 30, 150));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(15), 30, 300));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(30), 30, 80));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(35), 30, 450));
        veilingen.add(new Veiling(LocalDateTime.now().plusHours(1), 30, 200));
        veilingen.add(new Veiling(LocalDateTime.now().plusHours(2), 30, 120));
        veilingen.add(new Veiling(LocalDateTime.now().plusHours(6), 30, 350));
        veilingen.add(new Veiling(LocalDateTime.now().plusHours(15), 30, 180));
        veilingen.add(new Veiling(LocalDateTime.now().plusHours(7), 30, 6));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(1), 30, 9));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(15), 30, 15));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(60), 30, 8));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(1000), 30, 7));
        veilingen.add(new Veiling(LocalDateTime.now().plusMinutes(40), 30, 6));
        veilingen.add(new Veiling(LocalDateTime.now(), 30, 9));
        veilingen.add(new Veiling(LocalDateTime.now().plusDays(1), 30, 3));
        veilingen.add(new Veiling(LocalDateTime.now().plusMonths(1).plusMinutes(1), 30, 4));
        veilingen.add(new Veiling(LocalDateTime.now().plusMonths(2).plusMinutes(15), 30, 2));
        veilingen.add(new Veiling(LocalDateTime.now().plusMonths(3).plusMinutes(300), 30, 1));
        veilingen.add(new Veiling(LocalDateTime.now().plusMonths(5).plusMinutes(15), 30, 7));
        veilingen.add(new Veiling(LocalDateTime.now().plusMonths(6).plusMinutes(50), 30, 1));
        veilingen.add(new Veiling(LocalDateTime.now().plusMonths(7).plusMinutes(4000), 30, 7));
        System.out.println("Veilingen aangemaakt");

        fotos.add(fs.saveFoto("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png"));
        fotos.add(fs.saveFoto("https://res.cloudinary.com/dzqkr91yz/image/upload/v1702938325/veilingsite/wpbuvz1nffwxhxkavwyl.jpg"));
        fotos.add(fs.saveFoto("https://res.cloudinary.com/dzqkr91yz/image/upload/v1702979279/veilingsite/rhrcl32h668yxhfi3mgc.jpg"));
        fotos.add(fs.saveFoto("https://res.cloudinary.com/dzqkr91yz/image/upload/v1702938640/veilingsite/uhxdcedwcifpomtozckf.avif"));
        fotos.add(fs.saveFoto("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png"));
        fotos.add(fs.saveFoto("https://res.cloudinary.com/dzqkr91yz/image/upload/v1702901657/veilingsite/enajfrpimwxldhpcj8pg.jpg"));
        fotos.add(fs.saveFoto("https://res.cloudinary.com/dzqkr91yz/image/upload/v1702977467/veilingsite/lonvfyapbalae4wm1mnh.jpg"));
        fotos.add(fs.saveFoto("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png"));
        fotos.add(fs.saveFoto("https://res.cloudinary.com/dzqkr91yz/image/upload/v1702938035/veilingsite/sfqh0ypbacxvq0dpe01e.jpg"));
        fotos.add(fs.saveFoto("https://res.cloudinary.com/dzqkr91yz/image/upload/v1702978151/veilingsite/vw0ai7tavfnvmjokssgz.jpg"));
        System.out.println("Fotos aangemaakt");


        // Opslaan van accounts en veilingstukken
        for (Account account : accounts) {
            ar.save(account);
        }
        System.out.println("Accounts opgeslagen");

        Veilingstuk mijnItem = abs.createVeilingstuk(veilingstukken.get(0), 1, 1);
        vs.createVeiling(mijnItem.getId(), veilingen.get(0));

        for (int i = 1; i < veilingstukken.size(); i++) {
            Veilingstuk item;
            if (i < 10) {
                item = abs.createVeilingstuk(veilingstukken.get(i), (long) (Math.random()*25)+1, i+1);
            } else {
                item = abs.createVeilingstuk(veilingstukken.get(i), (long) (Math.random()*25)+1);
            }
            vs.createVeiling(item.getId(), veilingen.get(i));
            System.out.println("Item opgeslagen. i =" + i);
        }
       return ResponseEntity.ok("Database seeded.");
    }
}
