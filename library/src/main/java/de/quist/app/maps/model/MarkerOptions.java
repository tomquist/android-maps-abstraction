package de.quist.app.maps.model;

import android.os.Parcelable;

public interface MarkerOptions extends Parcelable {

    MarkerOptions position(LatLng position);

    MarkerOptions icon(BitmapDescriptor icon);

    MarkerOptions anchor(float u, float v);

    MarkerOptions infoWindowAnchor(float u, float v);

    MarkerOptions title(String title);

    MarkerOptions snippet(String snippet);

    MarkerOptions draggable(boolean draggable);

    MarkerOptions visible(boolean visible);

    MarkerOptions flat(boolean flat);

    MarkerOptions rotation(float rotation);

    MarkerOptions alpha(float alpha);

    LatLng getPosition();

    String getTitle();

    String getSnippet();

    BitmapDescriptor getIcon();

    float getAnchorU();

    float getAnchorV();

    boolean isDraggable();

    boolean isVisible();

    boolean isFlat();

    float getRotation();

    float getInfoWindowAnchorU();

    float getInfoWindowAnchorV();

    float getAlpha();
    
}
