package de.quist.app.maps.google;

import android.graphics.Point;

import de.quist.app.maps.utils.Wrapper;


class CameraUpdateFactory implements de.quist.app.maps.CameraUpdateFactory {

    private static final Wrapper.Mapper<de.quist.app.maps.CameraUpdate, CameraUpdate, com.google.android.gms.maps.CameraUpdate> M = CameraUpdate.MAPPER;

    @Override
    public de.quist.app.maps.CameraUpdate zoomIn() {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.zoomIn());
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomOut() {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.zoomOut());
    }

    @Override
    public de.quist.app.maps.CameraUpdate scrollBy(float xPixel, float yPixel) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.scrollBy(xPixel, yPixel));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomTo(float zoom) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.zoomTo(zoom));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomBy(float amount) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.zoomBy(amount));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomBy(float amount, Point focus) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.zoomBy(amount, focus));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newCameraPosition(de.quist.app.maps.model.CameraPosition cameraPosition) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.newCameraPosition(CameraPosition.MAPPER.unwrap(cameraPosition)));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLng(de.quist.app.maps.model.LatLng latLng) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.newLatLng(LatLng.MAPPER.unwrap(latLng)));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngZoom(de.quist.app.maps.model.LatLng latLng, float zoom) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(LatLng.MAPPER.unwrap(latLng), zoom));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngBounds(de.quist.app.maps.model.LatLngBounds bounds, int padding) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.newLatLngBounds(LatLngBounds.MAPPER.unwrap(bounds), padding));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngBounds(de.quist.app.maps.model.LatLngBounds bounds, int width, int height, int padding) {
        return M.wrap(com.google.android.gms.maps.CameraUpdateFactory.newLatLngBounds(LatLngBounds.MAPPER.unwrap(bounds), width, height, padding));
    }
}
