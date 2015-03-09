package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

class CameraPosition implements de.quist.app.maps.model.CameraPosition {

    static com.amazon.geo.mapsv2.model.CameraPosition unwrap(de.quist.app.maps.model.CameraPosition cameraPosition) {
        return cameraPosition != null ? ((CameraPosition)cameraPosition).original : null;
    }

    static de.quist.app.maps.model.CameraPosition wrap(com.amazon.geo.mapsv2.model.CameraPosition cameraPosition) {
        return cameraPosition != null ? new CameraPosition(cameraPosition) : null;
    }

    final com.amazon.geo.mapsv2.model.CameraPosition original;

    private CameraPosition(com.amazon.geo.mapsv2.model.CameraPosition original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.LatLng target() {
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
            return new CameraPosition(com.amazon.geo.mapsv2.model.CameraPosition.CREATOR.createFromParcel(in));
        }

        public CameraPosition[] newArray(int size) {
            return new CameraPosition[size];
        }
    };

    static class Builder implements IBuilder {

        private final com.amazon.geo.mapsv2.model.CameraPosition.Builder builder;

        Builder() {
            this.builder = new com.amazon.geo.mapsv2.model.CameraPosition.Builder();
        }

        Builder(de.quist.app.maps.model.CameraPosition cameraPosition) {
            this.builder = new com.amazon.geo.mapsv2.model.CameraPosition.Builder(CameraPosition.unwrap(cameraPosition));
        }

        private Builder(com.amazon.geo.mapsv2.model.CameraPosition.Builder original) {
            builder = original;
        }

        @Override
        public IBuilder target(de.quist.app.maps.model.LatLng location) {
            com.amazon.geo.mapsv2.model.CameraPosition.Builder retBuilder = builder.target(LatLng.unwrap(location));
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public IBuilder zoom(float zoom) {
            com.amazon.geo.mapsv2.model.CameraPosition.Builder retBuilder = builder.zoom(zoom);
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public IBuilder tilt(float tilt) {
            com.amazon.geo.mapsv2.model.CameraPosition.Builder retBuilder = builder.tilt(tilt);
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public IBuilder bearing(float bearing) {
            com.amazon.geo.mapsv2.model.CameraPosition.Builder retBuilder = builder.bearing(bearing);
            if (retBuilder == builder)
            {
                return this;
            }
            return new Builder(retBuilder);
        }

        @Override
        public de.quist.app.maps.model.CameraPosition build() {
            return CameraPosition.wrap(builder.build());
        }
    }

}
