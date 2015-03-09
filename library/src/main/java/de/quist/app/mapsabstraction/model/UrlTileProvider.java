package de.quist.app.mapsabstraction.model;

import java.net.URL;

public interface UrlTileProvider {

    URL getTileUrl(int x, int y, int zoom);

}
