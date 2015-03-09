package de.quist.app.mapsabstraction.model;

public interface MapOverlay {

    void remove();

    String getId();

    void setVisible(boolean visible);

    boolean isVisible();

}
