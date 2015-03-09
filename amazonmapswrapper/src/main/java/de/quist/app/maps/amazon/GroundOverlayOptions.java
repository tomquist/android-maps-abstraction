package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

class GroundOverlayOptions implements de.quist.app.maps.model.GroundOverlayOptions {

    static com.amazon.geo.mapsv2.model.GroundOverlayOptions unwrap(de.quist.app.maps.model.GroundOverlayOptions groundOverlayOptions) {
        return groundOverlayOptions != null ? ((GroundOverlayOptions)groundOverlayOptions).original : null;
    }

    static GroundOverlayOptions wrap(com.amazon.geo.mapsv2.model.GroundOverlayOptions groundOverlayOptions) {
        return groundOverlayOptions != null ? new GroundOverlayOptions(groundOverlayOptions) : null;
    }

    final com.amazon.geo.mapsv2.model.GroundOverlayOptions original;

    private GroundOverlayOptions(com.amazon.geo.mapsv2.model.GroundOverlayOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions image(de.quist.app.maps.model.BitmapDescriptor image) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.image(BitmapDescriptor.unwrap(image));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions anchor(float u, float v) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.anchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions position(de.quist.app.maps.model.LatLng location, float width) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.position(LatLng.unwrap(location), width);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions position(de.quist.app.maps.model.LatLng location, float width, float height) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.position(LatLng.unwrap(location), width, height);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions positionFromBounds(de.quist.app.maps.model.LatLngBounds bounds) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.positionFromBounds(LatLngBounds.unwrap(bounds));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions bearing(float bearing) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.bearing(bearing);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions zIndex(float zIndex) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions transparency(float transparency) {
        com.amazon.geo.mapsv2.model.GroundOverlayOptions ret = original.transparency(transparency);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor getImage() {
        return BitmapDescriptor.wrap(original.getImage());
    }

    @Override
    public de.quist.app.maps.model.LatLng getLocation() {
        return LatLng.wrap(original.getLocation());
    }

    @Override
    public float getWidth() {
        return original.getWidth();
    }

    @Override
    public float getHeight() {
        return original.getHeight();
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds getBounds() {
        return LatLngBounds.wrap(original.getBounds());
    }

    @Override
    public float getBearing() {
        return original.getBearing();
    }

    @Override
    public float getZIndex() {
        return original.getZIndex();
    }

    @Override
    public float getTransparency() {
        return original.getTransparency();
    }

    @Override
    public float getAnchorU() {
        return original.getAnchorU();
    }

    @Override
    public float getAnchorV() {
        return original.getAnchorV();
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
        if (!(o instanceof GroundOverlayOptions)) {
            return false;
        }

        GroundOverlayOptions other = (GroundOverlayOptions)o;
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

    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR
            = new Parcelable.Creator<GroundOverlayOptions>() {
        public GroundOverlayOptions createFromParcel(Parcel in) {
            return GroundOverlayOptions.wrap(com.amazon.geo.mapsv2.model.GroundOverlayOptions.CREATOR.createFromParcel(in));
        }

        public GroundOverlayOptions[] newArray(int size) {
            return new GroundOverlayOptions[size];
        }
    };
}
