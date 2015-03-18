package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import de.quist.app.maps.utils.MappingIterable;
import de.quist.app.maps.utils.ParcelableWrapper;

class PolylineOptions extends ParcelableWrapper<com.amazon.geo.mapsv2.model.PolylineOptions> implements de.quist.app.maps.model.PolylineOptions {

    private static final MappingIterable.IMapper<de.quist.app.maps.model.LatLng,com.amazon.geo.mapsv2.model.LatLng> POINT_UNWRAPPER = new MappingIterable.IMapper<de.quist.app.maps.model.LatLng, com.amazon.geo.mapsv2.model.LatLng>() {
        @Override
        public com.amazon.geo.mapsv2.model.LatLng map(de.quist.app.maps.model.LatLng item) {
            return LatLng.MAPPER.unwrap(item);
        }
    };

    static final Mapper<de.quist.app.maps.model.PolylineOptions, PolylineOptions, com.amazon.geo.mapsv2.model.PolylineOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.PolylineOptions, PolylineOptions, com.amazon.geo.mapsv2.model.PolylineOptions>() {

        @Override
        public PolylineOptions createWrapper(com.amazon.geo.mapsv2.model.PolylineOptions original) {
            return original != null ? new PolylineOptions(original) : null;
        }
    };

    private PolylineOptions(com.amazon.geo.mapsv2.model.PolylineOptions original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions add(de.quist.app.maps.model.LatLng point) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.add(LatLng.MAPPER.unwrap(point));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
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
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions addAll(Iterable<de.quist.app.maps.model.LatLng> points) {
        Iterable<com.amazon.geo.mapsv2.model.LatLng> originalPoints = new MappingIterable<de.quist.app.maps.model.LatLng, com.amazon.geo.mapsv2.model.LatLng>(points, POINT_UNWRAPPER);
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.addAll(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions width(float width) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.width(width);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolylineOptions color(int color) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.color(color);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolylineOptions zIndex(float zIndex) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions geodesic(boolean geodesic) {
        com.amazon.geo.mapsv2.model.PolylineOptions ret = original.geodesic(geodesic);
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

    public static final Parcelable.Creator<PolylineOptions> CREATOR
            = new Parcelable.Creator<PolylineOptions>() {
        public PolylineOptions createFromParcel(Parcel in) {
            return PolylineOptions.MAPPER.wrap(com.amazon.geo.mapsv2.model.PolylineOptions.CREATOR.createFromParcel(in));
        }

        public PolylineOptions[] newArray(int size) {
            return new PolylineOptions[size];
        }
    };
}
