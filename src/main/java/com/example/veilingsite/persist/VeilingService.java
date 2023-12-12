package com.example.veilingsite.persist;


import com.example.veilingsite.domain.Veiling;
import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeilingService {

    @Autowired
    VeilingRepository vr;

    @Autowired
    ItemRepository ir;

    public Veiling createVeiling(long itemID, Veiling veiling) {
        Veilingstuk item = ir.findById(itemID).get();
        item.getVeilingen().add(veiling);
        veiling.setVeilingstuk(item);
        vr.save(veiling);
        ir.save(item);
        return veiling;
    }

    public Veiling getVeilingByID(long veilingID) {
        return vr.findById(veilingID).get();
    }

    public Iterable<Veiling> getVeilingen() {
        return vr.findAllByOrderByStartDatum();
    }

    public void deleteVeiling(long veilingID) {
        vr.deleteById(veilingID);
    }
}
