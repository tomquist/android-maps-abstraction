package de.quist.app.maps.google;

class BitmapDescriptor implements de.quist.app.maps.model.BitmapDescriptor {

    static com.google.android.gms.maps.model.BitmapDescriptor unwrap(de.quist.app.maps.model.BitmapDescriptor bitmapDescriptor) {
        return bitmapDescriptor != null ? ((BitmapDescriptor)bitmapDescriptor).original : null;
    }

    static de.quist.app.maps.model.BitmapDescriptor wrap(com.google.android.gms.maps.model.BitmapDescriptor bitmapDescriptor) {
        return bitmapDescriptor != null ? new BitmapDescriptor(bitmapDescriptor) : null;
    }

    final com.google.android.gms.maps.model.BitmapDescriptor original;

    public BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptor original) {
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
