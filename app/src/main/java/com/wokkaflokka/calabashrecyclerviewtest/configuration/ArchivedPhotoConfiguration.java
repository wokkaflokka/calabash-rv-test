package com.wokkaflokka.calabashrecyclerviewtest.configuration;

import com.wokkaflokka.calabashrecyclerviewtest.dtos.Image;
import com.wokkaflokka.calabashrecyclerviewtest.dtos.Issue707Model;

public class ArchivedPhotoConfiguration implements PhotoConfiguration {

    private final Issue707Model model;

    public ArchivedPhotoConfiguration(Issue707Model model) {
        this.model = model;
    }

    @Override
    public int getItemCount() {
        return model.getArchivedPhotos().size();
    }

    @Override
    public Image getItemAtPosition(int position) {
        return model.getArchivedPhotos().get(position);
    }
}
