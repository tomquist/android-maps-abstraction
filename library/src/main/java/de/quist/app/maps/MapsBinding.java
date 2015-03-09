package de.quist.app.maps;

import android.app.Fragment;
import android.content.Context;
import android.view.View;

import de.quist.app.maps.model.BitmapDescriptorFactory;
import de.quist.app.maps.model.CameraPosition;
import de.quist.app.maps.model.CircleOptions;
import de.quist.app.maps.model.GroundOverlayOptions;
import de.quist.app.maps.model.LatLng;
import de.quist.app.maps.model.LatLngBounds;
import de.quist.app.maps.model.MarkerOptions;
import de.quist.app.maps.model.PolygonOptions;
import de.quist.app.maps.model.PolylineOptions;
import de.quist.app.maps.model.Tile;
import de.quist.app.maps.model.TileOverlayOptions;
import de.quist.app.maps.model.TileProvider;
import de.quist.app.maps.model.UrlTileProvider;
import de.quist.app.maps.model.VisibleRegion;

public interface MapsBinding {

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

    /**
     * Wraps the specified fragment.
     * @param fragment An instance of {@link android.app.Fragment} or {@link android.support.v4.app.Fragment}
     * @return A map fragment wrapper or null, if no map fragment has been passed.
     */
    MapFragmentWrapper mapFragmentWrapperFrom(Object fragment);

    MapViewWrapper mapViewWrapperFrom(View view);

    Fragment newMapFragmentInstance();

    Fragment newMapFragmentInstance(MapOptions options);

    android.support.v4.app.Fragment newSupportMapFragmentInstance();

    android.support.v4.app.Fragment newSupportMapFragmentInstance(MapOptions options);

    View newMapView(Context context);

    View newMapView(Context context, MapOptions mapOptions);

    TileProvider urlTileProvider(int width, int height, UrlTileProvider tileProvider);

}
