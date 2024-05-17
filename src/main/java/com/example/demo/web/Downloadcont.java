package com.example.demo.web;

import com.example.demo.model.Photo;
import com.example.demo.service.Photoservice;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Downloadcont {

    private final Photoservice photoservice ;

    public Downloadcont(Photoservice photoservice) {
        this.photoservice=photoservice;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        Photo p=photoservice.get(id);
        if(p==null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        byte[] data=p.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(p.getType()));
        headers.setContentDispositionFormData("inline", p.getFilename());
        return new ResponseEntity<>(data,headers, HttpStatus.OK);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<byte[]> display(@PathVariable String id) {
        Photo p=photoservice.get(id);
        if(p==null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        byte[] data=p.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(p.getType()));
        headers.setContentDispositionFormData("attachment", p.getFilename());
        return new ResponseEntity<>(data,headers, HttpStatus.OK);
    }

}
