package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

class PolygonOptions implements de.quist.app.mapsabstraction.model.PolygonOptions {

    private static final MappingIterable.IMapper<de.quist.app.mapsabstraction.model.LatLng,com.google.android.gms.maps.model.LatLng> POINT_UNWRAPPER = new MappingIterable.IMapper<de.quist.app.mapsabstraction.model.LatLng, com.google.android.gms.maps.model.LatLng>() {
        @Override
        public com.google.android.gms.maps.model.LatLng map(de.quist.app.mapsabstraction.model.LatLng item) {
            return LatLng.unwrap(item);
        }
    };

    static com.google.android.gms.maps.model.PolygonOptions unwrap(de.quist.app.mapsabstraction.model.PolygonOptions polygonOptions) {
        return polygonOptions != null ? ((PolygonOptions)polygonOptions).original : null;
    }

    static PolygonOptions wrap(com.google.android.gms.maps.model.PolygonOptions polygonOptions) {
        return polygonOptions != null ? new PolygonOptions(polygonOptions) : null;
    }

    final com.google.android.gms.maps.model.PolygonOptions original;

    private PolygonOptions(com.google.android.gms.maps.model.PolygonOptions original) {
        this.original = original;
    }


    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions add(de.quist.app.mapsabstraction.model.LatLng point) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.add(LatLng.unwrap(point));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions add(de.quist.app.mapsabstraction.model.LatLng... points) {
        com.google.android.gms.maps.model.LatLng[] unwrappedPoints = new com.google.android.gms.maps.model.LatLng[points.length];
        for (int i = 0; i<points.length; i++) {
            unwrappedPoints[i] = LatLng.unwrap(points[i]);
        }
        com.google.android.gms.maps.model.PolygonOptions ret = original.add(unwrappedPoints);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions addAll(Iterable<de.quist.app.mapsabstraction.model.LatLng> points) {
        Iterable<com.google.android.gms.maps.model.LatLng> originalPoints = new MappingIterable<de.quist.app.mapsabstraction.model.LatLng, com.google.android.gms.maps.model.LatLng>(points, POINT_UNWRAPPER);
        com.google.android.gms.maps.model.PolygonOptions ret = original.addAll(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions addHole(Iterable<de.quist.app.mapsabstraction.model.LatLng> points) {
        Iterable<com.google.android.gms.maps.model.LatLng> originalPoints = new MappingIterable<de.quist.app.mapsabstraction.model.LatLng, com.google.android.gms.maps.model.LatLng>(points, POINT_UNWRAPPER);
        com.google.android.gms.maps.model.PolygonOptions ret = original.addHole(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }

    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions strokeWidth(float width) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.strokeWidth(width);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }

    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions strokeColor(int color) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.strokeColor(color);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }

    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions fillColor(int color) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.fillColor(color);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions visible(boolean visible) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions geodesic(boolean geodesic) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.geodesic(geodesic);
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
    public List<List<de.quist.app.mapsabstraction.model.LatLng>> getHoles() {
        List<List<com.google.android.gms.maps.model.LatLng>> unwrappedHoles = original.getHoles();
        List<List<de.quist.app.mapsabstraction.model.LatLng>> wrappedHoles = new ArrayList<>(unwrappedHoles.size());
        for (List<com.google.android.gms.maps.model.LatLng> unwrappedPoints : unwrappedHoles) {
            wrappedHoles.add(LatLng.wrap(unwrappedPoints));
        }
        return wrappedHoles;
    }

    @Override
    public float getStrokeWidth() {
        return original.getStrokeWidth();
    }

    @Override
    public int getStrokeColor() {
        return original.getStrokeColor();
    }

    @Override
    public int getFillColor() {
        return original.getFillColor();
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
        if (!(o instanceof Polygon)) {
            return false;
        }

        Polygon other = (Polygon)o;
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

    public static final Parcelable.Creator<PolygonOptions> CREATOR
            = new Parcelable.Creator<PolygonOptions>() {
        public PolygonOptions createFromParcel(Parcel in) {
            return PolygonOptions.wrap(com.google.android.gms.maps.model.PolygonOptions.CREATOR.dg(in));
        }

        public PolygonOptions[] newArray(int size) {
            return new PolygonOptions[size];
        }
    };
}
