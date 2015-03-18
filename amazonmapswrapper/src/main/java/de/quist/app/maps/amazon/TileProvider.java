package de.quist.app.maps.amazon;

import de.quist.app.maps.utils.Wrapper;

class TileProvider extends Wrapper<com.amazon.geo.mapsv2.model.TileProvider> implements de.quist.app.maps.model.TileProvider {

    static final Mapper<de.quist.app.maps.model.TileProvider, TileProvider, com.amazon.geo.mapsv2.model.TileProvider> MAPPER = new DefaultMapper<de.quist.app.maps.model.TileProvider, TileProvider, com.amazon.geo.mapsv2.model.TileProvider>() {

        @Override
        public TileProvider createWrapper(com.amazon.geo.mapsv2.model.TileProvider original) {
            return original != null ? new TileProvider(original) : null;
        }
    };

    private TileProvider(com.amazon.geo.mapsv2.model.TileProvider original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.Tile getTile(int x, int y, int zoom) {
        return Tile.MAPPER.wrap(original.getTile(x, y, zoom));
    }

}
