package com.example.veilingsite.persist;

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

    // CREATE
    public Bod createBod(long veilingID, Bod bod) {
        Veiling v = vr.findById(veilingID).orElseThrow(() -> new EntityNotFoundException("Veiling not found"));
        bod.setVeiling(v); // Set the veiling on the bod first
        Bod savedBod = br.save(bod); // Save the bod
        v.getBiedingen().add(savedBod); // Add the saved bod to the veiling
        vr.save(v); // Save the veiling to persist the relationship
        return savedBod;
    }

}
