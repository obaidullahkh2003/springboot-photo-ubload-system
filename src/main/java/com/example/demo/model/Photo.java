package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;
    @NotEmpty
    private String filename;
    @JsonIgnore
    private byte[] data;

    private String filetype;

    public String getType() {
        return filetype;
    }

    public void setType(String type) {
        this.filetype = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }


    public Photo(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public Photo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
