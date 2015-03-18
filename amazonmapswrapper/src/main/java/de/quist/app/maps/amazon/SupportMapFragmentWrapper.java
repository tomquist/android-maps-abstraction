package de.quist.app.maps.amazon;

import android.view.View;

import com.amazon.geo.mapsv2.SupportMapFragment;

import de.quist.app.maps.Map;
import de.quist.app.maps.MapFragmentWrapper;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.utils.Wrapper;

class SupportMapFragmentWrapper extends Wrapper<SupportMapFragment> implements MapFragmentWrapper {

    static final Mapper<de.quist.app.maps.MapFragmentWrapper, SupportMapFragmentWrapper, com.amazon.geo.mapsv2.SupportMapFragment> MAPPER = new DefaultMapper<de.quist.app.maps.MapFragmentWrapper, SupportMapFragmentWrapper, com.amazon.geo.mapsv2.SupportMapFragment>() {

        @Override
        public SupportMapFragmentWrapper createWrapper(SupportMapFragment original) {
            return original != null ? new SupportMapFragmentWrapper(original) : null;
        }
    };

    private SupportMapFragmentWrapper(com.amazon.geo.mapsv2.SupportMapFragment original) {
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
        return original.getView();
    }
}
