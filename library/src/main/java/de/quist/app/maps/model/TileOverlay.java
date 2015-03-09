package de.quist.app.maps.model;

public interface TileOverlay extends MapOverlay, ZOrderable {

    void clearTileCache();

    void setFadeIn(boolean fadeIn);

    boolean getFadeIn();
    
}
