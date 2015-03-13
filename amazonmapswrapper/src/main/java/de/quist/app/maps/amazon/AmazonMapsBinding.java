package de.quist.app.maps.amazon;

import android.app.Fragment;
import android.content.Context;
import android.view.View;

import com.amazon.geo.mapsv2.MapView;

import java.net.URL;

import de.quist.app.maps.*;
import de.quist.app.maps.model.*;


public class AmazonMapsBinding implements MapsBinding {

    public static final MapsBinding INSTANCE = new AmazonMapsBinding();

    private de.quist.app.maps.CameraUpdateFactory cameraUpdateFactory = new CameraUpdateFactory();
    private de.quist.app.maps.model.BitmapDescriptorFactory bitmapDescriptorFactory = new de.quist.app.maps.amazon.BitmapDescriptorFactory();

    private AmazonMapsBinding() {}

    private static final de.quist.app.maps.model.Tile NO_TILE = de.quist.app.maps.amazon.Tile.MAPPER.wrap(com.amazon.geo.mapsv2.model.TileProvider.NO_TILE);

    @Override
    public de.quist.app.maps.CameraUpdateFactory cameraUpdateFactory() {
        return cameraUpdateFactory;
    }

    @Override
    public de.quist.app.maps.model.CameraPosition cameraPosition(de.quist.app.maps.model.LatLng target, float zoom, float tilt, float bearing) {
        return de.quist.app.maps.amazon.CameraPosition.MAPPER.wrap(new com.amazon.geo.mapsv2.model.CameraPosition(de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(target), zoom, tilt, bearing));
    }

    @Override
    public de.quist.app.maps.model.CameraPosition cameraPositionFromLatLngZoom(de.quist.app.maps.model.LatLng target, float zoom) {
        return de.quist.app.maps.amazon.CameraPosition.MAPPER.wrap(com.amazon.geo.mapsv2.model.CameraPosition.fromLatLngZoom(de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(target), zoom));
    }

    @Override
    public de.quist.app.maps.model.CameraPosition.IBuilder cameraPositionBuilder() {
        return new de.quist.app.maps.amazon.CameraPosition.Builder();
    }

    @Override
    public de.quist.app.maps.model.CameraPosition.IBuilder cameraPositionBuilder(de.quist.app.maps.model.CameraPosition camera) {
        return new de.quist.app.maps.amazon.CameraPosition.Builder(camera);
    }

    @Override
    public de.quist.app.maps.model.CircleOptions circleOptions() {
        return de.quist.app.maps.amazon.CircleOptions.MAPPER.wrap(new com.amazon.geo.mapsv2.model.CircleOptions());
    }

    @Override
    public de.quist.app.maps.model.GroundOverlayOptions groundOverlayOptions() {
        return de.quist.app.maps.amazon.GroundOverlayOptions.MAPPER.wrap(new com.amazon.geo.mapsv2.model.GroundOverlayOptions());
    }

    @Override
    public de.quist.app.maps.model.LatLng latLng(double latitude, double longitude) {
        return de.quist.app.maps.amazon.LatLng.MAPPER.wrap(new com.amazon.geo.mapsv2.model.LatLng(latitude, longitude));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds latLngBounds(de.quist.app.maps.model.LatLng southwest, de.quist.app.maps.model.LatLng northeast) {
        return de.quist.app.maps.amazon.LatLngBounds.MAPPER.wrap(new com.amazon.geo.mapsv2.model.LatLngBounds(de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(southwest), de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(northeast)));
    }

    @Override
    public de.quist.app.maps.model.LatLngBounds.IBuilder latLngBoundsBuilder() {
        return de.quist.app.maps.amazon.LatLngBounds.builder();
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions markerOptions() {
        return de.quist.app.maps.amazon.MarkerOptions.MAPPER.wrap(new com.amazon.geo.mapsv2.model.MarkerOptions());
    }

    @Override
    public de.quist.app.maps.model.PolygonOptions polygonOptions() {
        return de.quist.app.maps.amazon.PolygonOptions.MAPPER.wrap(new com.amazon.geo.mapsv2.model.PolygonOptions());
    }

    @Override
    public de.quist.app.maps.model.PolylineOptions polylineOptions() {
        return de.quist.app.maps.amazon.PolylineOptions.MAPPER.wrap(new com.amazon.geo.mapsv2.model.PolylineOptions());
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions tileOverlayOptions() {
        return de.quist.app.maps.amazon.TileOverlayOptions.MAPPER.wrap(new com.amazon.geo.mapsv2.model.TileOverlayOptions());
    }

    @Override
    public de.quist.app.maps.model.Tile tile(int width, int height, byte[] data) {
        return de.quist.app.maps.amazon.Tile.MAPPER.wrap(new com.amazon.geo.mapsv2.model.Tile(width, height, data));
    }

    @Override
    public de.quist.app.maps.model.Tile noTile() {
        return NO_TILE;
    }

    @Override
    public de.quist.app.maps.model.VisibleRegion visibleRegion(de.quist.app.maps.model.LatLng nearLeft, de.quist.app.maps.model.LatLng nearRight, de.quist.app.maps.model.LatLng farLeft, de.quist.app.maps.model.LatLng farRight, de.quist.app.maps.model.LatLngBounds latLngBounds) {
        return de.quist.app.maps.amazon.VisibleRegion.MAPPER.wrap(new com.amazon.geo.mapsv2.model.VisibleRegion(de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(nearLeft), de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(nearRight), de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(farLeft), de.quist.app.maps.amazon.LatLng.MAPPER.unwrap(farRight), de.quist.app.maps.amazon.LatLngBounds.MAPPER.unwrap(latLngBounds)));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptorFactory bitmapDescriptorFactory() {
        return bitmapDescriptorFactory;
    }

    @Override
    public de.quist.app.maps.MapFragmentWrapper mapFragmentWrapperFrom(Object fragment) {
        if (fragment instanceof com.amazon.geo.mapsv2.SupportMapFragment) {
            return SupportMapFragmentWrapper.MAPPER.wrap((com.amazon.geo.mapsv2.SupportMapFragment) fragment);
        } else if (fragment instanceof com.amazon.geo.mapsv2.MapFragment) {
            return de.quist.app.maps.amazon.MapFragmentWrapper.MAPPER.wrap((com.amazon.geo.mapsv2.MapFragment) fragment);
        }
        return null;
    }

    @Override
    public MapViewWrapper mapViewWrapperFrom(View view) {
        if (view instanceof com.amazon.geo.mapsv2.MapView) {
            return MapViewWrapper.MAPPER.wrap((com.amazon.geo.mapsv2.MapView) view);
        }
        return null;
    }

    @Override
    public Fragment newMapFragmentInstance() {
        return com.amazon.geo.mapsv2.MapFragment.newInstance();
    }

    @Override
    public Fragment newMapFragmentInstance(de.quist.app.maps.MapOptions options) {
        return com.amazon.geo.mapsv2.MapFragment.newInstance(MapOptions.MAPPER.unwrap(options));
    }

    @Override
    public android.support.v4.app.Fragment newSupportMapFragmentInstance() {
        return com.amazon.geo.mapsv2.SupportMapFragment.newInstance();
    }

    @Override
    public android.support.v4.app.Fragment newSupportMapFragmentInstance(de.quist.app.maps.MapOptions options) {
        return com.amazon.geo.mapsv2.SupportMapFragment.newInstance(MapOptions.MAPPER.unwrap(options));
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
    public de.quist.app.maps.model.TileProvider urlTileProvider(int width, int height, final UrlTileProvider tileProvider) {
        return de.quist.app.maps.amazon.TileProvider.MAPPER.wrap(new com.amazon.geo.mapsv2.model.UrlTileProvider(width, height) {

            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                return tileProvider.getTileUrl(x, y, zoom);
            }
        });
    }
}
