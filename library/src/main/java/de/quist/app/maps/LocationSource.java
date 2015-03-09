package de.quist.app.maps;

import android.location.Location;

public interface LocationSource {

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();

    static interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

}
