package de.quist.app.maps.model;

public interface Marker extends MapOverlay, Positionable {

    void setIcon(BitmapDescriptor icon);

    void setAnchor(float anchorU, float anchorV);

    void setInfoWindowAnchor(float anchorU, float anchorV);

    void setTitle(java.lang.String title);

    java.lang.String getTitle();

    void setSnippet(java.lang.String snippet);

    java.lang.String getSnippet();

    void setDraggable(boolean draggable);

    boolean isDraggable();

    void showInfoWindow();

    void hideInfoWindow();

    boolean isInfoWindowShown();

    void setFlat(boolean flat);

    boolean isFlat();

    void setRotation(float rotation);

    float getRotation();

    void setAlpha(float alpha);

    float getAlpha();

}
