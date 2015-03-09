package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Parcel;
import android.os.Parcelable;

class CircleOptions implements de.quist.app.mapsabstraction.model.CircleOptions {

    static com.google.android.gms.maps.model.CircleOptions unwrap(de.quist.app.mapsabstraction.model.CircleOptions circleOptions) {
        return circleOptions != null ? ((CircleOptions)circleOptions).original : null;
    }

    static CircleOptions wrap(com.google.android.gms.maps.model.CircleOptions circleOptions) {
        return circleOptions != null ? new CircleOptions(circleOptions) : null;
    }

    final com.google.android.gms.maps.model.CircleOptions original;

    public CircleOptions(com.google.android.gms.maps.model.CircleOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions center(de.quist.app.mapsabstraction.model.LatLng center) {
        com.google.android.gms.maps.model.CircleOptions ret = original.center(LatLng.unwrap(center));
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions radius(double radius) {
        com.google.android.gms.maps.model.CircleOptions ret = original.radius(radius);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions strokeWidth(float width) {
        com.google.android.gms.maps.model.CircleOptions ret = original.strokeWidth(width);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions strokeColor(int color) {
        com.google.android.gms.maps.model.CircleOptions ret = original.strokeColor(color);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions fillColor(int color) {
        com.google.android.gms.maps.model.CircleOptions ret = original.fillColor(color);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.CircleOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions visible(boolean visible) {
        com.google.android.gms.maps.model.CircleOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return new CircleOptions(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLng getCenter() {
        return LatLng.wrap(original.getCenter());
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

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CircleOptions)) {
            return false;
        }

        CircleOptions other = (CircleOptions)o;
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

    public static final Parcelable.Creator<CircleOptions> CREATOR
            = new Parcelable.Creator<CircleOptions>() {
        public CircleOptions createFromParcel(Parcel in) {
            return CircleOptions.wrap(com.google.android.gms.maps.model.CircleOptions.CREATOR.db(in));
        }

        public CircleOptions[] newArray(int size) {
            return new CircleOptions[size];
        }
    };
}
