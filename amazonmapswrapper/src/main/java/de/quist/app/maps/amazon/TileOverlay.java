package de.quist.app.maps.amazon;

import de.quist.app.maps.utils.Wrapper;

class TileOverlay extends Wrapper<com.amazon.geo.mapsv2.model.TileOverlay> implements de.quist.app.maps.model.TileOverlay {

    static final Mapper<de.quist.app.maps.model.TileOverlay, TileOverlay, com.amazon.geo.mapsv2.model.TileOverlay> MAPPER = new DefaultMapper<de.quist.app.maps.model.TileOverlay, TileOverlay, com.amazon.geo.mapsv2.model.TileOverlay>() {

        @Override
        public TileOverlay createWrapper(com.amazon.geo.mapsv2.model.TileOverlay original) {
            return original != null ? new TileOverlay(original) : null;
        }
    };

    private TileOverlay(com.amazon.geo.mapsv2.model.TileOverlay original) {
        super(original);
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

}
