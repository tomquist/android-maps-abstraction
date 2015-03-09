package de.quist.app.maps.google;

class Marker implements de.quist.app.maps.model.Marker {

    static com.google.android.gms.maps.model.Marker unwrap(de.quist.app.maps.model.Marker marker) {
        return marker != null ? ((Marker)marker).original : null;
    }

    static de.quist.app.maps.model.Marker wrap(com.google.android.gms.maps.model.Marker marker) {
        return marker != null ? new Marker(marker) : null;
    }

    final com.google.android.gms.maps.model.Marker original;

    private Marker(com.google.android.gms.maps.model.Marker original) {
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
    public void setPosition(de.quist.app.maps.model.LatLng latLng) {
        original.setPosition(LatLng.unwrap(latLng));
    }

    @Override
    public de.quist.app.maps.model.LatLng getPosition() {
        return LatLng.wrap(original.getPosition());
    }

    @Override
    public void setIcon(de.quist.app.maps.model.BitmapDescriptor icon) {
        original.setIcon(BitmapDescriptor.unwrap(icon));
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

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Marker)) {
            return false;
        }

        Marker other = (Marker)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
