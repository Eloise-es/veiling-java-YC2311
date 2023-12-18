package com.example.veilingsite.view;

import com.example.veilingsite.persist.CloudinaryService;
import com.example.veilingsite.persist.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageEndpoint {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    FotoService fs;

    @PostMapping("/veilingstuk/{id}/upload")
    public ResponseEntity<String> uploadImage(@PathVariable("id") long itemID, @RequestParam("file") MultipartFile file) {
        String imageUrl = cloudinaryService.uploadFile(file);
        fs.saveFoto(itemID, imageUrl);
        return ResponseEntity.ok(imageUrl);
    }

    @DeleteMapping("/foto/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable("id") long fotoID) {
        fs.deleteFoto(fotoID);
        return ResponseEntity.ok("Foto verwijderd.");
    }
}