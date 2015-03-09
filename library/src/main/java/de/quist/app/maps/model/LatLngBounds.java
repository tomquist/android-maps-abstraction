package de.quist.app.maps.model;

public interface LatLngBounds {

    LatLng southwest();
    LatLng northeast();

    boolean contains(LatLng point);

    public LatLngBounds including(LatLng point);

    public LatLng getCenter();

    public static interface IBuilder {

        IBuilder include(LatLng point);

        LatLngBounds build();
    }

}
