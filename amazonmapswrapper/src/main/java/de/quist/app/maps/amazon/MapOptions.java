package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import com.amazon.geo.mapsv2.AmazonMapOptions;

import de.quist.app.maps.model.CameraPosition;
import de.quist.app.maps.utils.ParcelableWrapper;

class MapOptions extends ParcelableWrapper<AmazonMapOptions> implements de.quist.app.maps.MapOptions {

    static final Mapper<de.quist.app.maps.MapOptions, MapOptions, AmazonMapOptions> MAPPER = new DefaultMapper<de.quist.app.maps.MapOptions, MapOptions, AmazonMapOptions>() {

        @Override
        public MapOptions createWrapper(AmazonMapOptions original) {
            return original != null ? new MapOptions(original) : null;
        }
    };

    private MapOptions(AmazonMapOptions original) {
        super(original);
    }
    
    @Override
    public de.quist.app.maps.MapOptions zOrderOnTop(boolean zOrderOnTop) {
        AmazonMapOptions ret = original.zOrderOnTop(zOrderOnTop);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        AmazonMapOptions ret = original.useViewLifecycleInFragment(useViewLifecycleInFragment);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapType(int mapType) {
        AmazonMapOptions ret = original.mapType(mapType);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions camera(CameraPosition camera) {
        AmazonMapOptions ret = original.camera(de.quist.app.maps.amazon.CameraPosition.MAPPER.unwrap(camera));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomControlsEnabled(boolean enabled) {
        AmazonMapOptions ret = original.zoomControlsEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions compassEnabled(boolean enabled) {
        AmazonMapOptions ret = original.compassEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions scrollGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.scrollGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions zoomGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.zoomGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions tiltGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.tiltGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions rotateGesturesEnabled(boolean enabled) {
        AmazonMapOptions ret = original.rotateGesturesEnabled(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions liteMode(boolean enabled) {
        AmazonMapOptions ret = original.liteMode(enabled);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.MapOptions mapToolbarEnabled(boolean enabled) {
        AmazonMapOptions ret = original.mapToolbarEnabled(enabled);
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
        return de.quist.app.maps.amazon.CameraPosition.MAPPER.wrap(original.getCamera());
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

    public static final Parcelable.Creator<MapOptions> CREATOR
            = new Parcelable.Creator<MapOptions>() {
        public MapOptions createFromParcel(Parcel in) {
            return MapOptions.MAPPER.wrap(AmazonMapOptions.CREATOR.createFromParcel(in));
        }

        public MapOptions[] newArray(int size) {
            return new MapOptions[size];
        }
    };
}
