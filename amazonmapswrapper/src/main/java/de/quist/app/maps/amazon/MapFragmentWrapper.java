package de.quist.app.maps.amazon;

import android.view.View;

import com.amazon.geo.mapsv2.MapFragment;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.utils.Wrapper;

class MapFragmentWrapper extends Wrapper<MapFragment> implements de.quist.app.maps.MapFragmentWrapper {

    static final Mapper<de.quist.app.maps.MapFragmentWrapper, MapFragmentWrapper, com.amazon.geo.mapsv2.MapFragment> MAPPER = new DefaultMapper<de.quist.app.maps.MapFragmentWrapper, MapFragmentWrapper, com.amazon.geo.mapsv2.MapFragment>() {

        @Override
        public MapFragmentWrapper createWrapper(MapFragment original) {
            return original != null ? new MapFragmentWrapper(original) : null;
        }
    };

    private MapFragmentWrapper(com.amazon.geo.mapsv2.MapFragment original) {
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
