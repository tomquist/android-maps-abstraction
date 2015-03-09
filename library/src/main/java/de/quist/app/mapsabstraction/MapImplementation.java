package de.quist.app.mapsabstraction;

import android.app.Fragment;
import android.view.View;

import de.quist.app.mapsabstraction.model.BitmapDescriptorFactory;
import de.quist.app.mapsabstraction.model.CameraPosition;
import de.quist.app.mapsabstraction.model.CircleOptions;
import de.quist.app.mapsabstraction.model.GroundOverlayOptions;
import de.quist.app.mapsabstraction.model.LatLng;
import de.quist.app.mapsabstraction.model.LatLngBounds;
import de.quist.app.mapsabstraction.model.MarkerOptions;
import de.quist.app.mapsabstraction.model.PolygonOptions;
import de.quist.app.mapsabstraction.model.PolylineOptions;
import de.quist.app.mapsabstraction.model.Tile;
import de.quist.app.mapsabstraction.model.TileOverlayOptions;
import de.quist.app.mapsabstraction.model.TileProvider;
import de.quist.app.mapsabstraction.model.UrlTileProvider;
import de.quist.app.mapsabstraction.model.VisibleRegion;

public interface MapImplementation {

    CameraUpdateFactory cameraUpdateFactory();

    CameraPosition cameraPosition(LatLng target, float zoom, float tilt, float bearing);

    CameraPosition cameraPositionFromLatLngZoom(LatLng target, float zoom);

    CameraPosition.IBuilder cameraPositionBuilder();

    CameraPosition.IBuilder cameraPositionBuilder(CameraPosition camera);

    CircleOptions circleOptions();

    GroundOverlayOptions groundOverlayOptions();

    LatLng latLng(double latitude, double longitude);

    LatLngBounds latLngBounds(LatLng southwest, LatLng northeast);

    LatLngBounds.IBuilder latLngBoundsBuilder();

    MarkerOptions markerOptions();

    PolygonOptions polygonOptions();

    PolylineOptions polylineOptions();

    TileOverlayOptions tileOverlayOptions();

    Tile tile(int width, int height, byte[] data);

    Tile noTile();

    VisibleRegion visibleRegion(LatLng nearLeft, LatLng nearRight, LatLng farLeft, LatLng farRight, LatLngBounds latLngBounds);

    BitmapDescriptorFactory bitmapDescriptorFactory();

    MapFragment mapFragmentFrom(Object fragment);

    MapView mapViewFrom(View view);

    Fragment newMapFragmentInstance();

    android.support.v4.app.Fragment newSupportMapFragmentInstance();

    TileProvider urlTileProvider(int width, int height, UrlTileProvider tileProvider);

}
