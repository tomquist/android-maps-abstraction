package de.quist.app.maps.model;

import android.os.Parcelable;

public interface CircleOptions extends Parcelable {

    CircleOptions center(LatLng center);

    CircleOptions radius(double radius);

    CircleOptions strokeWidth(float width);

    CircleOptions strokeColor(int color);

    CircleOptions fillColor(int color);

    CircleOptions zIndex(float zIndex);

    CircleOptions visible(boolean visible);

    LatLng getCenter();

    public double getRadius();

    public float getStrokeWidth();

    public int getStrokeColor();

    public int getFillColor();

    public float getZIndex();

    public boolean isVisible();

}
