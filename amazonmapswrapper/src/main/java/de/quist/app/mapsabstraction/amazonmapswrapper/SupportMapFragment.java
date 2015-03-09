package de.quist.app.mapsabstraction.amazonmapswrapper;

import android.view.View;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.MapFragment;
import de.quist.app.mapsabstraction.OnMapReadyCallback;

class SupportMapFragment implements MapFragment {

    public static com.amazon.geo.mapsv2.SupportMapFragment unwrap(SupportMapFragment map) {
        return map != null ? map.original : null;
    }

    public static SupportMapFragment wrap(com.amazon.geo.mapsv2.SupportMapFragment map) {
        return map != null ? new SupportMapFragment(map) : null;
    }

    private final com.amazon.geo.mapsv2.SupportMapFragment original;

    SupportMapFragment(com.amazon.geo.mapsv2.SupportMapFragment original) {
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
