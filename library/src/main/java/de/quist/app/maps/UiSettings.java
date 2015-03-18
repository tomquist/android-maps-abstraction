package de.quist.app.maps;

public interface UiSettings {

    void setZoomControlsEnabled(boolean enabled);

    void setCompassEnabled(boolean enabled);

    void setMyLocationButtonEnabled(boolean enabled);

    void setIndoorLevelPickerEnabled(boolean enabled);

    void setScrollGesturesEnabled(boolean enabled);

    void setZoomGesturesEnabled(boolean enabled);

    void setTiltGesturesEnabled(boolean enabled);

    void setRotateGesturesEnabled(boolean enabled);

    void setAllGesturesEnabled(boolean enabled);

    void setMapToolbarEnabled(boolean enabled);

    boolean isZoomControlsEnabled();

    boolean isCompassEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isScrollGesturesEnabled();

    boolean isZoomGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isRotateGesturesEnabled();

    boolean isMapToolbarEnabled();

}
