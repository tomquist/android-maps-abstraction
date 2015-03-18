package de.quist.app.maps.google;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.maps.utils.MappingIterable;
import de.quist.app.maps.utils.ParcelableWrapper;

class PolygonOptions extends ParcelableWrapper<com.google.android.gms.maps.model.PolygonOptions> implements de.quist.app.maps.model.PolygonOptions {

    private static final MappingIterable.IMapper<de.quist.app.maps.model.LatLng,com.google.android.gms.maps.model.LatLng> POINT_UNWRAPPER = new MappingIterable.IMapper<de.quist.app.maps.model.LatLng, com.google.android.gms.maps.model.LatLng>() {
        @Override
        public com.google.android.gms.maps.model.LatLng map(de.quist.app.maps.model.LatLng item) {
            return LatLng.MAPPER.unwrap(item);
        }
    };

    static final Mapper<de.quist.app.maps.model.PolygonOptions, PolygonOptions, com.google.android.gms.maps.model.PolygonOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.PolygonOptions, PolygonOptions, com.google.android.gms.maps.model.PolygonOptions>() {

        @Override
        public PolygonOptions createWrapper(com.google.android.gms.maps.model.PolygonOptions original) {
            return original != null ? new PolygonOptions(original) : null;
        }
    };

    private PolygonOptions(com.google.android.gms.maps.model.PolygonOptions original) {
        super(original);
    }


    @Override
    public de.quist.app.maps.model.PolygonOptions add(de.quist.app.maps.model.LatLng point) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.add(LatLng.MAPPER.unwrap(point));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions add(de.quist.app.maps.model.LatLng... points) {
        com.google.android.gms.maps.model.LatLng[] unwrappedPoints = new com.google.android.gms.maps.model.LatLng[points.length];
        for (int i = 0; i<points.length; i++) {
            unwrappedPoints[i] = LatLng.unwrap(points[i]);
        }
        com.google.android.gms.maps.model.PolygonOptions ret = original.add(unwrappedPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions addAll(Iterable<de.quist.app.maps.model.LatLng> points) {
        Iterable<com.google.android.gms.maps.model.LatLng> originalPoints = new MappingIterable<de.quist.app.maps.model.LatLng, com.google.android.gms.maps.model.LatLng>(points, POINT_UNWRAPPER);
        com.google.android.gms.maps.model.PolygonOptions ret = original.addAll(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions addHole(Iterable<de.quist.app.maps.model.LatLng> points) {
        Iterable<com.google.android.gms.maps.model.LatLng> originalPoints = new MappingIterable<de.quist.app.maps.model.LatLng, com.google.android.gms.maps.model.LatLng>(points, POINT_UNWRAPPER);
        com.google.android.gms.maps.model.PolygonOptions ret = original.addHole(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolygonOptions strokeWidth(float width) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.strokeWidth(width);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolygonOptions strokeColor(int color) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.strokeColor(color);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolygonOptions fillColor(int color) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.fillColor(color);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions visible(boolean visible) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions geodesic(boolean geodesic) {
        com.google.android.gms.maps.model.PolygonOptions ret = original.geodesic(geodesic);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public List<de.quist.app.maps.model.LatLng> getPoints() {
        return LatLng.wrap(original.getPoints());
    }

    @Override
    public List<List<de.quist.app.maps.model.LatLng>> getHoles() {
        List<List<com.google.android.gms.maps.model.LatLng>> unwrappedHoles = original.getHoles();
        List<List<de.quist.app.maps.model.LatLng>> wrappedHoles = new ArrayList<>(unwrappedHoles.size());
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

    public static final Creator<PolygonOptions> CREATOR
            = new Creator<PolygonOptions>() {
        public PolygonOptions createFromParcel(Parcel in) {
            return PolygonOptions.MAPPER.wrap(com.google.android.gms.maps.model.PolygonOptions.CREATOR.dg(in));
        }

        public PolygonOptions[] newArray(int size) {
            return new PolygonOptions[size];
        }
    };
}
