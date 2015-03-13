package de.quist.app.maps.google;

import android.graphics.Point;

import de.quist.app.maps.utils.Wrapper;

class Projection extends Wrapper<com.google.android.gms.maps.Projection> implements de.quist.app.maps.Projection {

    static final Mapper<de.quist.app.maps.Projection, Projection, com.google.android.gms.maps.Projection> MAPPER = new DefaultMapper<de.quist.app.maps.Projection, Projection, com.google.android.gms.maps.Projection>() {

        @Override
        public Projection createWrapper(com.google.android.gms.maps.Projection original) {
            return original != null ? new Projection(original) : null;
        }
    };

    private Projection(com.google.android.gms.maps.Projection original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.LatLng fromScreenLocation(Point point) {
        return LatLng.MAPPER.wrap(original.fromScreenLocation(point));
    }

    @Override
    public Point toScreenLocation(de.quist.app.maps.model.LatLng location) {
        return original.toScreenLocation(LatLng.MAPPER.unwrap(location));
    }

    @Override
    public de.quist.app.maps.model.VisibleRegion getVisibleRegion() {
        return VisibleRegion.MAPPER.wrap(original.getVisibleRegion());
    }

}
