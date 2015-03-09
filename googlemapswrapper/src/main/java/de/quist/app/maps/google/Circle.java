package de.quist.app.maps.google;

class Circle implements de.quist.app.maps.model.Circle {

    static com.google.android.gms.maps.model.Circle unwrap(de.quist.app.maps.model.Circle circle) {
        return circle != null ? ((Circle)circle).original : null;
    }

    static de.quist.app.maps.model.Circle wrap(com.google.android.gms.maps.model.Circle circle) {
        return circle != null ? new Circle(circle) : null;
    }

    final com.google.android.gms.maps.model.Circle original;

    private Circle(com.google.android.gms.maps.model.Circle original) {
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
    public void setCenter(de.quist.app.maps.model.LatLng center) {
        original.setCenter(LatLng.unwrap(center));
    }

    @Override
    public de.quist.app.maps.model.LatLng getCenter() {
        return LatLng.wrap(original.getCenter());
    }

    @Override
    public void setRadius(double radius) {
        original.setRadius(radius);
    }

    @Override
    public double getRadius() {
        return original.getRadius();
    }

    @Override
    public void setStrokeWidth(float width) {
        original.setStrokeWidth(width);
    }

    @Override
    public float getStrokeWidth() {
        return original.getStrokeWidth();
    }

    @Override
    public void setStrokeColor(int color) {
        original.setStrokeColor(color);
    }

    @Override
    public int getStrokeColor() {
        return original.getStrokeColor();
    }

    @Override
    public void setFillColor(int color) {
        original.setFillColor(color);
    }

    @Override
    public int getFillColor() {
        return original.getFillColor();
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
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }

        Circle other = (Circle)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }

    @Override
    public void setPosition(de.quist.app.maps.model.LatLng latLng) {
        original.setCenter(LatLng.unwrap(latLng));
    }

    @Override
    public de.quist.app.maps.model.LatLng getPosition() {
        return LatLng.wrap(original.getCenter());
    }
}
