package de.quist.app.maps;

import android.graphics.Bitmap;
import android.view.View;

import de.quist.app.maps.model.CameraPosition;
import de.quist.app.maps.model.Circle;
import de.quist.app.maps.model.CircleOptions;
import de.quist.app.maps.model.GroundOverlay;
import de.quist.app.maps.model.GroundOverlayOptions;
import de.quist.app.maps.model.IndoorBuilding;
import de.quist.app.maps.model.LatLng;
import de.quist.app.maps.model.Marker;
import de.quist.app.maps.model.MarkerOptions;
import de.quist.app.maps.model.Polygon;
import de.quist.app.maps.model.PolygonOptions;
import de.quist.app.maps.model.Polyline;
import de.quist.app.maps.model.PolylineOptions;
import de.quist.app.maps.model.TileOverlay;
import de.quist.app.maps.model.TileOverlayOptions;

public interface Map {

    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    public static final int MAP_TYPE_HYBRID = 4;

    CameraPosition getCameraPosition();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    void moveCamera(CameraUpdate update);

    void animateCamera(CameraUpdate update);

    void animateCamera(CameraUpdate update, CancelableCallback callback);

    void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback);

    void stopAnimation();

    Polyline addPolyline(PolylineOptions options);

    Polygon addPolygon(PolygonOptions options);

    Circle addCircle(CircleOptions options);

    Marker addMarker(MarkerOptions options);

    GroundOverlay addGroundOverlay(GroundOverlayOptions options);

    TileOverlay addTileOverlay(TileOverlayOptions options);

    void clear();

    IndoorBuilding getFocusedBuilding();

    void setOnIndoorStateChangeListener(OnIndoorStateChangeListener listener);

    int getMapType();

    void setMapType(int type);

    boolean isTrafficEnabled();

    void setTrafficEnabled(boolean enabled);

    boolean isIndoorEnabled();

    boolean setIndoorEnabled(boolean enabled);

    boolean isBuildingsEnabled();

    void setBuildingsEnabled(boolean enabled);

    boolean isMyLocationEnabled();

    void setMyLocationEnabled(boolean enabled);

    void setLocationSource(LocationSource source);

    UiSettings getUiSettings();

    Projection getProjection();

    void setOnCameraChangeListener(OnCameraChangeListener listener);

    void setOnMapClickListener(OnMapClickListener listener);

    void setOnMapLongClickListener(OnMapLongClickListener listener);

    void setOnMarkerClickListener(OnMarkerClickListener listener);

    void setOnMarkerDragListener(OnMarkerDragListener listener);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener listener);

    void setInfoWindowAdapter(InfoWindowAdapter adapter);

    void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener);

    void setOnMapLoadedCallback(OnMapLoadedCallback callback);

    void snapshot(SnapshotReadyCallback callback);

    void snapshot(SnapshotReadyCallback callback, Bitmap bitmap);

    void setPadding(int left, int top, int right, int bottom);

    void setContentDescription(String description);

    public static interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public static interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    public static interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);

        View getInfoContents(Marker marker);
    }

    public static interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public static interface CancelableCallback {
        void onFinish();

        void onCancel();
    }

    public static interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public static interface OnMarkerDragListener {
        void onMarkerDragStart(Marker marker);

        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);
    }

    public static interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public static interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public static interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public static interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public static interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

}
