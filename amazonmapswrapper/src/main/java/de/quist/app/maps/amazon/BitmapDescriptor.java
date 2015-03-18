package de.quist.app.maps.amazon;

import de.quist.app.maps.utils.Wrapper;

class BitmapDescriptor extends Wrapper<com.amazon.geo.mapsv2.model.BitmapDescriptor> implements de.quist.app.maps.model.BitmapDescriptor {

    static final Mapper<de.quist.app.maps.model.BitmapDescriptor, BitmapDescriptor, com.amazon.geo.mapsv2.model.BitmapDescriptor> MAPPER = new DefaultMapper<de.quist.app.maps.model.BitmapDescriptor, BitmapDescriptor, com.amazon.geo.mapsv2.model.BitmapDescriptor>() {

        @Override
        public BitmapDescriptor createWrapper(com.amazon.geo.mapsv2.model.BitmapDescriptor original) {
            return original != null ? new BitmapDescriptor(original) : null;
        }
    };

    public BitmapDescriptor(com.amazon.geo.mapsv2.model.BitmapDescriptor original) {
        super(original);
    }

}
