package com.example.sqltestconnection.Controllers;

import com.example.sqltestconnection.Entities.Image;
import com.example.sqltestconnection.Repositories.ImageRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class ImageController {

    private final ImageRepository imageRepository;


    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    @GetMapping("/images/{id}")
   private ResponseEntity<?> getImageById(@PathVariable Long id){
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("filename", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
