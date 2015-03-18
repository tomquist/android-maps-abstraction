package de.quist.app.maps.google;

import android.os.Parcel;

import java.util.List;

import de.quist.app.maps.utils.MappingIterable;
import de.quist.app.maps.utils.ParcelableWrapper;

class PolylineOptions extends ParcelableWrapper<com.google.android.gms.maps.model.PolylineOptions> implements de.quist.app.maps.model.PolylineOptions {

    private static final MappingIterable.IMapper<de.quist.app.maps.model.LatLng,com.google.android.gms.maps.model.LatLng> POINT_UNWRAPPER = new MappingIterable.IMapper<de.quist.app.maps.model.LatLng, com.google.android.gms.maps.model.LatLng>() {
        @Override
        public com.google.android.gms.maps.model.LatLng map(de.quist.app.maps.model.LatLng item) {
            return LatLng.MAPPER.unwrap(item);
        }
    };

    static final Mapper<de.quist.app.maps.model.PolylineOptions, PolylineOptions, com.google.android.gms.maps.model.PolylineOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.PolylineOptions, PolylineOptions, com.google.android.gms.maps.model.PolylineOptions>() {

        @Override
        public PolylineOptions createWrapper(com.google.android.gms.maps.model.PolylineOptions original) {
            return original != null ? new PolylineOptions(original) : null;
        }
    };

    private PolylineOptions(com.google.android.gms.maps.model.PolylineOptions original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions add(de.quist.app.maps.model.LatLng point) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.add(LatLng.MAPPER.unwrap(point));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions add(de.quist.app.maps.model.LatLng... points) {
        com.google.android.gms.maps.model.LatLng[] unwrappedPoints = new com.google.android.gms.maps.model.LatLng[points.length];
        for (int i = 0; i<points.length; i++) {
            unwrappedPoints[i] = LatLng.unwrap(points[i]);
        }
        com.google.android.gms.maps.model.PolylineOptions ret = original.add(unwrappedPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions addAll(Iterable<de.quist.app.maps.model.LatLng> points) {
        Iterable<com.google.android.gms.maps.model.LatLng> originalPoints = new MappingIterable<de.quist.app.maps.model.LatLng, com.google.android.gms.maps.model.LatLng>(points, POINT_UNWRAPPER);
        com.google.android.gms.maps.model.PolylineOptions ret = original.addAll(originalPoints);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions width(float width) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.width(width);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolylineOptions color(int color) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.color(color);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }

    }

    @Override
    public de.quist.app.maps.model.PolylineOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions visible(boolean visible) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions geodesic(boolean geodesic) {
        com.google.android.gms.maps.model.PolylineOptions ret = original.geodesic(geodesic);
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

    public static final Creator<PolylineOptions> CREATOR
            = new Creator<PolylineOptions>() {
        public PolylineOptions createFromParcel(Parcel in) {
            return PolylineOptions.MAPPER.wrap(com.google.android.gms.maps.model.PolylineOptions.CREATOR.dh(in));
        }

        public PolylineOptions[] newArray(int size) {
            return new PolylineOptions[size];
        }
    };
}
