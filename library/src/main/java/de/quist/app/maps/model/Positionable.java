package de.quist.app.maps.model;

public interface Positionable extends MapOverlay {

    void setPosition(LatLng latLng);

    LatLng getPosition();

}
