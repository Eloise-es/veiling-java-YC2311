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

    @Autowired
    OpenaiService os;

    public void saveFoto(long itemID, String imageUrl) {
        Foto foto = new Foto(imageUrl);
        try {
            foto.setAltText(os.maakAltText(imageUrl));
        }
        catch (Exception e) {
            System.out.println(e);
            foto.setAltText("Foto geüpload door gebruiker.");
        }
        Veilingstuk item = ir.findById(itemID).get();
        foto.setVeilingstuk(item);
        item.getFotos().add(foto);
        fr.save(foto);
    }

    public Foto saveFoto(String imageUrl) {
        Foto foto = new Foto(imageUrl);
        try {
            foto.setAltText(os.maakAltText(imageUrl));
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
            foto.setAltText("Foto geüpload door gebruiker.");
        }
        fr.save(foto);
        return foto;
    }

    public void deleteFoto(long fotoID) {
        fr.deleteById(fotoID);
    }
}
