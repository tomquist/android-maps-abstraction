package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.maps.utils.ParcelableWrapper;

class LatLng extends ParcelableWrapper<com.amazon.geo.mapsv2.model.LatLng> implements de.quist.app.maps.model.LatLng {

    static final Mapper<de.quist.app.maps.model.LatLng, LatLng, com.amazon.geo.mapsv2.model.LatLng> MAPPER = new DefaultMapper<de.quist.app.maps.model.LatLng, LatLng, com.amazon.geo.mapsv2.model.LatLng>() {

        @Override
        public LatLng createWrapper(com.amazon.geo.mapsv2.model.LatLng original) {
            return original != null ? new LatLng(original) : null;
        }
    };

    static List<com.amazon.geo.mapsv2.model.LatLng> unwrap(List<de.quist.app.maps.model.LatLng> points) {
        List<com.amazon.geo.mapsv2.model.LatLng> unwrappedPoints = new ArrayList<>(points.size());
        for (de.quist.app.maps.model.LatLng point : points) {
            unwrappedPoints.add(LatLng.MAPPER.unwrap(point));
        }
        return unwrappedPoints;
    }

    static List<de.quist.app.maps.model.LatLng> wrap(List<com.amazon.geo.mapsv2.model.LatLng> points) {
        List<de.quist.app.maps.model.LatLng> wrappedPoints = new ArrayList<>(points.size());
        for (com.amazon.geo.mapsv2.model.LatLng point : points) {
            wrappedPoints.add(LatLng.MAPPER.wrap(point));
        }
        return wrappedPoints;
    }

    private LatLng(com.amazon.geo.mapsv2.model.LatLng original) {
        super(original);
    }

    @Override
    public double latitude() {
        return original.latitude;
    }

    @Override
    public double longitude() {
        return original.longitude;
    }

    public static final Parcelable.Creator<LatLng> CREATOR
            = new Parcelable.Creator<LatLng>() {
        public LatLng createFromParcel(Parcel in) {
            return LatLng.MAPPER.wrap(com.amazon.geo.mapsv2.model.LatLng.CREATOR.createFromParcel(in));
        }

        public LatLng[] newArray(int size) {
            return new LatLng[size];
        }
    };
}
