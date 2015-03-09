package de.quist.app.maps.amazon;

import android.view.View;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;

class MapFragmentWrapper implements de.quist.app.maps.MapFragmentWrapper {

    public static com.amazon.geo.mapsv2.MapFragment unwrap(de.quist.app.maps.amazon.MapFragmentWrapper map) {
        return map != null ? map.original : null;
    }

    public static de.quist.app.maps.amazon.MapFragmentWrapper wrap(com.amazon.geo.mapsv2.MapFragment map) {
        return map != null ? new de.quist.app.maps.amazon.MapFragmentWrapper(map) : null;
    }

    private final com.amazon.geo.mapsv2.MapFragment original;

    MapFragmentWrapper(com.amazon.geo.mapsv2.MapFragment original) {
        this.original = original;
    }

    @Override
    public Map getMap() {
        return AmazonMap.wrap(original.getMap());
    }

    @Override
    public void getMapAsync(final OnMapReadyCallback callback) {
        com.amazon.geo.mapsv2.OnMapReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.amazon.geo.mapsv2.OnMapReadyCallback() {
                @Override
                public void onMapReady(com.amazon.geo.mapsv2.AmazonMap googleMap) {
                    callback.onMapReady(AmazonMap.wrap(googleMap));
                }
            };
        }
        original.getMapAsync(wrapperCallback);
    }

    @Override
    public View getView() {
        return original.getView();
    }

}
