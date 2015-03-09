package de.quist.app.maps.model;

import android.os.Parcelable;

import java.util.List;

public interface PolygonOptions extends Parcelable {

    PolygonOptions add(LatLng point);

    PolygonOptions add(LatLng... points);

    PolygonOptions addAll(Iterable<LatLng> points);

    PolygonOptions addHole(Iterable<LatLng> points);

    PolygonOptions strokeWidth(float width);

    PolygonOptions strokeColor(int color);

    PolygonOptions fillColor(int color);

    PolygonOptions zIndex(float zIndex);

    PolygonOptions visible(boolean visible);

    PolygonOptions geodesic(boolean geodesic);

    List<LatLng> getPoints();

    List<List<LatLng>> getHoles();

    float getStrokeWidth();

    int getStrokeColor();

    int getFillColor();

    float getZIndex();

    boolean isVisible();

    boolean isGeodesic();

}
