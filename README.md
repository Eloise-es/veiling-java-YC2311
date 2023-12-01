# Java Backend van veilingsite (YCN nov 2023)

## Voorbeelden van relaties

### Many to many

Een account mag meerdere favorieten hebben.
Een veilingstuk mag van meerdere mensen opgeslagen worden.
Existing - existing

```java
// Account.java (niks in Veilingstuk.java)
    @ManyToMany
    List<Veilingstuk> favorieten;

// FavorietEndpoint.java
    @GetMapping("account/{accID}/veilingstuk/{itemID}")
    public ResponseEntity<String> favoriet(@PathVariable("accID") long accID, @PathVariable("itemID") long itemID) {
        fs.addFavourite(accID, itemID);
        return ResponseEntity.ok("Favoriet toegevoegd.");
    }

// FavorietService.java
    @Autowired
    AccountRepository ar;

    @Autowired
    ItemRepository ir;

    public void addFavourite(long accID, long itemID) {
        Account a = ar.findById(accID).get();v
        Veilingstuk v = ir.findById(itemID).get();
        a.getFavorieten().add(v);
        ar.save(a);
    }
```

### One to Many

Een veilingstuk moet altijd één aanbieder hebben.
Een anbeider mag meerdere veilingstukken aanbieden.
existing - non existing (veilingstuk aangemaakt met account id die al bestaat)

```java
// Account.java
    // declaration:
    @OneToMany(mappedBy = "aanbieder")
    List<Veilingstuk> aangeboden = new ArrayList<Veilingstuk>();

    // getter:
    @JsonManagedReference // stackexchange - avoid infinite recursion https://stackoverflow.com/questions/47693110/could-not-write-json-infinite-recursion-stackoverflowerror-nested-exception
    public List<Veilingstuk> getAangeboden() {
        return aangeboden;
    }
// Veilingstuk.java
    // declaration:
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account aanbieder;

    // getter:
    @JsonBackReference
    public Account getAanbieder() {
        return aanbieder;
    }

// AanbiedingEndpoint.java
    @Autowired
    AanbiedingService abs;

    @Autowired
    ItemService is;

    @PostMapping("account/{accID}/aanbieden")
    public Veilingstuk maakVeilingstuk(@RequestBody Veilingstuk v, @PathVariable("accID") long accID) {
        System.out.println(v.getNaam());
        return abs.createVeilingstuk(v, accID);
    }

// AanbiedingService.java
    @Autowired
    AccountRepository ar;

    @Autowired
    ItemRepository ir;

    public Veilingstuk createVeilingstuk(Veilingstuk veilingstuk, long accID) {
        Account a = ar.findById(accID).get();
        ir.save(veilingstuk);
        a.getAangeboden().add(veilingstuk);
        veilingstuk.setAanbieder(a);
        ar.save(a);
        return veilingstuk;
    }
```
