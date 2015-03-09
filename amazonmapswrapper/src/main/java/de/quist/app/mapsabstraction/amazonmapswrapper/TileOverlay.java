package de.quist.app.mapsabstraction.amazonmapswrapper;

class TileOverlay implements de.quist.app.mapsabstraction.model.TileOverlay {

    static com.amazon.geo.mapsv2.model.TileOverlay unwrap(de.quist.app.mapsabstraction.model.TileOverlay tileOverlay) {
        return tileOverlay != null ? ((TileOverlay)tileOverlay).original : null;
    }

    static de.quist.app.mapsabstraction.model.TileOverlay wrap(com.amazon.geo.mapsv2.model.TileOverlay tileOverlay) {
        return tileOverlay != null ? new TileOverlay(tileOverlay) : null;
    }

    final com.amazon.geo.mapsv2.model.TileOverlay original;

    private TileOverlay(com.amazon.geo.mapsv2.model.TileOverlay original) {
        this.original = original;
    }
    
    @Override
    public void remove() {
        original.remove();
    }

    @Override
    public void clearTileCache() {
        original.clearTileCache();
    }

    @Override
    public String getId() {
        return original.getId();
    }

    @Override
    public void setZIndex(float zIndex) {
        original.setZIndex(zIndex);
    }

    @Override
    public float getZIndex() {
        return original.getZIndex();
    }

    @Override
    public void setVisible(boolean visible) {
        original.setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        return original.isVisible();
    }

    @Override
    public void setFadeIn(boolean fadeIn) {
        original.setFadeIn(fadeIn);
    }

    @Override
    public boolean getFadeIn() {
        return original.getFadeIn();
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TileOverlay)) {
            return false;
        }

        TileOverlay other = (TileOverlay)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
