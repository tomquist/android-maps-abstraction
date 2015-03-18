package de.quist.app.maps;

import android.graphics.Point;

import de.quist.app.maps.model.LatLng;
import de.quist.app.maps.model.VisibleRegion;

public interface Projection {

    LatLng fromScreenLocation(Point point);

    Point toScreenLocation(LatLng location);

    VisibleRegion getVisibleRegion();


}
