package de.quist.app.mapsabstraction;

import android.graphics.Point;

import de.quist.app.mapsabstraction.model.LatLng;
import de.quist.app.mapsabstraction.model.VisibleRegion;

public interface Projection {

    LatLng fromScreenLocation(Point point);

    Point toScreenLocation(LatLng location);

    VisibleRegion getVisibleRegion();


}
