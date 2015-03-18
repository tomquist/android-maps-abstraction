package de.quist.app.maps.google;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.maps.utils.ParcelableWrapper;

class LatLng extends ParcelableWrapper<com.google.android.gms.maps.model.LatLng> implements de.quist.app.maps.model.LatLng {

    static final Mapper<de.quist.app.maps.model.LatLng, LatLng, com.google.android.gms.maps.model.LatLng> MAPPER = new DefaultMapper<de.quist.app.maps.model.LatLng, LatLng, com.google.android.gms.maps.model.LatLng>() {

        @Override
        public LatLng createWrapper(com.google.android.gms.maps.model.LatLng original) {
            return original != null ? new LatLng(original) : null;
        }
    };

    static List<com.google.android.gms.maps.model.LatLng> unwrap(List<de.quist.app.maps.model.LatLng> points) {
        List<com.google.android.gms.maps.model.LatLng> unwrappedPoints = new ArrayList<>(points.size());
        for (de.quist.app.maps.model.LatLng point : points) {
            unwrappedPoints.add(LatLng.MAPPER.unwrap(point));
        }
        return unwrappedPoints;
    }

    static List<de.quist.app.maps.model.LatLng> wrap(List<com.google.android.gms.maps.model.LatLng> points) {
        List<de.quist.app.maps.model.LatLng> wrappedPoints = new ArrayList<>(points.size());
        for (com.google.android.gms.maps.model.LatLng point : points) {
            wrappedPoints.add(LatLng.MAPPER.wrap(point));
        }
        return wrappedPoints;
    }

    private LatLng(com.google.android.gms.maps.model.LatLng original) {
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

    public static final Creator<LatLng> CREATOR
            = new Creator<LatLng>() {
        public LatLng createFromParcel(Parcel in) {
            return LatLng.MAPPER.wrap(com.google.android.gms.maps.model.LatLng.CREATOR.de(in));
        }

        public LatLng[] newArray(int size) {
            return new LatLng[size];
        }
    };
}
