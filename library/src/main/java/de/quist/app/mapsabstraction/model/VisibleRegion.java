package de.quist.app.mapsabstraction.model;

public interface VisibleRegion {

    LatLng nearLeft();
    LatLng nearRight();
    LatLng farLeft();
    LatLng farRight();
    LatLngBounds latLngBounds();

}
