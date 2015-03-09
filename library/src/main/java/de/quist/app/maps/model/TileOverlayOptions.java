package de.quist.app.maps.model;

import android.os.Parcelable;

public interface TileOverlayOptions extends Parcelable {

    TileOverlayOptions tileProvider(TileProvider tileProvider);

    TileOverlayOptions zIndex(float zIndex);

    TileOverlayOptions visible(boolean visible);

    TileOverlayOptions fadeIn(boolean fadeIn);

    TileProvider getTileProvider();

    float getZIndex();

    boolean isVisible();

    boolean getFadeIn();

}
