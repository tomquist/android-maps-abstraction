package de.quist.app.maps.amazon;

import android.view.View;

import de.quist.app.maps.Map;
import de.quist.app.maps.MapFragmentWrapper;
import de.quist.app.maps.OnMapReadyCallback;

class SupportMapFragmentWrapper implements MapFragmentWrapper {

    public static com.amazon.geo.mapsv2.SupportMapFragment unwrap(SupportMapFragmentWrapper map) {
        return map != null ? map.original : null;
    }

    public static SupportMapFragmentWrapper wrap(com.amazon.geo.mapsv2.SupportMapFragment map) {
        return map != null ? new SupportMapFragmentWrapper(map) : null;
    }

    private final com.amazon.geo.mapsv2.SupportMapFragment original;

    SupportMapFragmentWrapper(com.amazon.geo.mapsv2.SupportMapFragment original) {
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
                public void onMapReady(com.amazon.geo.mapsv2.AmazonMap amazonMap) {
                    callback.onMapReady(AmazonMap.wrap(amazonMap));
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
