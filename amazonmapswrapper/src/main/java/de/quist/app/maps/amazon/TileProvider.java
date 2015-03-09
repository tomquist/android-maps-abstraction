package de.quist.app.maps.amazon;

class TileProvider implements de.quist.app.maps.model.TileProvider {

    static com.amazon.geo.mapsv2.model.TileProvider unwrap(de.quist.app.maps.model.TileProvider tileProvider) {
        return tileProvider != null ? ((TileProvider)tileProvider).original : null;
    }

    static de.quist.app.maps.model.TileProvider wrap(com.amazon.geo.mapsv2.model.TileProvider tileProvider) {
        return tileProvider != null ? new TileProvider(tileProvider) : null;
    }

    final com.amazon.geo.mapsv2.model.TileProvider original;

    private TileProvider(com.amazon.geo.mapsv2.model.TileProvider original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.Tile getTile(int x, int y, int zoom) {
        return Tile.wrap(original.getTile(x, y, zoom));
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TileProvider)) {
            return false;
        }

        TileProvider other = (TileProvider)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }

}
