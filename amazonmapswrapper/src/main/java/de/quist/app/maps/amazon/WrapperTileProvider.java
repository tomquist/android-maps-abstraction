package de.quist.app.maps.amazon;

import de.quist.app.maps.utils.Wrapper;

class WrapperTileProvider extends Wrapper<de.quist.app.maps.model.TileProvider> implements com.amazon.geo.mapsv2.model.TileProvider {

    static final Mapper<com.amazon.geo.mapsv2.model.TileProvider, WrapperTileProvider, de.quist.app.maps.model.TileProvider> MAPPER = new DefaultMapper<com.amazon.geo.mapsv2.model.TileProvider, WrapperTileProvider, de.quist.app.maps.model.TileProvider>() {

        @Override
        public WrapperTileProvider createWrapper(de.quist.app.maps.model.TileProvider original) {
            return original != null ? new WrapperTileProvider(original) : null;
        }
    };

    private WrapperTileProvider(de.quist.app.maps.model.TileProvider original) {
        super(original);
    }

    @Override
    public com.amazon.geo.mapsv2.model.Tile getTile(int x, int y, int zoom) {
        return Tile.unwrap(original.getTile(x, y, zoom));
    }

}
