package de.quist.app.maps.model;

public interface Strokeable extends MapOverlay {

    void setStrokeWidth(float width);

    float getStrokeWidth();

    void setStrokeColor(int color);

    int getStrokeColor();


}
