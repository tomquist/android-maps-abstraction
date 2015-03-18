package de.quist.app.maps.google;

import android.os.Parcel;

import de.quist.app.maps.utils.ParcelableWrapper;

class GroundOverlayOptions extends ParcelableWrapper<com.google.android.gms.maps.model.GroundOverlayOptions> implements de.quist.app.maps.model.GroundOverlayOptions {

    static final Mapper<de.quist.app.maps.model.GroundOverlayOptions, GroundOverlayOptions, com.google.android.gms.maps.model.GroundOverlayOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.GroundOverlayOptions, GroundOverlayOptions, com.google.android.gms.maps.model.GroundOverlayOptions>() {

        @Override
        public GroundOverlayOptions createWrapper(com.google.android.gms.maps.model.GroundOverlayOptions original) {
            return original != null ? new GroundOverlayOptions(original) : null;
        }
    };

    private GroundOverlayOptions(com.google.android.gms.maps.model.GroundOverlayOptions original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions image(de.quist.app.maps.model.BitmapDescriptor image) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.image(BitmapDescriptor.MAPPER.unwrap(image));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions anchor(float u, float v) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.anchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions position(de.quist.app.maps.model.LatLng location, float width) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.position(LatLng.MAPPER.unwrap(location), width);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions position(de.quist.app.maps.model.LatLng location, float width, float height) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.position(LatLng.MAPPER.unwrap(location), width, height);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions positionFromBounds(de.quist.app.maps.model.LatLngBounds bounds) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.positionFromBounds(LatLngBounds.MAPPER.unwrap(bounds));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions bearing(float bearing) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.bearing(bearing);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions visible(boolean visible) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions transparency(float transparency) {
        com.google.android.gms.maps.model.GroundOverlayOptions ret = original.transparency(transparency);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor getImage() {
        return BitmapDescriptor.MAPPER.wrap(original.getImage());
    }

    @Override
    public de.quist.app.maps.model.LatLng getLocation() {
        return LatLng.MAPPER.wrap(original.getLocation());
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
        return LatLngBounds.MAPPER.wrap(original.getBounds());
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

    public static final Creator<GroundOverlayOptions> CREATOR
            = new Creator<GroundOverlayOptions>() {
        public GroundOverlayOptions createFromParcel(Parcel in) {
            return GroundOverlayOptions.MAPPER.wrap(com.google.android.gms.maps.model.GroundOverlayOptions.CREATOR.dc(in));
        }

        public GroundOverlayOptions[] newArray(int size) {
            return new GroundOverlayOptions[size];
        }
    };
}
