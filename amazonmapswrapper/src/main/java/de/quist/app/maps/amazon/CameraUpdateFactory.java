package de.quist.app.maps.amazon;

import android.graphics.Point;


class CameraUpdateFactory implements de.quist.app.maps.CameraUpdateFactory {

    @Override
    public de.quist.app.maps.CameraUpdate zoomIn() {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomIn());
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomOut() {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomOut());
    }

    @Override
    public de.quist.app.maps.CameraUpdate scrollBy(float xPixel, float yPixel) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.scrollBy(xPixel, yPixel));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomTo(float zoom) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomTo(zoom));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomBy(float amount) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomBy(amount));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomBy(float amount, Point focus) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomBy(amount, focus));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newCameraPosition(de.quist.app.maps.model.CameraPosition cameraPosition) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newCameraPosition(CameraPosition.unwrap(cameraPosition)));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLng(de.quist.app.maps.model.LatLng latLng) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLng(LatLng.unwrap(latLng)));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngZoom(de.quist.app.maps.model.LatLng latLng, float zoom) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngZoom(LatLng.unwrap(latLng), zoom));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngBounds(de.quist.app.maps.model.LatLngBounds bounds, int padding) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngBounds(LatLngBounds.unwrap(bounds), padding));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngBounds(de.quist.app.maps.model.LatLngBounds bounds, int width, int height, int padding) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngBounds(LatLngBounds.unwrap(bounds), width, height, padding));
    }
}
