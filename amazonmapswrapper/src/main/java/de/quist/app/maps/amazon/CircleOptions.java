package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import de.quist.app.maps.utils.ParcelableWrapper;

class CircleOptions extends ParcelableWrapper<com.amazon.geo.mapsv2.model.CircleOptions> implements de.quist.app.maps.model.CircleOptions {

    static final Mapper<de.quist.app.maps.model.CircleOptions, CircleOptions, com.amazon.geo.mapsv2.model.CircleOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.CircleOptions, CircleOptions, com.amazon.geo.mapsv2.model.CircleOptions>() {

        @Override
        public CircleOptions createWrapper(com.amazon.geo.mapsv2.model.CircleOptions original) {
            return original != null ? new CircleOptions(original) : null;
        }
    };

    public CircleOptions(com.amazon.geo.mapsv2.model.CircleOptions original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.CircleOptions center(de.quist.app.maps.model.LatLng center) {
        com.amazon.geo.mapsv2.model.CircleOptions ret = original.center(LatLng.MAPPER.unwrap(center));
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.CircleOptions radius(double radius) {
        com.amazon.geo.mapsv2.model.CircleOptions ret = original.radius(radius);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.CircleOptions strokeWidth(float width) {
        com.amazon.geo.mapsv2.model.CircleOptions ret = original.strokeWidth(width);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.CircleOptions strokeColor(int color) {
        com.amazon.geo.mapsv2.model.CircleOptions ret = original.strokeColor(color);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.CircleOptions fillColor(int color) {
        com.amazon.geo.mapsv2.model.CircleOptions ret = original.fillColor(color);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.CircleOptions zIndex(float zIndex) {
        com.amazon.geo.mapsv2.model.CircleOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.CircleOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.CircleOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.LatLng getCenter() {
        return LatLng.MAPPER.wrap(original.getCenter());
    }

    @Override
    public double getRadius() {
        return original.getRadius();
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

    public static final Parcelable.Creator<CircleOptions> CREATOR
            = new Parcelable.Creator<CircleOptions>() {
        public CircleOptions createFromParcel(Parcel in) {
            return CircleOptions.MAPPER.wrap(com.amazon.geo.mapsv2.model.CircleOptions.CREATOR.createFromParcel(in));
        }

        public CircleOptions[] newArray(int size) {
            return new CircleOptions[size];
        }
    };
}
