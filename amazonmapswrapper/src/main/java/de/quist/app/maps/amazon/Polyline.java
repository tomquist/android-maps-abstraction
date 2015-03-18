package de.quist.app.maps.amazon;

import java.util.List;

import de.quist.app.maps.utils.Wrapper;

class Polyline extends Wrapper<com.amazon.geo.mapsv2.model.Polyline> implements de.quist.app.maps.model.Polyline {

    static final Mapper<de.quist.app.maps.model.Polyline, Polyline, com.amazon.geo.mapsv2.model.Polyline> MAPPER = new DefaultMapper<de.quist.app.maps.model.Polyline, Polyline, com.amazon.geo.mapsv2.model.Polyline>() {

        @Override
        public Polyline createWrapper(com.amazon.geo.mapsv2.model.Polyline original) {
            return original != null ? new Polyline(original) : null;
        }
    };

    private Polyline(com.amazon.geo.mapsv2.model.Polyline original) {
        super(original);
    }
    
    @Override
    public void remove() {
        original.remove();
    }

    @Override
    public String getId() {
        return original.getId();
    }

    @Override
    public void setPoints(List<de.quist.app.maps.model.LatLng> points) {
        original.setPoints(LatLng.unwrap(points));
    }

    @Override
    public List<de.quist.app.maps.model.LatLng> getPoints() {
        return LatLng.wrap(original.getPoints());
    }

    @Override
    public void setWidth(float width) {
        original.setWidth(width);
    }

    @Override
    public float getWidth() {
        return original.getWidth();
    }

    @Override
    public void setColor(int color) {
        original.setColor(color);
    }

    @Override
    public int getColor() {
        return original.getColor();
    }

    @Override
    public void setStrokeWidth(float width) {
        original.setWidth(width);
    }

    @Override
    public float getStrokeWidth() {
        return original.getWidth();
    }

    @Override
    public void setStrokeColor(int color) {
        original.setColor(color);
    }

    @Override
    public int getStrokeColor() {
        return original.getColor();
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
    public void setGeodesic(boolean geodesic) {
        original.setGeodesic(geodesic);
    }

    @Override
    public boolean isGeodesic() {
        return original.isGeodesic();
    }

}
