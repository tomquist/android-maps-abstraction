package de.quist.app.maps.model;

public interface TileProvider {

    Tile getTile(int x, int y, int zoom);

}
