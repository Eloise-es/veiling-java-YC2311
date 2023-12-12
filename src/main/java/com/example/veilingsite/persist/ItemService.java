package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Veilingstuk;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository ir;

    @PersistenceContext
    private EntityManager entityManager;

    // CREATE
    public Veilingstuk createVeilingstuk(Veilingstuk veilingstuk) {
        ir.save(veilingstuk);
        return veilingstuk;
    }

    // READ - all items / item by id
    public Iterable<Veilingstuk> getVeilingstukken() {
        return ir.findAll();
    }

    public Veilingstuk getVeilingstuk(long id) {
        return ir.findById(id).get();
    }

    public Iterable<Veilingstuk> filterVeilingstukkenByCategorie(String categorie) {
        return ir.findByCategorie(categorie);}

    public Iterable<Veilingstuk> filterVeilingstukkenByNaam(String naam) {
        return ir.findByNaamContaining(naam);}

    // UPDATE
    public Veilingstuk updateVeilingstuk(long id, Veilingstuk updatedVeilingstuk) {
        Optional<Veilingstuk> optionalVeilingstuk = ir.findById(id);
        if (optionalVeilingstuk.isEmpty()) return null;
        Veilingstuk destination = optionalVeilingstuk.get();
        // set id to match destination
        updatedVeilingstuk.setId(id);
        // copy properties over
        String[] ignoreProperties = {"aanbieder"};
        BeanUtils.copyProperties(updatedVeilingstuk, destination, ignoreProperties);
        // save to db
        ir.save(destination);
        return destination;
    }

    // DELETE
    public Veilingstuk deleteVeilingstuk(long id) {
        Veilingstuk v = ir.findById(id).get();
        ir.deleteById(id);
        return v;
    }

    // Criteria Builder
    public Iterable<Veilingstuk> filterVeilingstukken(ItemFilterCriteria filterCriteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Veilingstuk> query = builder.createQuery(Veilingstuk.class);
        Root<Veilingstuk> root = query.from(Veilingstuk.class);

        Predicate predicate = builder.conjunction();

        if (filterCriteria.getTekst() != null && !filterCriteria.getTekst().isEmpty()) {
            Predicate naamPredicate = builder.like(builder.lower(root.get("naam")), "%" + filterCriteria.getTekst().toLowerCase() + "%");
            Predicate beschrijvingPredicate = builder.like(builder.lower(root.get("beschrijving")), "%" + filterCriteria.getTekst().toLowerCase() + "%");
            predicate = builder.or(naamPredicate, beschrijvingPredicate);
        }
        if (filterCriteria.getCategorie() != null) {
            predicate = builder.and(predicate, builder.equal(root.get("categorie"), filterCriteria.getCategorie()));
        }

        if (filterCriteria.getMaxGewicht() != null || filterCriteria.getMinGewicht() != null) {
            if (filterCriteria.getMaxGewicht() != null && filterCriteria.getMinGewicht() != null) {
                predicate = builder.and(predicate, builder.between(root.get("gewicht"), filterCriteria.getMinGewicht(), filterCriteria.getMaxGewicht()));
            } else if (filterCriteria.getMinGewicht() != null) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get("gewicht"), filterCriteria.getMinGewicht()));
            } else if (filterCriteria.getMaxGewicht() != null) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(root.get("gewicht"), filterCriteria.getMaxGewicht()));
            }
        }

        if (filterCriteria.getMaxHoogte() != null || filterCriteria.getMinHoogte() != null) {
            if (filterCriteria.getMaxHoogte() != null && filterCriteria.getMinHoogte() != null) {
                predicate = builder.and(predicate, builder.between(root.get("hoogte"), filterCriteria.getMinHoogte(), filterCriteria.getMaxHoogte()));
            } else if (filterCriteria.getMinHoogte() != null) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get("hoogte"), filterCriteria.getMinHoogte()));
            } else if (filterCriteria.getMaxHoogte() != null) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(root.get("hoogte"), filterCriteria.getMaxHoogte()));
            }
        }

        if (filterCriteria.getMaxBreedte() != null || filterCriteria.getMinBreedte() != null) {
            if (filterCriteria.getMaxBreedte() != null && filterCriteria.getMinBreedte() != null) {
                predicate = builder.and(predicate, builder.between(root.get("breedte"), filterCriteria.getMinBreedte(), filterCriteria.getMaxBreedte()));
            } else if (filterCriteria.getMinBreedte() != null) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get("breedte"), filterCriteria.getMinBreedte()));
            } else if (filterCriteria.getMaxBreedte() != null) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(root.get("breedte"), filterCriteria.getMaxBreedte()));
            }
        }

        if (filterCriteria.getMaxLengte() != null || filterCriteria.getMinLengte() != null) {
            if (filterCriteria.getMaxLengte() != null && filterCriteria.getMinLengte() != null) {
                predicate = builder.and(predicate, builder.between(root.get("lengte"), filterCriteria.getMinLengte(), filterCriteria.getMaxLengte()));
            } else if (filterCriteria.getMinLengte() != null) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get("lengte"), filterCriteria.getMinLengte()));
            } else if (filterCriteria.getMaxLengte() != null) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(root.get("lengte"), filterCriteria.getMaxLengte()));
            }
        }


        query.where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

}
