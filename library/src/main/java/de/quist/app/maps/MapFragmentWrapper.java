package de.quist.app.maps;

import android.view.View;

public interface MapFragmentWrapper {

    @java.lang.Deprecated
    Map getMap();

    void getMapAsync(OnMapReadyCallback callback);

    View getView();
}
