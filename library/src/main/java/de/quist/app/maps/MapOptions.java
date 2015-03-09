package de.quist.app.maps;

import android.os.Parcelable;

import de.quist.app.maps.model.CameraPosition;

public interface MapOptions extends Parcelable {

    public MapOptions zOrderOnTop(boolean zOrderOnTop);

    public MapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment);

    public MapOptions mapType(int mapType);

    public MapOptions camera(CameraPosition camera);

    public MapOptions zoomControlsEnabled(boolean enabled);

    public MapOptions compassEnabled(boolean enabled);

    public MapOptions scrollGesturesEnabled(boolean enabled);

    public MapOptions zoomGesturesEnabled(boolean enabled);

    public MapOptions tiltGesturesEnabled(boolean enabled);

    public MapOptions rotateGesturesEnabled(boolean enabled);

    public MapOptions liteMode(boolean enabled);

    public MapOptions mapToolbarEnabled(boolean enabled);

    public Boolean getZOrderOnTop();

    public Boolean getUseViewLifecycleInFragment();

    public int getMapType();

    public CameraPosition getCamera();

    public Boolean getZoomControlsEnabled();

    public Boolean getCompassEnabled();

    public Boolean getScrollGesturesEnabled();

    public Boolean getZoomGesturesEnabled();

    public Boolean getTiltGesturesEnabled();

    public Boolean getRotateGesturesEnabled();

    public Boolean getLiteMode();

    public Boolean getMapToolbarEnabled();
    
}
