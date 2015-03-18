package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.maps.utils.MappingIterable;
import de.quist.app.maps.utils.ParcelableWrapper;

class PolygonOptions extends ParcelableWrapper<com.amazon.geo.mapsv2.model.PolygonOptions> implements de.quist.app.maps.model.PolygonOptions {

    private static final MappingIterable.IMapper<de.quist.app.maps.model.LatLng,com.amazon.geo.mapsv2.model.LatLng> POINT_UNWRAPPER = new MappingIterable.IMapper<de.quist.app.maps.model.LatLng, com.amazon.geo.mapsv2.model.LatLng>() {
        @Override
        public com.amazon.geo.mapsv2.model.LatLng map(de.quist.app.maps.model.LatLng item) {
            return LatLng.MAPPER.unwrap(item);
        }
    };

    static final Mapper<de.quist.app.maps.model.PolygonOptions, PolygonOptions, com.amazon.geo.mapsv2.model.PolygonOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.PolygonOptions, PolygonOptions, com.amazon.geo.mapsv2.model.PolygonOptions>() {

        @Override
        public PolygonOptions createWrapper(com.amazon.geo.mapsv2.model.PolygonOptions original) {
            return original != null ? new PolygonOptions(original) : null;
        }
    };

    private PolygonOptions(com.amazon.geo.mapsv2.model.PolygonOptions original) {
        super(original);
    }


    @Override
    public de.quist.app.maps.model.PolygonOptions add(de.quist.app.maps.model.LatLng point) {
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.add(LatLng.MAPPER.unwrap(point));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions add(de.quist.app.maps.model.LatLng... points) {
        com.amazon.geo.mapsv2.model.LatLng[] unwrappedPoints = new com.amazon.geo.mapsv2.model.LatLng[points.length];
        for (int i = 0; i<points.length; i++) {
            unwrappedPoints[i] = LatLng.unwrap(points[i]);
        }
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.add(unwrappedPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions addAll(Iterable<de.quist.app.maps.model.LatLng> points) {
        Iterable<com.amazon.geo.mapsv2.model.LatLng> originalPoints = new MappingIterable<de.quist.app.maps.model.LatLng, com.amazon.geo.mapsv2.model.LatLng>(points, POINT_UNWRAPPER);
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.addAll(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions addHole(Iterable<de.quist.app.maps.model.LatLng> points) {
        Iterable<com.amazon.geo.mapsv2.model.LatLng> originalPoints = new MappingIterable<de.quist.app.maps.model.LatLng, com.amazon.geo.mapsv2.model.LatLng>(points, POINT_UNWRAPPER);
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.addHole(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolygonOptions strokeWidth(float width) {
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.strokeWidth(width);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolygonOptions strokeColor(int color) {
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.strokeColor(color);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolygonOptions fillColor(int color) {
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.fillColor(color);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions zIndex(float zIndex) {
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions geodesic(boolean geodesic) {
        com.amazon.geo.mapsv2.model.PolygonOptions ret = original.geodesic(geodesic);
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
        List<List<com.amazon.geo.mapsv2.model.LatLng>> unwrappedHoles = original.getHoles();
        List<List<de.quist.app.maps.model.LatLng>> wrappedHoles = new ArrayList<>(unwrappedHoles.size());
        for (List<com.amazon.geo.mapsv2.model.LatLng> unwrappedPoints : unwrappedHoles) {
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

    public static final Parcelable.Creator<PolygonOptions> CREATOR
            = new Parcelable.Creator<PolygonOptions>() {
        public PolygonOptions createFromParcel(Parcel in) {
            return PolygonOptions.MAPPER.wrap(com.amazon.geo.mapsv2.model.PolygonOptions.CREATOR.createFromParcel(in));
        }

        public PolygonOptions[] newArray(int size) {
            return new PolygonOptions[size];
        }
    };
}
