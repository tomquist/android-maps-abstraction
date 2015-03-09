package de.quist.app.mapsabstraction.model;

public interface ZOrderable extends MapOverlay {

    void setZIndex(float zIndex);

    float getZIndex();

}
