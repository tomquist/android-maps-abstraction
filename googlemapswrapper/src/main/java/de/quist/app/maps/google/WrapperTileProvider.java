package de.quist.app.maps.google;

import de.quist.app.maps.utils.Wrapper;

class WrapperTileProvider extends Wrapper<de.quist.app.maps.model.TileProvider> implements com.google.android.gms.maps.model.TileProvider {

    static final Mapper<com.google.android.gms.maps.model.TileProvider, WrapperTileProvider, de.quist.app.maps.model.TileProvider> MAPPER = new DefaultMapper<com.google.android.gms.maps.model.TileProvider, WrapperTileProvider, de.quist.app.maps.model.TileProvider>() {

        @Override
        public WrapperTileProvider createWrapper(de.quist.app.maps.model.TileProvider original) {
            return original != null ? new WrapperTileProvider(original) : null;
        }
    };

    private WrapperTileProvider(de.quist.app.maps.model.TileProvider original) {
        super(original);
    }

    @Override
    public com.google.android.gms.maps.model.Tile getTile(int x, int y, int zoom) {
        return Tile.unwrap(original.getTile(x, y, zoom));
    }

}
