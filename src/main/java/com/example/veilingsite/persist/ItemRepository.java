package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Veilingstuk, Long> {

    Iterable<Veilingstuk> findByCategorie(String categorie);
    Iterable<Veilingstuk> findByNaamContaining(String naam);

}
