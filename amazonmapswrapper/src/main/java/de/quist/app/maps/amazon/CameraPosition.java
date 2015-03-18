package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import de.quist.app.maps.utils.ParcelableWrapper;

class CameraPosition extends ParcelableWrapper<com.amazon.geo.mapsv2.model.CameraPosition> implements de.quist.app.maps.model.CameraPosition {

    static final Mapper<de.quist.app.maps.model.CameraPosition, CameraPosition, com.amazon.geo.mapsv2.model.CameraPosition> MAPPER = new DefaultMapper<de.quist.app.maps.model.CameraPosition, CameraPosition, com.amazon.geo.mapsv2.model.CameraPosition>() {

        @Override
        public CameraPosition createWrapper(com.amazon.geo.mapsv2.model.CameraPosition original) {
            return original != null ? new CameraPosition(original) : null;
        }
    };
    private CameraPosition(com.amazon.geo.mapsv2.model.CameraPosition original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.LatLng target() {
        return LatLng.MAPPER.wrap(original.target);
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
            this.builder = new com.amazon.geo.mapsv2.model.CameraPosition.Builder(CameraPosition.MAPPER.unwrap(cameraPosition));
        }

        private Builder(com.amazon.geo.mapsv2.model.CameraPosition.Builder original) {
            builder = original;
        }

        @Override
        public IBuilder target(de.quist.app.maps.model.LatLng location) {
            com.amazon.geo.mapsv2.model.CameraPosition.Builder retBuilder = builder.target(LatLng.MAPPER.unwrap(location));
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
            return CameraPosition.MAPPER.wrap(builder.build());
        }
    }

}
