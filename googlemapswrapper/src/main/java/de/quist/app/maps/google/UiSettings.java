package de.quist.app.maps.google;

import de.quist.app.maps.utils.Wrapper;

class UiSettings extends Wrapper<com.google.android.gms.maps.UiSettings> implements de.quist.app.maps.UiSettings {

    static final Mapper<de.quist.app.maps.UiSettings, UiSettings, com.google.android.gms.maps.UiSettings> MAPPER = new DefaultMapper<de.quist.app.maps.UiSettings, UiSettings, com.google.android.gms.maps.UiSettings>() {

        @Override
        public UiSettings createWrapper(com.google.android.gms.maps.UiSettings original) {
            return original != null ? new UiSettings(original) : null;
        }
    };

    private UiSettings(com.google.android.gms.maps.UiSettings original) {
        super(original);
    }
    
    @Override
    public void setZoomControlsEnabled(boolean enabled) {
        original.setZoomControlsEnabled(enabled);
    }

    @Override
    public void setCompassEnabled(boolean enabled) {
        original.setCompassEnabled(enabled);
    }

    @Override
    public void setMyLocationButtonEnabled(boolean enabled) {
        original.setMyLocationButtonEnabled(enabled);
    }

    @Override
    public void setIndoorLevelPickerEnabled(boolean enabled) {
        original.setIndoorLevelPickerEnabled(enabled);
    }

    @Override
    public void setScrollGesturesEnabled(boolean enabled) {
        original.setScrollGesturesEnabled(enabled);
    }

    @Override
    public void setZoomGesturesEnabled(boolean enabled) {
        original.setZoomGesturesEnabled(enabled);
    }

    @Override
    public void setTiltGesturesEnabled(boolean enabled) {
        original.setTiltGesturesEnabled(enabled);
    }

    @Override
    public void setRotateGesturesEnabled(boolean enabled) {
        original.setRotateGesturesEnabled(enabled);
    }

    @Override
    public void setAllGesturesEnabled(boolean enabled) {
        original.setAllGesturesEnabled(enabled);
    }

    @Override
    public void setMapToolbarEnabled(boolean enabled) {
        original.setMapToolbarEnabled(enabled);
    }

    @Override
    public boolean isZoomControlsEnabled() {
        return original.isZoomControlsEnabled();
    }

    @Override
    public boolean isCompassEnabled() {
        return original.isCompassEnabled();
    }

    @Override
    public boolean isMyLocationButtonEnabled() {
        return original.isMyLocationButtonEnabled();
    }

    @Override
    public boolean isIndoorLevelPickerEnabled() {
        return original.isIndoorLevelPickerEnabled();
    }

    @Override
    public boolean isScrollGesturesEnabled() {
        return original.isScrollGesturesEnabled();
    }

    @Override
    public boolean isZoomGesturesEnabled() {
        return original.isZoomGesturesEnabled();
    }

    @Override
    public boolean isTiltGesturesEnabled() {
        return original.isTiltGesturesEnabled();
    }

    @Override
    public boolean isRotateGesturesEnabled() {
        return original.isRotateGesturesEnabled();
    }

    @Override
    public boolean isMapToolbarEnabled() {
        return original.isMapToolbarEnabled();
    }

}
