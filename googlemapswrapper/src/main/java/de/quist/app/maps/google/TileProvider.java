package de.quist.app.maps.google;

class TileProvider implements de.quist.app.maps.model.TileProvider {

    static com.google.android.gms.maps.model.TileProvider unwrap(de.quist.app.maps.model.TileProvider tileProvider) {
        return tileProvider != null ? ((TileProvider)tileProvider).original : null;
    }

    static de.quist.app.maps.model.TileProvider wrap(com.google.android.gms.maps.model.TileProvider tileProvider) {
        return tileProvider != null ? new TileProvider(tileProvider) : null;
    }

    final com.google.android.gms.maps.model.TileProvider original;

    private TileProvider(com.google.android.gms.maps.model.TileProvider original) {
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
