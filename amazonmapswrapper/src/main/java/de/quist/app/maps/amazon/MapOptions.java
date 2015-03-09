package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import com.amazon.geo.mapsv2.AmazonMapOptions;

import de.quist.app.maps.model.CameraPosition;

class MapOptions implements de.quist.app.maps.MapOptions {

    static AmazonMapOptions unwrap(de.quist.app.maps.MapOptions mapOptions) {
        return mapOptions != null ? ((MapOptions)mapOptions).original : null;
    }

    static MapOptions wrap(AmazonMapOptions mapOptions) {
        return mapOptions != null ? new MapOptions(mapOptions) : null;
    }

    final AmazonMapOptions original;

    private MapOptions(AmazonMapOptions original) {
        this.original = original;
    }
    
    @Override
    public de.quist.app.maps.MapOptions zOrderOnTop(boolean zOrderOnTop) {
        AmazonMapOptions ret = original.zOrderOnTop(zOrderOnTop);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        AmazonMapOptions ret = original.useViewLifecycleInFragment(useViewLifecycleInFragment);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapType(int mapType) {
        AmazonMapOptions ret = original.mapType(mapType);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions camera(CameraPosition camera) {
        AmazonMapOptions ret = original.camera(de.quist.app.maps.amazon.CameraPosition.unwrap(camera));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomControlsEnabled(boolean enabled) {
        AmazonMapOptions ret = original.zoomControlsEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions compassEnabled(boolean enabled) {
        AmazonMapOptions ret = original.compassEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions scrollGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.scrollGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.zoomGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions tiltGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.tiltGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions rotateGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.rotateGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions liteMode(boolean enabled) {
        AmazonMapOptions ret = original.liteMode(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapToolbarEnabled(boolean enabled) {
        AmazonMapOptions ret = original.mapToolbarEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public Boolean getZOrderOnTop() {
        return original.getZOrderOnTop();
    }

    @Override
    public Boolean getUseViewLifecycleInFragment() {
        return original.getUseViewLifecycleInFragment();
    }

    @Override
    public int getMapType() {
        return original.getMapType();
    }

    @Override
    public CameraPosition getCamera() {
        return de.quist.app.maps.amazon.CameraPosition.wrap(original.getCamera());
    }

    @Override
    public Boolean getZoomControlsEnabled() {
        return original.getZoomControlsEnabled();
    }

    @Override
    public Boolean getCompassEnabled() {
        return original.getCompassEnabled();
    }

    @Override
    public Boolean getScrollGesturesEnabled() {
        return original.getScrollGesturesEnabled();
    }

    @Override
    public Boolean getZoomGesturesEnabled() {
        return original.getZoomGesturesEnabled();
    }

    @Override
    public Boolean getTiltGesturesEnabled() {
        return original.getTiltGesturesEnabled();
    }

    @Override
    public Boolean getRotateGesturesEnabled() {
        return original.getRotateGesturesEnabled();
    }

    @Override
    public Boolean getLiteMode() {
        return original.getLiteMode();
    }

    @Override
    public Boolean getMapToolbarEnabled() {
        return original.getMapToolbarEnabled();
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapOptions)) {
            return false;
        }

        MapOptions other = (MapOptions)o;
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

    public static final Parcelable.Creator<MapOptions> CREATOR
            = new Parcelable.Creator<MapOptions>() {
        public MapOptions createFromParcel(Parcel in) {
            return MapOptions.wrap(AmazonMapOptions.CREATOR.createFromParcel(in));
        }

        public MapOptions[] newArray(int size) {
            return new MapOptions[size];
        }
    };
}
