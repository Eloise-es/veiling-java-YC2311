package com.example.veilingsite.persist;

import com.example.veilingsite.domain.Foto;
import com.example.veilingsite.domain.Veilingstuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {
    @Autowired
    FotoRepository fr;

    @Autowired
    ItemRepository ir;

    public void saveFoto(long itemID, String imageUrl) {
        Foto foto = new Foto(imageUrl);
        Veilingstuk item = ir.findById(itemID).get();
        foto.setVeilingstuk(item);
        item.getFotos().add(foto);
        fr.save(foto);
    }

    public void deleteFoto(long fotoID) {
        fr.deleteById(fotoID);
    }
}
