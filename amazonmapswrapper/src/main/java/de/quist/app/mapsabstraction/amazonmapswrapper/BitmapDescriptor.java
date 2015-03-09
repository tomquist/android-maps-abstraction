package de.quist.app.mapsabstraction.amazonmapswrapper;

class BitmapDescriptor implements de.quist.app.mapsabstraction.model.BitmapDescriptor {

    static com.amazon.geo.mapsv2.model.BitmapDescriptor unwrap(de.quist.app.mapsabstraction.model.BitmapDescriptor bitmapDescriptor) {
        return bitmapDescriptor != null ? ((BitmapDescriptor)bitmapDescriptor).original : null;
    }

    static de.quist.app.mapsabstraction.model.BitmapDescriptor wrap(com.amazon.geo.mapsv2.model.BitmapDescriptor bitmapDescriptor) {
        return bitmapDescriptor != null ? new BitmapDescriptor(bitmapDescriptor) : null;
    }

    final com.amazon.geo.mapsv2.model.BitmapDescriptor original;

    public BitmapDescriptor(com.amazon.geo.mapsv2.model.BitmapDescriptor original) {
        this.original = original;
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BitmapDescriptor)) {
            return false;
        }

        BitmapDescriptor other = (BitmapDescriptor)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }

}
