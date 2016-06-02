package com.wokkaflokka.calabashrecyclerviewtest.configuration;

import com.wokkaflokka.calabashrecyclerviewtest.dtos.Image;

public interface PhotoConfiguration {
    int getItemCount();
    Image getItemAtPosition(int position);
}
