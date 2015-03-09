package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Parcel;
import android.os.Parcelable;

class CameraPosition implements de.quist.app.mapsabstraction.model.CameraPosition {

    static com.google.android.gms.maps.model.CameraPosition unwrap(de.quist.app.mapsabstraction.model.CameraPosition cameraPosition) {
        return cameraPosition != null ? ((CameraPosition)cameraPosition).original : null;
    }

    static de.quist.app.mapsabstraction.model.CameraPosition wrap(com.google.android.gms.maps.model.CameraPosition cameraPosition) {
        return cameraPosition != null ? new CameraPosition(cameraPosition) : null;
    }

    final com.google.android.gms.maps.model.CameraPosition original;

    private CameraPosition(com.google.android.gms.maps.model.CameraPosition original) {
        this.original = original;
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLng target() {
        return LatLng.wrap(original.target);
    }

    @Override
    public float zoom() {
        return original.zoom;
    }

    @Override
    public float tilt() {
        return original.tilt;
    }

    @Override
    public float bearing() {
        return original.bearing;
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CameraPosition)) {
            return false;
        }

        CameraPosition other = (CameraPosition)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }

    @Override
    public int describeContents() {
        return original.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        original.writeToParcel(dest, flags);
    }

    public static final Parcelable.Creator<CameraPosition> CREATOR
            = new Parcelable.Creator<CameraPosition>() {
        public CameraPosition createFromParcel(Parcel in) {
            return new CameraPosition(com.google.android.gms.maps.model.CameraPosition.CREATOR.da(in));
        }

        public CameraPosition[] newArray(int size) {
            return new CameraPosition[size];
        }
    };

    static class Builder implements IBuilder {

        private final com.google.android.gms.maps.model.CameraPosition.Builder builder;

        Builder() {
            this.builder = new com.google.android.gms.maps.model.CameraPosition.Builder();
        }

        Builder(de.quist.app.mapsabstraction.model.CameraPosition cameraPosition) {
            this.builder = new com.google.android.gms.maps.model.CameraPosition.Builder(CameraPosition.unwrap(cameraPosition));
        }

        private Builder(com.google.android.gms.maps.model.CameraPosition.Builder original) {
            builder = original;
        }

        @Override
        public IBuilder target(de.quist.app.mapsabstraction.model.LatLng location) {
            com.google.android.gms.maps.model.CameraPosition.Builder retBuilder = builder.target(LatLng.unwrap(location));
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public IBuilder zoom(float zoom) {
            com.google.android.gms.maps.model.CameraPosition.Builder retBuilder = builder.zoom(zoom);
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public IBuilder tilt(float tilt) {
            com.google.android.gms.maps.model.CameraPosition.Builder retBuilder = builder.tilt(tilt);
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public IBuilder bearing(float bearing) {
            com.google.android.gms.maps.model.CameraPosition.Builder retBuilder = builder.bearing(bearing);
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public de.quist.app.mapsabstraction.model.CameraPosition build() {
            return CameraPosition.wrap(builder.build());
        }
    }

}
