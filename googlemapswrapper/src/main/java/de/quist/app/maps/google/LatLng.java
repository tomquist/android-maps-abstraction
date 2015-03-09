package de.quist.app.maps.google;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

class LatLng implements de.quist.app.maps.model.LatLng {

    static com.google.android.gms.maps.model.LatLng unwrap(de.quist.app.maps.model.LatLng latLng) {
        return latLng != null ? ((LatLng)latLng).original : null;
    }

    static LatLng wrap(com.google.android.gms.maps.model.LatLng latLng) {
        return latLng != null ? new LatLng(latLng) : null;
    }

    static List<com.google.android.gms.maps.model.LatLng> unwrap(List<de.quist.app.maps.model.LatLng> points) {
        List<com.google.android.gms.maps.model.LatLng> unwrappedPoints = new ArrayList<>(points.size());
        for (de.quist.app.maps.model.LatLng point : points) {
            unwrappedPoints.add(LatLng.unwrap(point));
        }
        return unwrappedPoints;
    }

    static List<de.quist.app.maps.model.LatLng> wrap(List<com.google.android.gms.maps.model.LatLng> points) {
        List<de.quist.app.maps.model.LatLng> wrappedPoints = new ArrayList<>(points.size());
        for (com.google.android.gms.maps.model.LatLng point : points) {
            wrappedPoints.add(LatLng.wrap(point));
        }
        return wrappedPoints;
    }

    final com.google.android.gms.maps.model.LatLng original;

    private LatLng(com.google.android.gms.maps.model.LatLng original) {
        this.original = original;
    }

    @Override
    public double latitude() {
        return original.latitude;
    }

    @Override
    public double longitude() {
        return original.longitude;
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public String toString() {
        return original.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LatLng)) {
            return false;
        }

        LatLng other = (LatLng)o;
        return original.equals(other.original);
    }

    @Override
    public int describeContents() {
        return original.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        original.writeToParcel(dest, flags);
    }

    public static final Parcelable.Creator<LatLng> CREATOR
            = new Parcelable.Creator<LatLng>() {
        public LatLng createFromParcel(Parcel in) {
            return LatLng.wrap(com.google.android.gms.maps.model.LatLng.CREATOR.de(in));
        }

        public LatLng[] newArray(int size) {
            return new LatLng[size];
        }
    };
}
