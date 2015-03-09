package de.quist.app.mapsabstraction.googlemapswrapper;

class GroundOverlay implements de.quist.app.mapsabstraction.model.GroundOverlay {

    static com.google.android.gms.maps.model.GroundOverlay unwrap(de.quist.app.mapsabstraction.model.GroundOverlay groundOverlay) {
        return groundOverlay != null ? ((GroundOverlay)groundOverlay).original : null;
    }

    static de.quist.app.mapsabstraction.model.GroundOverlay wrap(com.google.android.gms.maps.model.GroundOverlay groundOverlay) {
        return groundOverlay != null ? new GroundOverlay(groundOverlay) : null;
    }

    final com.google.android.gms.maps.model.GroundOverlay original;

    private GroundOverlay(com.google.android.gms.maps.model.GroundOverlay original) {
        this.original = original;
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
    public void setPosition(de.quist.app.mapsabstraction.model.LatLng latLng) {
        original.setPosition(LatLng.unwrap(latLng));
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLng getPosition() {
        return LatLng.wrap(original.getPosition());
    }

    @Override
    public void setImage(de.quist.app.mapsabstraction.model.BitmapDescriptor image) {
        original.setImage(BitmapDescriptor.unwrap(image));
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
    public void setPositionFromBounds(de.quist.app.mapsabstraction.model.LatLngBounds bounds) {
        original.setPositionFromBounds(LatLngBounds.unwrap(bounds));
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLngBounds getBounds() {
        return LatLngBounds.wrap(original.getBounds());
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

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GroundOverlay)) {
            return false;
        }

        GroundOverlay other = (GroundOverlay)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
