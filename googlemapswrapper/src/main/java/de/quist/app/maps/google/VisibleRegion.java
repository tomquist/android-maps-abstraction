package de.quist.app.maps.google;

import de.quist.app.maps.utils.Wrapper;

class VisibleRegion extends Wrapper<com.google.android.gms.maps.model.VisibleRegion> implements de.quist.app.maps.model.VisibleRegion {

    static final Mapper<de.quist.app.maps.model.VisibleRegion, VisibleRegion, com.google.android.gms.maps.model.VisibleRegion> MAPPER = new DefaultMapper<de.quist.app.maps.model.VisibleRegion, VisibleRegion, com.google.android.gms.maps.model.VisibleRegion>() {

        @Override
        public VisibleRegion createWrapper(com.google.android.gms.maps.model.VisibleRegion original) {
            return original != null ? new VisibleRegion(original) : null;
        }
    };

    private VisibleRegion(com.google.android.gms.maps.model.VisibleRegion original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.LatLng nearLeft() {
        return LatLng.MAPPER.wrap(original.nearLeft);
    }

    @Override
    public de.quist.app.maps.model.LatLng nearRight() {
        return LatLng.MAPPER.wrap(original.nearRight);
    }

    @Override
    public de.quist.app.maps.model.LatLng farLeft() {
        return LatLng.MAPPER.wrap(original.farLeft);
    }

    @Override
    public de.quist.app.maps.model.LatLng farRight() {
        return LatLng.MAPPER.wrap(original.farRight);
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds latLngBounds() {
        return LatLngBounds.MAPPER.wrap(original.latLngBounds);
    }

}
