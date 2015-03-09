package de.quist.app.mapsabstraction.model;

import android.os.Parcelable;

public interface Tile extends Parcelable {

    int width();
    int height();
    byte[] data();

}
