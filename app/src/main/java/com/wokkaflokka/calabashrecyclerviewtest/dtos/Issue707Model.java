package com.wokkaflokka.calabashrecyclerviewtest.dtos;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Issue707Model implements Serializable {

    private List<Image> publishedPhotos;
    private List<Image> archivedPhotos;

    public List<Image> getPublishedPhotos() {
        return publishedPhotos;
    }

    public void setPublishedPhotos(List<Image> publishedPhotos) {
        this.publishedPhotos = publishedPhotos;
    }

    public List<Image> getArchivedPhotos() {
        return archivedPhotos;
    }

    public void setArchivedPhotos(List<Image> archivedPhotos) {
        this.archivedPhotos = archivedPhotos;
    }

    public static Issue707Model getTestModel() {
        Issue707Model model = new Issue707Model();

        List<Image> images = new LinkedList<>();

        Image image = new Image();
        image.setUrl("http://cdn.grumpycats.com/wp-content/uploads/2016/02/12654647_974282002607537_7798179861389974677_n-758x758.jpg");
        image.setCaption("Grumpy Cat");
        images.add(image);

        image = new Image();
        image.setUrl("http://blog.twobeerdudes.com/wp-content/uploads/2011/01/russianrivercaseple1.jpg");
        image.setCaption("Pliny the Elder");
        images.add(image);

        image = new Image();
        image.setUrl("http://blog.waveavenue.com.s167390.gridserver.com/wp-content/uploads/2013/05/thenarrowintexas2.jpg");
        image.setCaption("Swimming");
        images.add(image);

        image = new Image();
        image.setUrl("http://cdn.grumpycats.com/wp-content/uploads/2016/02/12654647_974282002607537_7798179861389974677_n-758x758.jpg");
        image.setCaption("Grumpy Cat");
        images.add(image);

        model.setPublishedPhotos(images);

        List<Image> archived = new LinkedList<>();
        archived.addAll(images);
        archived.add(image);

        model.setArchivedPhotos(archived);

        return model;
    }
}
