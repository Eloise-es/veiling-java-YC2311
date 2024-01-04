package com.example.veilingsite.persist;


import com.example.veilingsite.domain.Account;
import com.example.veilingsite.domain.Bod;
import com.example.veilingsite.domain.Veiling;
import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.veilingsite.domain.Veiling.VeilingStatus.*;

@Service
public class VeilingService {

    @Autowired
    VeilingRepository vr;

    @Autowired
    ItemRepository ir;

    @Autowired
    BodRepository br;

    // CREATE
    public Veiling createVeiling(long itemID, Veiling veiling) {
        Veilingstuk item = ir.findById(itemID).get();
        item.getVeilingen().add(veiling);
        veiling.setVeilingstuk(item);
        veiling.setMinimumBodInEuro(veiling.getOpeningsBodInEuro());
        Veiling savedVeiling = vr.save(veiling);
        updateVeilingStatus(savedVeiling.getId());
        ir.save(item);
        return veiling;
    }

    // READ
    public Veiling getVeilingByID(long veilingID) {
        return vr.findById(veilingID).get();
    }

    public Iterable<Veiling> getVeilingen() {
        return vr.findAllByOrderByStartDatum();
    }

    public Account getWinningAccount(long veilingID) {
        Veiling veiling = vr.findById(veilingID).orElse(null);
        if (veiling == null || veiling.getVeilingStatus() != Veiling.VeilingStatus.CLOSED) {
            // Veiling not found or not closed yet
            return null;
        }

        Bod winningBid = br.findTopByVeilingOrderByPrijsInEuroDesc(veiling);
        return winningBid != null ? winningBid.getBieder() : null;
    }

    // UPDATE
    public void updateVeilingStatus(long veilingID) {
        LocalDateTime now = LocalDateTime.now();
        Veiling veiling = vr.findById(veilingID).get();
        LocalDateTime endDatum = veiling.getStartDatum().plusMinutes(veiling.getDuratieInMinuten());

        if (now.isBefore(veiling.getStartDatum())) {
            veiling.setVeilingStatus(SCHEDULED);
        } else if (now.isAfter(endDatum)) {
            veiling.setVeilingStatus(CLOSED);
        } else {
            veiling.setVeilingStatus(OPEN);
        }
        vr.save(veiling);
    }

    public void updateAllVeilingStatus() {
        Iterable<Veiling> veilingen = vr.findAll();
        veilingen.forEach(veiling -> updateVeilingStatus(veiling.getId()));
    }

    // DELETE
    public void deleteVeiling(long veilingID) {
        List<Bod> relatedBids = br.findByVeilingId(veilingID);
        if (!relatedBids.isEmpty()) {
            br.deleteAll(relatedBids);
        }
        vr.deleteById(veilingID);
    }
}
