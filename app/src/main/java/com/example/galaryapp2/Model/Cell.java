package com.example.galaryapp2.Model;

import java.io.Serializable;

public class Cell implements Serializable {

    private String title,path;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
