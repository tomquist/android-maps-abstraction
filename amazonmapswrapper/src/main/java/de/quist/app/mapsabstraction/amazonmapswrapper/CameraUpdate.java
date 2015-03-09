package de.quist.app.mapsabstraction.amazonmapswrapper;


class CameraUpdate implements de.quist.app.mapsabstraction.CameraUpdate {

    static com.amazon.geo.mapsv2.CameraUpdate unwrap(de.quist.app.mapsabstraction.CameraUpdate cameraUpdate) {
        return cameraUpdate != null ? ((CameraUpdate)cameraUpdate).original : null;
    }

    static de.quist.app.mapsabstraction.CameraUpdate wrap(com.amazon.geo.mapsv2.CameraUpdate cameraUpdate) {
        return cameraUpdate != null ? new CameraUpdate(cameraUpdate) : null;
    }

    final com.amazon.geo.mapsv2.CameraUpdate original;

    private CameraUpdate(com.amazon.geo.mapsv2.CameraUpdate cameraUpdate) {
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
