package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Bod;
import com.example.veilingsite.domain.Veiling;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BodRepository extends CrudRepository<Bod, Long> {
    List<Bod> findByVeilingId(long veilingID);

    Bod findTopByVeilingOrderByPrijsInEuroDesc(Veiling veiling);
}
