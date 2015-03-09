package de.quist.app.mapsabstraction.model;


public interface Circle extends MapOverlay, Positionable, Fillable, Strokeable, ZOrderable {

    /**
     * @see #setPosition(LatLng)
     */
    void setCenter(LatLng center);

    /**
     * @see #getPosition()
     */
    LatLng getCenter();

    void setRadius(double radius);

    double getRadius();

}
