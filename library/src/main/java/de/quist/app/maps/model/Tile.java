package de.quist.app.maps.model;

import android.os.Parcelable;

public interface Tile extends Parcelable {

    int width();
    int height();
    byte[] data();

}
