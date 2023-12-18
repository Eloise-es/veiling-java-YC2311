package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Foto;
import org.springframework.data.repository.CrudRepository;

public interface FotoRepository extends CrudRepository<Foto, Long> {
}
