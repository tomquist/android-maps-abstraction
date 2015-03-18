package de.quist.app.maps.google;

import de.quist.app.maps.utils.Wrapper;

class BitmapDescriptor extends Wrapper<com.google.android.gms.maps.model.BitmapDescriptor> implements de.quist.app.maps.model.BitmapDescriptor {

    static final Mapper<de.quist.app.maps.model.BitmapDescriptor, BitmapDescriptor, com.google.android.gms.maps.model.BitmapDescriptor> MAPPER = new DefaultMapper<de.quist.app.maps.model.BitmapDescriptor, BitmapDescriptor, com.google.android.gms.maps.model.BitmapDescriptor>() {

        @Override
        public BitmapDescriptor createWrapper(com.google.android.gms.maps.model.BitmapDescriptor original) {
            return original != null ? new BitmapDescriptor(original) : null;
        }
    };

    public BitmapDescriptor(com.google.android.gms.maps.model.BitmapDescriptor original) {
        super(original);
    }

}
