package de.quist.app.maps.google;

import de.quist.app.maps.utils.Wrapper;

class GroundOverlay extends Wrapper<com.google.android.gms.maps.model.GroundOverlay> implements de.quist.app.maps.model.GroundOverlay {

    static final Mapper<de.quist.app.maps.model.GroundOverlay, GroundOverlay, com.google.android.gms.maps.model.GroundOverlay> MAPPER = new DefaultMapper<de.quist.app.maps.model.GroundOverlay, GroundOverlay, com.google.android.gms.maps.model.GroundOverlay>() {

        @Override
        public GroundOverlay createWrapper(com.google.android.gms.maps.model.GroundOverlay original) {
            return original != null ? new GroundOverlay(original) : null;
        }
    };

    private GroundOverlay(com.google.android.gms.maps.model.GroundOverlay original) {
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
    public void setPosition(de.quist.app.maps.model.LatLng latLng) {
        original.setPosition(LatLng.MAPPER.unwrap(latLng));
    }

    @Override
    public de.quist.app.maps.model.LatLng getPosition() {
        return LatLng.MAPPER.wrap(original.getPosition());
    }

    @Override
    public void setImage(de.quist.app.maps.model.BitmapDescriptor image) {
        original.setImage(BitmapDescriptor.MAPPER.unwrap(image));
    }

    @Override
    public void setDimensions(float width) {
        original.setDimensions(width);
    }

    @Override
    public void setDimensions(float width, float height) {
        original.setDimensions(width, height);
    }

    @Override
    public float getWidth() {
        return original.getWidth();
    }

    @Override
    public float getHeight() {
        return original.getHeight();
    }

    @Override
    public void setPositionFromBounds(de.quist.app.maps.model.LatLngBounds bounds) {
        original.setPositionFromBounds(LatLngBounds.MAPPER.unwrap(bounds));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds getBounds() {
        return LatLngBounds.MAPPER.wrap(original.getBounds());
    }

    @Override
    public void setBearing(float bearing) {
        original.setBearing(bearing);
    }

    @Override
    public float getBearing() {
        return original.getBearing();
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
    public void setTransparency(float transparency) {
        original.setTransparency(transparency);
    }

    @Override
    public float getTransparency() {
        return original.getTransparency();
    }

}
