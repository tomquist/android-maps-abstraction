package de.quist.app.mapsabstraction.model;

import android.os.Parcelable;

public interface LatLng extends Parcelable {

    double latitude();
    double longitude();

}
