package de.quist.app.mapsabstraction.amazonmapswrapper;

import android.app.Fragment;
import android.view.View;

import java.net.URL;

import de.quist.app.mapsabstraction.MapFragment;
import de.quist.app.mapsabstraction.MapImplementation;
import de.quist.app.mapsabstraction.MapView;
import de.quist.app.mapsabstraction.model.*;


public class AmazonMapImplementation implements MapImplementation {

    public static final MapImplementation INSTANCE = new AmazonMapImplementation();

    private de.quist.app.mapsabstraction.CameraUpdateFactory cameraUpdateFactory = new CameraUpdateFactory();
    private de.quist.app.mapsabstraction.model.BitmapDescriptorFactory bitmapDescriptorFactory = new BitmapDescriptorFactory();

    private AmazonMapImplementation() {}

    private static final de.quist.app.mapsabstraction.model.Tile NO_TILE = Tile.wrap(com.amazon.geo.mapsv2.model.TileProvider.NO_TILE);

    @Override
    public de.quist.app.mapsabstraction.CameraUpdateFactory cameraUpdateFactory() {
        return cameraUpdateFactory;
    }

    @Override
    public de.quist.app.mapsabstraction.model.CameraPosition cameraPosition(de.quist.app.mapsabstraction.model.LatLng target, float zoom, float tilt, float bearing) {
        return CameraPosition.wrap(new com.amazon.geo.mapsv2.model.CameraPosition(LatLng.unwrap(target), zoom, tilt, bearing));
    }

    @Override
    public de.quist.app.mapsabstraction.model.CameraPosition cameraPositionFromLatLngZoom(de.quist.app.mapsabstraction.model.LatLng target, float zoom) {
        return CameraPosition.wrap(com.amazon.geo.mapsv2.model.CameraPosition.fromLatLngZoom(LatLng.unwrap(target), zoom));
    }

    @Override
    public de.quist.app.mapsabstraction.model.CameraPosition.IBuilder cameraPositionBuilder() {
        return new CameraPosition.Builder();
    }

    @Override
    public de.quist.app.mapsabstraction.model.CameraPosition.IBuilder cameraPositionBuilder(de.quist.app.mapsabstraction.model.CameraPosition camera) {
        return new CameraPosition.Builder(camera);
    }

    @Override
    public de.quist.app.mapsabstraction.model.CircleOptions circleOptions() {
        return CircleOptions.wrap(new com.amazon.geo.mapsv2.model.CircleOptions());
    }

    @Override
    public de.quist.app.mapsabstraction.model.GroundOverlayOptions groundOverlayOptions() {
        return GroundOverlayOptions.wrap(new com.amazon.geo.mapsv2.model.GroundOverlayOptions());
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLng latLng(double latitude, double longitude) {
        return LatLng.wrap(new com.amazon.geo.mapsv2.model.LatLng(latitude, longitude));
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLngBounds latLngBounds(de.quist.app.mapsabstraction.model.LatLng southwest, de.quist.app.mapsabstraction.model.LatLng northeast) {
        return LatLngBounds.wrap(new com.amazon.geo.mapsv2.model.LatLngBounds(LatLng.unwrap(southwest), LatLng.unwrap(northeast)));
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLngBounds.IBuilder latLngBoundsBuilder() {
        return LatLngBounds.builder();
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions markerOptions() {
        return MarkerOptions.wrap(new com.amazon.geo.mapsv2.model.MarkerOptions());
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolygonOptions polygonOptions() {
        return PolygonOptions.wrap(new com.amazon.geo.mapsv2.model.PolygonOptions());
    }

    @Override
    public de.quist.app.mapsabstraction.model.PolylineOptions polylineOptions() {
        return PolylineOptions.wrap(new com.amazon.geo.mapsv2.model.PolylineOptions());
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileOverlayOptions tileOverlayOptions() {
        return TileOverlayOptions.wrap(new com.amazon.geo.mapsv2.model.TileOverlayOptions());
    }

    @Override
    public de.quist.app.mapsabstraction.model.Tile tile(int width, int height, byte[] data) {
        return Tile.wrap(new com.amazon.geo.mapsv2.model.Tile(width, height, data));
    }

    @Override
    public de.quist.app.mapsabstraction.model.Tile noTile() {
        return NO_TILE;
    }

    @Override
    public de.quist.app.mapsabstraction.model.VisibleRegion visibleRegion(de.quist.app.mapsabstraction.model.LatLng nearLeft, de.quist.app.mapsabstraction.model.LatLng nearRight, de.quist.app.mapsabstraction.model.LatLng farLeft, de.quist.app.mapsabstraction.model.LatLng farRight, de.quist.app.mapsabstraction.model.LatLngBounds latLngBounds) {
        return VisibleRegion.wrap(new com.amazon.geo.mapsv2.model.VisibleRegion(LatLng.unwrap(nearLeft), LatLng.unwrap(nearRight), LatLng.unwrap(farLeft), LatLng.unwrap(farRight), LatLngBounds.unwrap(latLngBounds)));
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptorFactory bitmapDescriptorFactory() {
        return bitmapDescriptorFactory;
    }

    @Override
    public MapFragment mapFragmentFrom(Object fragment) {
        if (fragment instanceof com.amazon.geo.mapsv2.SupportMapFragment) {
            return SupportMapFragment.wrap((com.amazon.geo.mapsv2.SupportMapFragment) fragment);
        } else if (fragment instanceof com.amazon.geo.mapsv2.MapFragment) {
            return de.quist.app.mapsabstraction.amazonmapswrapper.MapFragment.wrap((com.amazon.geo.mapsv2.MapFragment) fragment);
        }
        return null;
    }

    @Override
    public MapView mapViewFrom(View view) {
        if (view instanceof com.amazon.geo.mapsv2.MapView) {
            return de.quist.app.mapsabstraction.amazonmapswrapper.MapView.wrap((com.amazon.geo.mapsv2.MapView) view);
        }
        return null;
    }

    @Override
    public Fragment newMapFragmentInstance() {
        return com.amazon.geo.mapsv2.MapFragment.newInstance();
    }

    @Override
    public android.support.v4.app.Fragment newSupportMapFragmentInstance() {
        return com.amazon.geo.mapsv2.SupportMapFragment.newInstance();
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileProvider urlTileProvider(int width, int height, final UrlTileProvider tileProvider) {
        return TileProvider.wrap(new com.amazon.geo.mapsv2.model.UrlTileProvider(width, height) {

            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                return tileProvider.getTileUrl(x, y, zoom);
            }
        });
    }
}
