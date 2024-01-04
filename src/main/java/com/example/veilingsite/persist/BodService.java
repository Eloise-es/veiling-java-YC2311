package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Bod;
import com.example.veilingsite.domain.Veiling;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodService {
    @Autowired
    BodRepository br;

    @Autowired
    VeilingRepository vr;

    @Autowired
    AccountRepository ar;

    // CREATE
    public Bod createBod(long veilingID, long userID, Bod bod) throws Exception {
        // find veiling and user
        Veiling v = vr.findById(veilingID).orElseThrow(() -> new EntityNotFoundException("Veiling niet gevonden"));
        Account a = ar.findById(userID).orElseThrow(() -> new EntityNotFoundException("Account niet gevonden"));
        if (v.getVeilingStatus() != Veiling.VeilingStatus.OPEN) {
            throw new Exception("Veiling is niet open.");
        }
        try {
            // set laatste bod + minimum bod (throws exception if too low)
            v.setLaatsteBodInEuro(bod.getPrijsInEuro());
            // set and save bod
            bod.setVeiling(v);
            bod.setBieder(a);
            Bod savedBod = br.save(bod);
            // add saved bod to veiling and account, then save them
            a.getBiedingen().add(savedBod);
            v.getBiedingen().add(savedBod);
            ar.save(a);
            vr.save(v);
            return savedBod;
        } catch(Exception e) {
            System.out.println("Exception: " + e);
            throw e;
        }

    }

    public Bod getBodByID(long bodID) {
        return br.findById(bodID).get();
    }
}
