package de.quist.app.maps.google;

import android.os.Parcel;

import com.google.android.gms.maps.GoogleMapOptions;

import de.quist.app.maps.MapsBinding;
import de.quist.app.maps.model.CameraPosition;
import de.quist.app.maps.utils.ParcelableWrapper;

class MapOptions extends ParcelableWrapper<GoogleMapOptions> implements de.quist.app.maps.MapOptions {

    static final Mapper<de.quist.app.maps.MapOptions, MapOptions, GoogleMapOptions> MAPPER = new DefaultMapper<de.quist.app.maps.MapOptions, MapOptions, GoogleMapOptions>() {

        @Override
        public MapOptions createWrapper(GoogleMapOptions original) {
            return original != null ? new MapOptions(original) : null;
        }
    };

    private MapOptions(GoogleMapOptions original) {
        super(original);
    }
    
    @Override
    public de.quist.app.maps.MapOptions zOrderOnTop(boolean zOrderOnTop) {
        GoogleMapOptions ret = original.zOrderOnTop(zOrderOnTop);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        GoogleMapOptions ret = original.useViewLifecycleInFragment(useViewLifecycleInFragment);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapType(int mapType) {
        GoogleMapOptions ret = original.mapType(mapType);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions camera(CameraPosition camera) {
        GoogleMapOptions ret = original.camera(de.quist.app.maps.google.CameraPosition.MAPPER.unwrap(camera));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomControlsEnabled(boolean enabled) {
        GoogleMapOptions ret = original.zoomControlsEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions compassEnabled(boolean enabled) {
        GoogleMapOptions ret = original.compassEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions scrollGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.scrollGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.zoomGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions tiltGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.tiltGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions rotateGesturesEnabled(boolean enabled) {
        GoogleMapOptions ret = original.rotateGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions liteMode(boolean enabled) {
        GoogleMapOptions ret = original.liteMode(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapToolbarEnabled(boolean enabled) {
        GoogleMapOptions ret = original.mapToolbarEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
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
        return de.quist.app.maps.google.CameraPosition.MAPPER.wrap(original.getCamera());
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
    public MapsBinding getBinding() {
        return GoogleMapsBinding.INSTANCE;
    }

    public static final Creator<MapOptions> CREATOR
            = new Creator<MapOptions>() {
        public MapOptions createFromParcel(Parcel in) {
            return MapOptions.MAPPER.wrap(GoogleMapOptions.CREATOR.cX(in));
        }

        public MapOptions[] newArray(int size) {
            return new MapOptions[size];
        }
    };
}
