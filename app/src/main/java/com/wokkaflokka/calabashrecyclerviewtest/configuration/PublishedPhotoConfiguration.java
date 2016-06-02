package com.wokkaflokka.calabashrecyclerviewtest.configuration;

import com.wokkaflokka.calabashrecyclerviewtest.dtos.Image;
import com.wokkaflokka.calabashrecyclerviewtest.dtos.Issue707Model;

public class PublishedPhotoConfiguration implements PhotoConfiguration {

    private final Issue707Model model;

    public PublishedPhotoConfiguration(Issue707Model model) {
        this.model = model;
    }

    @Override
    public int getItemCount() {
        return model.getPublishedPhotos().size();
    }

    @Override
    public Image getItemAtPosition(int position) {
        return model.getPublishedPhotos().get(position);
    }
}
