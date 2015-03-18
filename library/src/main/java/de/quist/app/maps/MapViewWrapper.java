package de.quist.app.maps;

import android.os.Bundle;
import android.view.View;

public interface MapViewWrapper {

    @java.lang.Deprecated
    Map getMap();

    void getMapAsync(OnMapReadyCallback callback);

    View getView();

    void onCreate(Bundle savedInstanceState);

    void onResume();

    void onPause();

    void onDestroy();

    void onLowMemory();

    void onSaveInstanceState(Bundle outState);
}
