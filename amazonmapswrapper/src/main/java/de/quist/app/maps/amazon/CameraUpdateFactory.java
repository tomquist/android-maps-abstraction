package de.quist.app.maps.amazon;

import android.graphics.Point;

import de.quist.app.maps.utils.Wrapper;


class CameraUpdateFactory implements de.quist.app.maps.CameraUpdateFactory {

    private static final Wrapper.Mapper<de.quist.app.maps.CameraUpdate, CameraUpdate, com.amazon.geo.mapsv2.CameraUpdate> M = CameraUpdate.MAPPER;

    @Override
    public de.quist.app.maps.CameraUpdate zoomIn() {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomIn());
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomOut() {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomOut());
    }

    @Override
    public de.quist.app.maps.CameraUpdate scrollBy(float xPixel, float yPixel) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.scrollBy(xPixel, yPixel));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomTo(float zoom) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomTo(zoom));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomBy(float amount) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomBy(amount));
    }

    @Override
    public de.quist.app.maps.CameraUpdate zoomBy(float amount, Point focus) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.zoomBy(amount, focus));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newCameraPosition(de.quist.app.maps.model.CameraPosition cameraPosition) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newCameraPosition(CameraPosition.MAPPER.unwrap(cameraPosition)));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLng(de.quist.app.maps.model.LatLng latLng) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLng(LatLng.MAPPER.unwrap(latLng)));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngZoom(de.quist.app.maps.model.LatLng latLng, float zoom) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngZoom(LatLng.MAPPER.unwrap(latLng), zoom));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngBounds(de.quist.app.maps.model.LatLngBounds bounds, int padding) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngBounds(LatLngBounds.MAPPER.unwrap(bounds), padding));
    }

    @Override
    public de.quist.app.maps.CameraUpdate newLatLngBounds(de.quist.app.maps.model.LatLngBounds bounds, int width, int height, int padding) {
        return M.wrap(com.amazon.geo.mapsv2.CameraUpdateFactory.newLatLngBounds(LatLngBounds.MAPPER.unwrap(bounds), width, height, padding));
    }
}
