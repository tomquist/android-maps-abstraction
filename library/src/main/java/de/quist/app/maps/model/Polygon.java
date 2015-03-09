package de.quist.app.maps.model;

import java.util.List;

public interface Polygon extends MapOverlay, PointSequence, Strokeable, Fillable, ZOrderable {

    void setHoles(List<? extends List<LatLng>> holes);

    List<List<LatLng>> getHoles();

}
