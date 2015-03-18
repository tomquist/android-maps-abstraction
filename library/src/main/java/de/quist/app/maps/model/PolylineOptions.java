package de.quist.app.maps.model;

import android.os.Parcelable;

import java.util.List;

public interface PolylineOptions extends Parcelable {

    PolylineOptions add(LatLng point);

    PolylineOptions add(LatLng... points);

    PolylineOptions addAll(Iterable<LatLng> points);

    PolylineOptions width(float width);

    PolylineOptions color(int color);

    PolylineOptions zIndex(float zIndex);

    PolylineOptions visible(boolean visible);

    PolylineOptions geodesic(boolean geodesic);

    List<LatLng> getPoints();

    float getWidth();

    int getColor();

    float getZIndex();

    boolean isVisible();

    boolean isGeodesic();

}
