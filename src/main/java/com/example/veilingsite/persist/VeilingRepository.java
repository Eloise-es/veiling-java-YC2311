package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Veiling;
import org.springframework.data.repository.CrudRepository;

public interface VeilingRepository extends CrudRepository<Veiling, Long> {
}
