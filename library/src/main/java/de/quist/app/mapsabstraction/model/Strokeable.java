package de.quist.app.mapsabstraction.model;

public interface Strokeable extends MapOverlay {

    void setStrokeWidth(float width);

    float getStrokeWidth();

    void setStrokeColor(int color);

    int getStrokeColor();


}
