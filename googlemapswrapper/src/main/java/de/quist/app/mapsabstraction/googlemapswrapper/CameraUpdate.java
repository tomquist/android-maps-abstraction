package de.quist.app.mapsabstraction.googlemapswrapper;


class CameraUpdate implements de.quist.app.mapsabstraction.CameraUpdate {

    static com.google.android.gms.maps.CameraUpdate unwrap(de.quist.app.mapsabstraction.CameraUpdate cameraUpdate) {
        return cameraUpdate != null ? ((CameraUpdate)cameraUpdate).original : null;
    }

    static de.quist.app.mapsabstraction.CameraUpdate wrap(com.google.android.gms.maps.CameraUpdate cameraUpdate) {
        return cameraUpdate != null ? new CameraUpdate(cameraUpdate) : null;
    }

    final com.google.android.gms.maps.CameraUpdate original;

    private CameraUpdate(com.google.android.gms.maps.CameraUpdate cameraUpdate) {
        this.original = cameraUpdate;
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CameraUpdate)) {
            return false;
        }

        CameraUpdate other = (CameraUpdate)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
