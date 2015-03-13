package de.quist.app.maps.google;


import de.quist.app.maps.utils.Wrapper;

class CameraUpdate extends Wrapper<com.google.android.gms.maps.CameraUpdate> implements de.quist.app.maps.CameraUpdate {

    static final Mapper<de.quist.app.maps.CameraUpdate, CameraUpdate, com.google.android.gms.maps.CameraUpdate> MAPPER = new DefaultMapper<de.quist.app.maps.CameraUpdate, CameraUpdate, com.google.android.gms.maps.CameraUpdate>() {

        @Override
        public CameraUpdate createWrapper(com.google.android.gms.maps.CameraUpdate original) {
            return original != null ? new CameraUpdate(original) : null;
        }
    };

    private CameraUpdate(com.google.android.gms.maps.CameraUpdate cameraUpdate) {
        super(cameraUpdate);
    }

}
