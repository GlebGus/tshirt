package com.example.sqltestconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtsService {

    private TShirtRepository tShirtRepository;

    @Autowired
    public TShirtsService(TShirtRepository tShirtRepository) {
        this.tShirtRepository = tShirtRepository;
    }

    public List<TShirt> getTShirtsBySize(String size) {
        return tShirtRepository.findBySize(size);
    }
    public List<TShirt> getAllTShirts() {
        return tShirtRepository.findAll();
    }

}
