package de.quist.app.maps.amazon;

class LatLngBounds implements de.quist.app.maps.model.LatLngBounds {

    static com.amazon.geo.mapsv2.model.LatLngBounds unwrap(de.quist.app.maps.model.LatLngBounds bounds) {
        return bounds != null ? ((LatLngBounds)bounds).original : null;
    }

    static de.quist.app.maps.model.LatLngBounds wrap(com.amazon.geo.mapsv2.model.LatLngBounds bounds) {
        return bounds != null ? new LatLngBounds(bounds) : null;
    }

    final com.amazon.geo.mapsv2.model.LatLngBounds original;

    private LatLngBounds(com.amazon.geo.mapsv2.model.LatLngBounds original) {
        this.original = original;
    }

    static IBuilder builder() {
        return new Builder(com.amazon.geo.mapsv2.model.LatLngBounds.builder());
    }

    @Override
    public de.quist.app.maps.model.LatLng southwest() {
        return LatLng.wrap(original.southwest);
    }

    @Override
    public de.quist.app.maps.model.LatLng northeast() {
        return LatLng.wrap(original.northeast);
    }

    @Override
    public boolean contains(de.quist.app.maps.model.LatLng point) {
        return original.contains(LatLng.unwrap(point));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds including(de.quist.app.maps.model.LatLng point) {
        return new LatLngBounds(original.including(LatLng.unwrap(point)));
    }

    @Override
    public de.quist.app.maps.model.LatLng getCenter() {
        return LatLng.wrap(original.getCenter());
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LatLngBounds)) {
            return false;
        }

        LatLngBounds other = (LatLngBounds)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }

    private static class Builder implements IBuilder {

        private final com.amazon.geo.mapsv2.model.LatLngBounds.Builder original;

        Builder(com.amazon.geo.mapsv2.model.LatLngBounds.Builder builder) {
            original = builder;
        }

        @Override
        public IBuilder include(de.quist.app.maps.model.LatLng point) {
            com.amazon.geo.mapsv2.model.LatLngBounds.Builder ret = original.include(LatLng.unwrap(point));
            if (ret == original) {
                return this;
            } else {
                return new Builder(ret);
            }
        }

        @Override
        public de.quist.app.maps.model.LatLngBounds build() {
            return LatLngBounds.wrap(original.build());
        }
    }

}
