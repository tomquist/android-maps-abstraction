package de.quist.app.maps.amazon;

import de.quist.app.maps.utils.Wrapper;

class VisibleRegion extends Wrapper<com.amazon.geo.mapsv2.model.VisibleRegion> implements de.quist.app.maps.model.VisibleRegion {

    static final Mapper<de.quist.app.maps.model.VisibleRegion, VisibleRegion, com.amazon.geo.mapsv2.model.VisibleRegion> MAPPER = new DefaultMapper<de.quist.app.maps.model.VisibleRegion, VisibleRegion, com.amazon.geo.mapsv2.model.VisibleRegion>() {

        @Override
        public VisibleRegion createWrapper(com.amazon.geo.mapsv2.model.VisibleRegion original) {
            return original != null ? new VisibleRegion(original) : null;
        }
    };

    private VisibleRegion(com.amazon.geo.mapsv2.model.VisibleRegion original) {
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
