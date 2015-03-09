package de.quist.app.mapsabstraction.amazonmapswrapper;

import android.graphics.Point;


class CameraUpdateFactory implements de.quist.app.mapsabstraction.CameraUpdateFactory {

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate zoomIn() {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomIn());
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate zoomOut() {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomOut());
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate scrollBy(float xPixel, float yPixel) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.scrollBy(xPixel, yPixel));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate zoomTo(float zoom) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomTo(zoom));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate zoomBy(float amount) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomBy(amount));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate zoomBy(float amount, Point focus) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomBy(amount, focus));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate newCameraPosition(de.quist.app.mapsabstraction.model.CameraPosition cameraPosition) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newCameraPosition(CameraPosition.unwrap(cameraPosition)));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate newLatLng(de.quist.app.mapsabstraction.model.LatLng latLng) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLng(LatLng.unwrap(latLng)));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate newLatLngZoom(de.quist.app.mapsabstraction.model.LatLng latLng, float zoom) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngZoom(LatLng.unwrap(latLng), zoom));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate newLatLngBounds(de.quist.app.mapsabstraction.model.LatLngBounds bounds, int padding) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngBounds(LatLngBounds.unwrap(bounds), padding));
    }

    @Override
    public de.quist.app.mapsabstraction.CameraUpdate newLatLngBounds(de.quist.app.mapsabstraction.model.LatLngBounds bounds, int width, int height, int padding) {
        return CameraUpdate.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngBounds(LatLngBounds.unwrap(bounds), width, height, padding));
    }
}
