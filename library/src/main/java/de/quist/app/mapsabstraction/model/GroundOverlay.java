package de.quist.app.mapsabstraction.model;

public interface GroundOverlay extends MapOverlay, Positionable, ZOrderable {

    void setImage(BitmapDescriptor image);

    void setDimensions(float width);

    void setDimensions(float width, float height);

    float getWidth();

    float getHeight();

    void setPositionFromBounds(LatLngBounds bounds);

    LatLngBounds getBounds();

    void setBearing(float bearing);

    float getBearing();

    void setTransparency(float transparency);

    float getTransparency();

}
