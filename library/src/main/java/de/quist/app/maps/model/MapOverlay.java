package de.quist.app.maps.model;

public interface MapOverlay {

    void remove();

    String getId();

    void setVisible(boolean visible);

    boolean isVisible();

}
