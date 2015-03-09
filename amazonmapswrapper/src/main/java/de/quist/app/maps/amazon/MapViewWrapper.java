package de.quist.app.maps.amazon;

import android.os.Bundle;
import android.view.View;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;

class MapViewWrapper implements de.quist.app.maps.MapViewWrapper {

    public static com.amazon.geo.mapsv2.MapView unwrap(de.quist.app.maps.MapViewWrapper map) {
        return map != null ? ((de.quist.app.maps.amazon.MapViewWrapper)map).original : null;
    }

    public static de.quist.app.maps.amazon.MapViewWrapper wrap(com.amazon.geo.mapsv2.MapView map) {
        return map != null ? new de.quist.app.maps.amazon.MapViewWrapper(map) : null;
    }

    private final com.amazon.geo.mapsv2.MapView original;

    MapViewWrapper(com.amazon.geo.mapsv2.MapView original) {
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
        return original;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        original.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        original.onResume();
    }

    @Override
    public void onPause() {
        original.onPause();
    }

    @Override
    public void onDestroy() {
        original.onDestroy();
    }

    @Override
    public void onLowMemory() {
        original.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        original.onSaveInstanceState(outState);
    }

}
