package de.quist.app.maps.google;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.MapView;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.utils.Wrapper;

class MapViewWrapper extends Wrapper<MapView> implements de.quist.app.maps.MapViewWrapper {

    static final Mapper<de.quist.app.maps.MapViewWrapper, MapViewWrapper, com.google.android.gms.maps.MapView> MAPPER = new DefaultMapper<de.quist.app.maps.MapViewWrapper, MapViewWrapper, com.google.android.gms.maps.MapView>() {

        @Override
        public MapViewWrapper createWrapper(MapView original) {
            return original != null ? new MapViewWrapper(original) : null;
        }
    };

    private MapViewWrapper(com.google.android.gms.maps.MapView original) {
        super(original);
    }

    @Override
    public Map getMap() {
        return GoogleMap.MAPPER.wrap(original.getMap());
    }

    @Override
    public void getMapAsync(final OnMapReadyCallback callback) {
        com.google.android.gms.maps.OnMapReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.google.android.gms.maps.OnMapReadyCallback() {
                @Override
                public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
                    callback.onMapReady(GoogleMap.MAPPER.wrap(googleMap));
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
