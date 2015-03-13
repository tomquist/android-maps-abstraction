package de.quist.app.maps.amazon;

import de.quist.app.maps.utils.Wrapper;

class Marker extends Wrapper<com.amazon.geo.mapsv2.model.Marker> implements de.quist.app.maps.model.Marker {

    static final Mapper<de.quist.app.maps.model.Marker, Marker, com.amazon.geo.mapsv2.model.Marker> MAPPER = new DefaultMapper<de.quist.app.maps.model.Marker, Marker, com.amazon.geo.mapsv2.model.Marker>() {

        @Override
        public Marker createWrapper(com.amazon.geo.mapsv2.model.Marker original) {
            return original != null ? new Marker(original) : null;
        }
    };

    private Marker(com.amazon.geo.mapsv2.model.Marker original) {
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
    public void setIcon(de.quist.app.maps.model.BitmapDescriptor icon) {
        original.setIcon(BitmapDescriptor.MAPPER.unwrap(icon));
    }

    @Override
    public void setAnchor(float anchorU, float anchorV) {
        original.setAnchor(anchorU, anchorV);
    }

    @Override
    public void setInfoWindowAnchor(float anchorU, float anchorV) {
        original.setInfoWindowAnchor(anchorU, anchorV);
    }

    @Override
    public void setTitle(String title) {
        original.setTitle(title);
    }

    @Override
    public String getTitle() {
        return original.getTitle();
    }

    @Override
    public void setSnippet(String snippet) {
        original.setSnippet(snippet);
    }

    @Override
    public String getSnippet() {
        return original.getSnippet();
    }

    @Override
    public void setDraggable(boolean draggable) {
        original.setDraggable(draggable);
    }

    @Override
    public boolean isDraggable() {
        return original.isDraggable();
    }

    @Override
    public void showInfoWindow() {
        original.showInfoWindow();
    }

    @Override
    public void hideInfoWindow() {
        original.hideInfoWindow();
    }

    @Override
    public boolean isInfoWindowShown() {
        return original.isInfoWindowShown();
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
    public void setFlat(boolean flat) {
        original.setFlat(flat);
    }

    @Override
    public boolean isFlat() {
        return original.isFlat();
    }

    @Override
    public void setRotation(float rotation) {
        original.setRotation(rotation);
    }

    @Override
    public float getRotation() {
        return original.getRotation();
    }

    @Override
    public void setAlpha(float alpha) {
        original.setAlpha(alpha);
    }

    @Override
    public float getAlpha() {
        return original.getAlpha();
    }

}
