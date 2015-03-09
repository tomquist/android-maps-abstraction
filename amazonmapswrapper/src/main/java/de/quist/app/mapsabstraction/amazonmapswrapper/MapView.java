package de.quist.app.mapsabstraction.amazonmapswrapper;

import android.os.Bundle;
import android.view.View;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.OnMapReadyCallback;

class MapView implements de.quist.app.mapsabstraction.MapView {

    public static com.amazon.geo.mapsv2.MapView unwrap(de.quist.app.mapsabstraction.MapView map) {
        return map != null ? ((MapView)map).original : null;
    }

    public static MapView wrap(com.amazon.geo.mapsv2.MapView map) {
        return map != null ? new MapView(map) : null;
    }

    private final com.amazon.geo.mapsv2.MapView original;

    MapView(com.amazon.geo.mapsv2.MapView original) {
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
