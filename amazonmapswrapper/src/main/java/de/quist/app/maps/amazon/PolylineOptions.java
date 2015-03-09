package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

class PolylineOptions implements de.quist.app.maps.model.PolylineOptions {

    private static final MappingIterable.IMapper<de.quist.app.maps.model.LatLng,com.amazon.geo.mapsv2.model.LatLng> POINT_UNWRAPPER = new MappingIterable.IMapper<de.quist.app.maps.model.LatLng, com.amazon.geo.mapsv2.model.LatLng>() {
        @Override
        public com.amazon.geo.mapsv2.model.LatLng map(de.quist.app.maps.model.LatLng item) {
            return LatLng.unwrap(item);
        }
    };

    static com.amazon.geo.mapsv2.model.PolylineOptions unwrap(de.quist.app.maps.model.PolylineOptions polylineOptions) {
        return polylineOptions != null ? ((PolylineOptions)polylineOptions).original : null;
    }

    static PolylineOptions wrap(com.amazon.geo.mapsv2.model.PolylineOptions polylineOptions) {
        return polylineOptions != null ? new PolylineOptions(polylineOptions) : null;
    }

    final com.amazon.geo.mapsv2.model.PolylineOptions original;

    private PolylineOptions(com.amazon.geo.mapsv2.model.PolylineOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions add(de.quist.app.maps.model.LatLng point) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.add(LatLng.unwrap(point));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions add(de.quist.app.maps.model.LatLng... points) {
        com.amazon.geo.mapsv2.model.LatLng[] unwrappedPoints = new com.amazon.geo.mapsv2.model.LatLng[points.length];
        for (int i = 0; i<points.length; i++) {
            unwrappedPoints[i] = LatLng.unwrap(points[i]);
        }
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.add(unwrappedPoints);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions addAll(Iterable<de.quist.app.maps.model.LatLng> points) {
        Iterable<com.amazon.geo.mapsv2.model.LatLng> originalPoints = new MappingIterable<de.quist.app.maps.model.LatLng, com.amazon.geo.mapsv2.model.LatLng>(points, POINT_UNWRAPPER);
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.addAll(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions width(float width) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.width(width);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolylineOptions color(int color) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.color(color);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolylineOptions zIndex(float zIndex) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions geodesic(boolean geodesic) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.geodesic(geodesic);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public List<de.quist.app.maps.model.LatLng> getPoints() {
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
            return PolylineOptions.wrap(com.amazon.geo.mapsv2.model.PolylineOptions.CREATOR.createFromParcel(in));
        }

        public PolylineOptions[] newArray(int size) {
            return new PolylineOptions[size];
        }
    };
}
