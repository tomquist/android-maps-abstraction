package de.quist.app.maps.model;

public interface ZOrderable extends MapOverlay {

    void setZIndex(float zIndex);

    float getZIndex();

}
