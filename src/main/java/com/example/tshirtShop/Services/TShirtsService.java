package com.example.tshirtShop.Services;

import com.example.tshirtShop.Entities.Image;
import com.example.tshirtShop.Entities.TShirt;
import com.example.tshirtShop.Repositories.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class TShirtsService {
    private TShirtRepository tShirtRepository;

    @Autowired
    public TShirtsService(TShirtRepository tShirtRepository) {
        this.tShirtRepository = tShirtRepository;
    }
    public void saveTShirt(TShirt tShirt, MultipartFile file1, MultipartFile file2)  throws IOException {
        Image image1;
        Image image2;
        if(file1.getSize() !=0){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            tShirt.addImageToTShirt(image1);
        }
        if(file2.getSize() !=0){
            image2 = toImageEntity(file2);
            image2.setPreviewImage(true);
            tShirt.addImageToTShirt(image2);
        }
        TShirt tShirtFromDb = tShirtRepository.save(tShirt);
        tShirtFromDb.setPreviewImageId(tShirtFromDb.getImages().get(0).getId());
        tShirtRepository.save(tShirtFromDb);

    }

    private Image toImageEntity(MultipartFile file) throws IOException{
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    public List<TShirt> getTShirtsBySize(String size) {
        return tShirtRepository.findBySize(size);
    }


    public List<TShirt> getAllTShirts() {
        return tShirtRepository.findAll();
    }
    public TShirt getTShirtsById(Long id) {
        return tShirtRepository.findById(id).orElse(null);
    }
}
