package de.quist.app.maps.google;

import android.app.Fragment;
import android.content.Context;
import android.view.View;

import com.google.android.gms.maps.MapView;

import java.net.URL;

import de.quist.app.maps.*;
import de.quist.app.maps.model.UrlTileProvider;
import de.quist.app.maps.model.TileProvider;


public class GoogleMapsBinding implements MapsBinding {

    public static final MapsBinding INSTANCE = new GoogleMapsBinding();

    private de.quist.app.maps.CameraUpdateFactory cameraUpdateFactory = new de.quist.app.maps.google.CameraUpdateFactory();
    private de.quist.app.maps.model.BitmapDescriptorFactory bitmapDescriptorFactory = new BitmapDescriptorFactory();

    private GoogleMapsBinding() {}

    private static final de.quist.app.maps.model.Tile NO_TILE = Tile.MAPPER.wrap(com.google.android.gms.maps.model.TileProvider.NO_TILE);

    @Override
    public de.quist.app.maps.CameraUpdateFactory cameraUpdateFactory() {
        return cameraUpdateFactory;
    }

    @Override
    public de.quist.app.maps.model.CameraPosition cameraPosition(de.quist.app.maps.model.LatLng target, float zoom, float tilt, float bearing) {
        return CameraPosition.MAPPER.wrap(new com.google.android.gms.maps.model.CameraPosition(LatLng.MAPPER.unwrap(target), zoom, tilt, bearing));
    }

    @Override
    public de.quist.app.maps.model.CameraPosition cameraPositionFromLatLngZoom(de.quist.app.maps.model.LatLng target, float zoom) {
        return CameraPosition.MAPPER.wrap(com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(LatLng.MAPPER.unwrap(target), zoom));
    }

    @Override
    public de.quist.app.maps.model.CameraPosition.IBuilder cameraPositionBuilder() {
        return new CameraPosition.Builder();
    }

    @Override
    public de.quist.app.maps.model.CameraPosition.IBuilder cameraPositionBuilder(de.quist.app.maps.model.CameraPosition camera) {
        return new CameraPosition.Builder(camera);
    }

    @Override
    public de.quist.app.maps.model.CircleOptions circleOptions() {
        return CircleOptions.MAPPER.wrap(new com.google.android.gms.maps.model.CircleOptions());
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions groundOverlayOptions() {
        return GroundOverlayOptions.MAPPER.wrap(new com.google.android.gms.maps.model.GroundOverlayOptions());
    }

    @Override
    public de.quist.app.maps.model.LatLng latLng(double latitude, double longitude) {
        return LatLng.MAPPER.wrap(new com.google.android.gms.maps.model.LatLng(latitude, longitude));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds latLngBounds(de.quist.app.maps.model.LatLng southwest, de.quist.app.maps.model.LatLng northeast) {
        return LatLngBounds.MAPPER.wrap(new com.google.android.gms.maps.model.LatLngBounds(LatLng.MAPPER.unwrap(southwest), LatLng.MAPPER.unwrap(northeast)));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds.IBuilder latLngBoundsBuilder() {
        return LatLngBounds.builder();
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions markerOptions() {
        return MarkerOptions.MAPPER.wrap(new com.google.android.gms.maps.model.MarkerOptions());
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions polygonOptions() {
        return PolygonOptions.MAPPER.wrap(new com.google.android.gms.maps.model.PolygonOptions());
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions polylineOptions() {
        return PolylineOptions.MAPPER.wrap(new com.google.android.gms.maps.model.PolylineOptions());
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions tileOverlayOptions() {
        return TileOverlayOptions.MAPPER.wrap(new com.google.android.gms.maps.model.TileOverlayOptions());
    }

    @Override
    public de.quist.app.maps.model.Tile tile(int width, int height, byte[] data) {
        return Tile.MAPPER.wrap(new com.google.android.gms.maps.model.Tile(width, height, data));
    }

    @Override
    public de.quist.app.maps.model.Tile noTile() {
        return NO_TILE;
    }

    @Override
    public de.quist.app.maps.model.VisibleRegion visibleRegion(de.quist.app.maps.model.LatLng nearLeft, de.quist.app.maps.model.LatLng nearRight, de.quist.app.maps.model.LatLng farLeft, de.quist.app.maps.model.LatLng farRight, de.quist.app.maps.model.LatLngBounds latLngBounds) {
        return VisibleRegion.MAPPER.wrap(new com.google.android.gms.maps.model.VisibleRegion(LatLng.MAPPER.unwrap(nearLeft), LatLng.MAPPER.unwrap(nearRight), LatLng.MAPPER.unwrap(farLeft), LatLng.MAPPER.unwrap(farRight), LatLngBounds.MAPPER.unwrap(latLngBounds)));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptorFactory bitmapDescriptorFactory() {
        return bitmapDescriptorFactory;
    }

    @Override
    public de.quist.app.maps.MapFragmentWrapper mapFragmentWrapperFrom(Object fragment) {
        if (fragment instanceof com.google.android.gms.maps.SupportMapFragment) {
            return SupportMapFragmentWrapper.MAPPER.wrap((com.google.android.gms.maps.SupportMapFragment) fragment);
        } else if (fragment instanceof com.google.android.gms.maps.MapFragment) {
            return MapFragmentWrapper.MAPPER.wrap((com.google.android.gms.maps.MapFragment) fragment);
        }
        return null;
    }

    @Override
    public MapViewWrapper mapViewWrapperFrom(View view) {
        if (view instanceof com.google.android.gms.maps.MapView) {
            return MapViewWrapper.MAPPER.wrap((com.google.android.gms.maps.MapView) view);
        }
        return null;
    }

    @Override
    public Fragment newMapFragmentInstance() {
        return com.google.android.gms.maps.MapFragment.newInstance();
    }

    @Override
    public Fragment newMapFragmentInstance(de.quist.app.maps.MapOptions options) {
        return com.google.android.gms.maps.MapFragment.newInstance(MapOptions.MAPPER.unwrap(options));
    }

    @Override
    public android.support.v4.app.Fragment newSupportMapFragmentInstance() {
        return com.google.android.gms.maps.SupportMapFragment.newInstance();
    }

    @Override
    public android.support.v4.app.Fragment newSupportMapFragmentInstance(de.quist.app.maps.MapOptions options) {
        return com.google.android.gms.maps.SupportMapFragment.newInstance(MapOptions.MAPPER.unwrap(options));
    }

    @Override
    public View newMapView(Context context) {
        return new MapView(context);
    }

    @Override
    public View newMapView(Context context, de.quist.app.maps.MapOptions mapOptions) {
        return new MapView(context, MapOptions.MAPPER.unwrap(mapOptions));
    }

    @Override
    public TileProvider urlTileProvider(int width, int height, final UrlTileProvider tileProvider) {
        return de.quist.app.maps.google.TileProvider.MAPPER.wrap(new com.google.android.gms.maps.model.UrlTileProvider(width, height) {

            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                return tileProvider.getTileUrl(x, y, zoom);
            }
        });
    }
}
