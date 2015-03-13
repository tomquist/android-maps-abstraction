package de.quist.app.maps.google;

import android.view.View;

import com.google.android.gms.maps.SupportMapFragment;

import de.quist.app.maps.Map;
import de.quist.app.maps.MapFragmentWrapper;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.utils.Wrapper;

class SupportMapFragmentWrapper extends Wrapper<SupportMapFragment> implements MapFragmentWrapper {

    static final Mapper<MapFragmentWrapper, SupportMapFragmentWrapper, com.google.android.gms.maps.SupportMapFragment> MAPPER = new DefaultMapper<MapFragmentWrapper, SupportMapFragmentWrapper, com.google.android.gms.maps.SupportMapFragment>() {

        @Override
        public SupportMapFragmentWrapper createWrapper(SupportMapFragment original) {
            return original != null ? new SupportMapFragmentWrapper(original) : null;
        }
    };

    private SupportMapFragmentWrapper(com.google.android.gms.maps.SupportMapFragment original) {
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
