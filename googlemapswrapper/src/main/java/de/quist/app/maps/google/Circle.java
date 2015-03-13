package de.quist.app.maps.google;

import de.quist.app.maps.utils.Wrapper;

class Circle extends Wrapper<com.google.android.gms.maps.model.Circle> implements de.quist.app.maps.model.Circle {

    static final Mapper<de.quist.app.maps.model.Circle, Circle, com.google.android.gms.maps.model.Circle> MAPPER = new DefaultMapper<de.quist.app.maps.model.Circle, Circle, com.google.android.gms.maps.model.Circle>() {

        @Override
        public Circle createWrapper(com.google.android.gms.maps.model.Circle original) {
            return original != null ? new Circle(original) : null;
        }
    };

    private Circle(com.google.android.gms.maps.model.Circle original) {
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
    public void setCenter(de.quist.app.maps.model.LatLng center) {
        original.setCenter(LatLng.MAPPER.unwrap(center));
    }

    @Override
    public de.quist.app.maps.model.LatLng getCenter() {
        return LatLng.MAPPER.wrap(original.getCenter());
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
    public void setPosition(de.quist.app.maps.model.LatLng latLng) {
        original.setCenter(LatLng.MAPPER.unwrap(latLng));
    }

    @Override
    public de.quist.app.maps.model.LatLng getPosition() {
        return LatLng.MAPPER.wrap(original.getCenter());
    }
}
