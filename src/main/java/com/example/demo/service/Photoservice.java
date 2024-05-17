package com.example.demo.service;

import com.example.demo.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class Photoservice {

    private Map<String, Photo> db=new HashMap<>();


    public Photo put(String filename, String contentType, byte[]data) {
        Photo p=new Photo(UUID.randomUUID().toString(),filename);
        p.setData(data);
        p.setType(contentType);
        db.put(p.getId(),p);
        return p;
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Collection<Photo> values() {
       return db.values();
    }
}
