package de.quist.app.mapsabstraction.model;

public interface Positionable extends MapOverlay {

    void setPosition(LatLng latLng);

    LatLng getPosition();

}
