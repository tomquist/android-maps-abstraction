package de.quist.app.mapsabstraction;

import android.view.View;

public interface MapFragment {

    @java.lang.Deprecated
    Map getMap();

    void getMapAsync(OnMapReadyCallback callback);

    View getView();
}
