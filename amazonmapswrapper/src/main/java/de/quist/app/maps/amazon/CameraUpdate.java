package de.quist.app.maps.amazon;


import de.quist.app.maps.utils.Wrapper;

class CameraUpdate extends Wrapper<com.amazon.geo.mapsv2.CameraUpdate> implements de.quist.app.maps.CameraUpdate {

    static final Mapper<de.quist.app.maps.CameraUpdate, CameraUpdate, com.amazon.geo.mapsv2.CameraUpdate> MAPPER = new DefaultMapper<de.quist.app.maps.CameraUpdate, CameraUpdate, com.amazon.geo.mapsv2.CameraUpdate>() {

        @Override
        public CameraUpdate createWrapper(com.amazon.geo.mapsv2.CameraUpdate original) {
            return original != null ? new CameraUpdate(original) : null;
        }
    };

    private CameraUpdate(com.amazon.geo.mapsv2.CameraUpdate cameraUpdate) {
        super(cameraUpdate);
    }

}
