package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository ir;

    // CREATE
    public Veilingstuk createVeilingstuk(Veilingstuk veilingstuk) {
        ir.save(veilingstuk);
        return veilingstuk;
    }

    // READ - all items / item by id
    public Iterable<Veilingstuk> getVeilingstukken() {
        return ir.findAll();
    }

    public Veilingstuk getVeilingstuk(long id) {
        return ir.findById(id).get();
    }

    // UPDATE
    public Veilingstuk updateVeilingstuk(long id, Veilingstuk updatedVeilingstuk) {
        Optional<Veilingstuk> optionalVeilingstuk = ir.findById(id);
        if (optionalVeilingstuk.isEmpty()) return null;
        Veilingstuk destination = optionalVeilingstuk.get();
        // set id to match destination
        updatedVeilingstuk.setId(id);
        // copy properties over
        BeanUtils.copyProperties(updatedVeilingstuk, destination);
        // save to db
        ir.save(destination);
        return destination;
    }

    // DELETE
    public Veilingstuk deleteVeilingstuk(long id) {
        Veilingstuk v = ir.findById(id).get();
        ir.deleteById(id);
        return v;
    }
}
