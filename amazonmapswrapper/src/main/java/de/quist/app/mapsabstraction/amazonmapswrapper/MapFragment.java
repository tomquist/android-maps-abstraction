package de.quist.app.mapsabstraction.amazonmapswrapper;

import android.view.View;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.OnMapReadyCallback;

class MapFragment implements de.quist.app.mapsabstraction.MapFragment {

    public static com.amazon.geo.mapsv2.MapFragment unwrap(MapFragment map) {
        return map != null ? map.original : null;
    }

    public static MapFragment wrap(com.amazon.geo.mapsv2.MapFragment map) {
        return map != null ? new MapFragment(map) : null;
    }

    private final com.amazon.geo.mapsv2.MapFragment original;

    MapFragment(com.amazon.geo.mapsv2.MapFragment original) {
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
