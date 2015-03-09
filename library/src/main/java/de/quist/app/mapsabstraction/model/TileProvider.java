package de.quist.app.mapsabstraction.model;

public interface TileProvider {

    Tile getTile(int x, int y, int zoom);

}
