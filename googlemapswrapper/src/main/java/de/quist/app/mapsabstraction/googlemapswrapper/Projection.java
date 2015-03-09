package de.quist.app.mapsabstraction.googlemapswrapper;

import android.graphics.Point;

class Projection implements de.quist.app.mapsabstraction.Projection {

    static com.google.android.gms.maps.Projection unwrap(de.quist.app.mapsabstraction.Projection projection) {
        return projection != null ? ((Projection)projection).original : null;
    }

    static de.quist.app.mapsabstraction.Projection wrap(com.google.android.gms.maps.Projection projection) {
        return projection != null ? new Projection(projection) : null;
    }

    final com.google.android.gms.maps.Projection original;

    private Projection(com.google.android.gms.maps.Projection original) {
        this.original = original;
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLng fromScreenLocation(Point point) {
        return LatLng.wrap(original.fromScreenLocation(point));
    }

    @Override
    public Point toScreenLocation(de.quist.app.mapsabstraction.model.LatLng location) {
        return original.toScreenLocation(LatLng.unwrap(location));
    }

    @Override
    public de.quist.app.mapsabstraction.model.VisibleRegion getVisibleRegion() {
        return VisibleRegion.wrap(original.getVisibleRegion());
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Projection)) {
            return false;
        }

        Projection other = (Projection)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
