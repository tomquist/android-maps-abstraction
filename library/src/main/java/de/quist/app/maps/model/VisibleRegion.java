package de.quist.app.maps.model;

public interface VisibleRegion {

    LatLng nearLeft();
    LatLng nearRight();
    LatLng farLeft();
    LatLng farRight();
    LatLngBounds latLngBounds();

}
