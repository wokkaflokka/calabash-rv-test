package com.wokkaflokka.calabashrecyclerviewtest.dtos;

import java.io.Serializable;

public class Image implements Serializable {

    private String url;
    private String caption;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}


