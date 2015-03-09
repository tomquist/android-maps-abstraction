package de.quist.app.mapsabstraction.model;

public interface TileOverlay extends MapOverlay, ZOrderable {

    void clearTileCache();

    void setFadeIn(boolean fadeIn);

    boolean getFadeIn();
    
}
