package de.quist.app.maps.amazon;

import android.os.Bundle;
import android.view.View;

import com.amazon.geo.mapsv2.MapView;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.utils.Wrapper;

class MapViewWrapper extends Wrapper<MapView> implements de.quist.app.maps.MapViewWrapper {

    static final Mapper<de.quist.app.maps.MapViewWrapper, MapViewWrapper, com.amazon.geo.mapsv2.MapView> MAPPER = new DefaultMapper<de.quist.app.maps.MapViewWrapper, MapViewWrapper, com.amazon.geo.mapsv2.MapView>() {

        @Override
        public MapViewWrapper createWrapper(MapView original) {
            return original != null ? new MapViewWrapper(original) : null;
        }
    };

    private MapViewWrapper(com.amazon.geo.mapsv2.MapView original) {
        super(original);
    }

    @Override
    public Map getMap() {
        return AmazonMap.MAPPER.wrap(original.getMap());
    }

    @Override
    public void getMapAsync(final OnMapReadyCallback callback) {
        com.amazon.geo.mapsv2.OnMapReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.amazon.geo.mapsv2.OnMapReadyCallback() {
                @Override
                public void onMapReady(com.amazon.geo.mapsv2.AmazonMap amazonMap) {
                    callback.onMapReady(AmazonMap.MAPPER.wrap(amazonMap));
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
