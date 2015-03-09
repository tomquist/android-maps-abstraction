package de.quist.app.mapsabstraction.model;

import java.util.List;

public interface PointSequence extends MapOverlay {

    void setPoints(List<LatLng> points);

    List<LatLng> getPoints();

    void setGeodesic(boolean geodesic);

    boolean isGeodesic();

}
