package de.quist.app.maps.google;

import android.view.View;

import com.google.android.gms.maps.MapFragment;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.utils.Wrapper;

class MapFragmentWrapper extends Wrapper<MapFragment> implements de.quist.app.maps.MapFragmentWrapper {

    static final Mapper<de.quist.app.maps.MapFragmentWrapper, MapFragmentWrapper, com.google.android.gms.maps.MapFragment> MAPPER = new DefaultMapper<de.quist.app.maps.MapFragmentWrapper, MapFragmentWrapper, com.google.android.gms.maps.MapFragment>() {

        @Override
        public MapFragmentWrapper createWrapper(MapFragment original) {
            return original != null ? new MapFragmentWrapper(original) : null;
        }
    };

    private MapFragmentWrapper(com.google.android.gms.maps.MapFragment original) {
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
        return original.getView();
    }

}
