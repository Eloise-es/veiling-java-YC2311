package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Veilingstuk, Long> {

}
