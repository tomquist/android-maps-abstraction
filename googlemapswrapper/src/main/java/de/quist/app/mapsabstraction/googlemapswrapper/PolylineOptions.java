package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

class PolylineOptions implements de.quist.app.mapsabstraction.model.PolylineOptions {

    private static final MappingIterable.IMapper<de.quist.app.mapsabstraction.model.LatLng,com.google.android.gms.maps.model.LatLng> POINT_UNWRAPPER = new MappingIterable.IMapper<de.quist.app.mapsabstraction.model.LatLng, com.google.android.gms.maps.model.LatLng>() {
        @Override
        public com.google.android.gms.maps.model.LatLng map(de.quist.app.mapsabstraction.model.LatLng item) {
            return LatLng.unwrap(item);
        }
    };

    static com.google.android.gms.maps.model.PolylineOptions unwrap(de.quist.app.mapsabstraction.model.PolylineOptions polylineOptions) {
        return polylineOptions != null ? ((PolylineOptions)polylineOptions).original : null;
    }

    static PolylineOptions wrap(com.google.android.gms.maps.model.PolylineOptions polylineOptions) {
        return polylineOptions != null ? new PolylineOptions(polylineOptions) : null;
    }

    final com.google.android.gms.maps.model.PolylineOptions original;

    private PolylineOptions(com.google.android.gms.maps.model.PolylineOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions add(de.quist.app.mapsabstraction.model.LatLng point) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.add(LatLng.unwrap(point));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions add(de.quist.app.mapsabstraction.model.LatLng... points) {
        com.google.android.gms.maps.model.LatLng[] unwrappedPoints = new com.google.android.gms.maps.model.LatLng[points.length];
        for (int i = 0; i<points.length; i++) {
            unwrappedPoints[i] = LatLng.unwrap(points[i]);
        }
        com.google.android.gms.maps.model.PolylineOptions ret = original.add(unwrappedPoints);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions addAll(Iterable<de.quist.app.mapsabstraction.model.LatLng> points) {
        Iterable<com.google.android.gms.maps.model.LatLng> originalPoints = new MappingIterable<de.quist.app.mapsabstraction.model.LatLng, com.google.android.gms.maps.model.LatLng>(points, POINT_UNWRAPPER);
        com.google.android.gms.maps.model.PolylineOptions ret = original.addAll(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions width(float width) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.width(width);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }

    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions color(int color) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.color(color);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }

    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions visible(boolean visible) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions geodesic(boolean geodesic) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.geodesic(geodesic);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public List<de.quist.app.mapsabstraction.model.LatLng> getPoints() {
        return LatLng.wrap(original.getPoints());
    }

    @Override
    public float getWidth() {
        return original.getWidth();
    }

    @Override
    public int getColor() {
        return original.getColor();
    }

    @Override
    public float getZIndex() {
        return original.getZIndex();
    }

    @Override
    public boolean isVisible() {
        return original.isVisible();
    }

    @Override
    public boolean isGeodesic() {
        return original.isGeodesic();
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PolylineOptions)) {
            return false;
        }

        PolylineOptions other = (PolylineOptions)o;
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

    public static final Parcelable.Creator<PolylineOptions> CREATOR
            = new Parcelable.Creator<PolylineOptions>() {
        public PolylineOptions createFromParcel(Parcel in) {
            return PolylineOptions.wrap(com.google.android.gms.maps.model.PolylineOptions.CREATOR.dh(in));
        }

        public PolylineOptions[] newArray(int size) {
            return new PolylineOptions[size];
        }
    };
}
