package com.example.demo.web;

import com.example.demo.model.Photo;
import com.example.demo.service.Photoservice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class Controler {

    private final Photoservice photoservice ;
    public Controler(Photoservice photoservice) {
        this.photoservice = photoservice;
    }

    @GetMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/show")
    public Collection<Photo> getDb(){
        return photoservice.values();
    }

    @GetMapping("/show/{id}")
    public Photo getDb(@PathVariable String id){
        Photo p=photoservice.get(id);
        if(p==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return p;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDb(@PathVariable String id){
        Photo p=photoservice.remove(id);
        if(p==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoservice.put(file.getOriginalFilename(),file.getContentType(), file.getBytes());
    }

}
