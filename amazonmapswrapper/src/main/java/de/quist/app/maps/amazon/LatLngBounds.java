package de.quist.app.maps.amazon;

import de.quist.app.maps.utils.Wrapper;

class LatLngBounds extends Wrapper<com.amazon.geo.mapsv2.model.LatLngBounds> implements de.quist.app.maps.model.LatLngBounds {

    static final Mapper<de.quist.app.maps.model.LatLngBounds, LatLngBounds, com.amazon.geo.mapsv2.model.LatLngBounds> MAPPER = new DefaultMapper<de.quist.app.maps.model.LatLngBounds, LatLngBounds, com.amazon.geo.mapsv2.model.LatLngBounds>() {

        @Override
        public LatLngBounds createWrapper(com.amazon.geo.mapsv2.model.LatLngBounds original) {
            return original != null ? new LatLngBounds(original) : null;
        }
    };

    private LatLngBounds(com.amazon.geo.mapsv2.model.LatLngBounds original) {
        super(original);
    }

    static IBuilder builder() {
        return new Builder(com.amazon.geo.mapsv2.model.LatLngBounds.builder());
    }

    @Override
    public de.quist.app.maps.model.LatLng southwest() {
        return LatLng.MAPPER.wrap(original.southwest);
    }

    @Override
    public de.quist.app.maps.model.LatLng northeast() {
        return LatLng.MAPPER.wrap(original.northeast);
    }

    @Override
    public boolean contains(de.quist.app.maps.model.LatLng point) {
        return original.contains(LatLng.MAPPER.unwrap(point));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds including(de.quist.app.maps.model.LatLng point) {
        return new LatLngBounds(original.including(LatLng.MAPPER.unwrap(point)));
    }

    @Override
    public de.quist.app.maps.model.LatLng getCenter() {
        return LatLng.MAPPER.wrap(original.getCenter());
    }

    private static class Builder implements IBuilder {

        private final com.amazon.geo.mapsv2.model.LatLngBounds.Builder original;

        Builder(com.amazon.geo.mapsv2.model.LatLngBounds.Builder builder) {
            original = builder;
        }

        @Override
        public IBuilder include(de.quist.app.maps.model.LatLng point) {
            com.amazon.geo.mapsv2.model.LatLngBounds.Builder ret = original.include(LatLng.MAPPER.unwrap(point));
            if (ret == original) {
                return this;
            } else {
                return new Builder(ret);
            }
        }

        @Override
        public de.quist.app.maps.model.LatLngBounds build() {
            return LatLngBounds.MAPPER.wrap(original.build());
        }
    }

}
