package com.example.veilingsite.persist;

import org.springframework.data.repository.CrudRepository;
import com.example.veilingsite.domain.Account;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

}
