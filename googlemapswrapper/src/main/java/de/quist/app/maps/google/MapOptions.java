package de.quist.app.maps.google;

import android.os.Parcel;

import com.google.android.gms.maps.GoogleMapOptions;

import de.quist.app.maps.model.CameraPosition;

class MapOptions implements de.quist.app.maps.MapOptions {

    static GoogleMapOptions unwrap(de.quist.app.maps.MapOptions mapOptions) {
        return mapOptions != null ? ((MapOptions)mapOptions).original : null;
    }

    static MapOptions wrap(GoogleMapOptions mapOptions) {
        return mapOptions != null ? new MapOptions(mapOptions) : null;
    }

    final GoogleMapOptions original;

    private MapOptions(GoogleMapOptions original) {
        this.original = original;
    }
    
    @Override
    public de.quist.app.maps.MapOptions zOrderOnTop(boolean zOrderOnTop) {
        GoogleMapOptions ret = original.zOrderOnTop(zOrderOnTop);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        GoogleMapOptions ret = original.useViewLifecycleInFragment(useViewLifecycleInFragment);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapType(int mapType) {
        GoogleMapOptions ret = original.mapType(mapType);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions camera(CameraPosition camera) {
        GoogleMapOptions ret = original.camera(de.quist.app.maps.google.CameraPosition.unwrap(camera));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomControlsEnabled(boolean enabled) {
        GoogleMapOptions ret = original.zoomControlsEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions compassEnabled(boolean enabled) {
        GoogleMapOptions ret = original.compassEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions scrollGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.scrollGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.zoomGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions tiltGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.tiltGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions rotateGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.rotateGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions liteMode(boolean enabled) {
        GoogleMapOptions ret = original.liteMode(enabled);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapToolbarEnabled(boolean enabled) {
        GoogleMapOptions ret = original.mapToolbarEnabled(enabled);
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
        return de.quist.app.maps.google.CameraPosition.wrap(original.getCamera());
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

    public static final Creator<MapOptions> CREATOR
            = new Creator<MapOptions>() {
        public MapOptions createFromParcel(Parcel in) {
            return MapOptions.wrap(GoogleMapOptions.CREATOR.cX(in));
        }

        public MapOptions[] newArray(int size) {
            return new MapOptions[size];
        }
    };
}
