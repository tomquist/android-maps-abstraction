package de.quist.app.mapsabstraction.model;

import android.os.Parcelable;

public interface GroundOverlayOptions extends Parcelable {

    public static final float NO_DIMENSION = -1.0f;

    GroundOverlayOptions image(BitmapDescriptor image);

    GroundOverlayOptions anchor(float u, float v);

    GroundOverlayOptions position(LatLng location, float width);

    GroundOverlayOptions position(LatLng location, float width, float height);

    GroundOverlayOptions positionFromBounds(LatLngBounds bounds);

    GroundOverlayOptions bearing(float bearing);

    GroundOverlayOptions zIndex(float zIndex);

    GroundOverlayOptions visible(boolean visible);

    GroundOverlayOptions transparency(float transparency);

    BitmapDescriptor getImage();

    LatLng getLocation();

    float getWidth();

    float getHeight();

    LatLngBounds getBounds();

    float getBearing();

    float getZIndex();

    float getTransparency();

    float getAnchorU();

    float getAnchorV();

    boolean isVisible();
}
