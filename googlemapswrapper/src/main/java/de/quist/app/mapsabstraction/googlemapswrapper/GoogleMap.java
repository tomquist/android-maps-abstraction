package de.quist.app.mapsabstraction.googlemapswrapper;

import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;

import de.quist.app.mapsabstraction.LocationSource;
import de.quist.app.mapsabstraction.Map;

class GoogleMap implements Map {

    public static com.google.android.gms.maps.GoogleMap unwrap(Map map) {
        return map != null ? ((GoogleMap)map).original : null;
    }

    public static GoogleMap wrap(com.google.android.gms.maps.GoogleMap map) {
        return map != null ? new GoogleMap(map) : null;
    }

    private final com.google.android.gms.maps.GoogleMap original;

    GoogleMap(com.google.android.gms.maps.GoogleMap original) {
        this.original = original;
    }

    @Override
    public de.quist.app.mapsabstraction.model.CameraPosition getCameraPosition() {
        return CameraPosition.wrap(original.getCameraPosition());
    }

    @Override
    public float getMaxZoomLevel() {
        return original.getMaxZoomLevel();
    }

    @Override
    public float getMinZoomLevel() {
        return original.getMinZoomLevel();
    }

    @Override
    public void moveCamera(de.quist.app.mapsabstraction.CameraUpdate update) {
        original.moveCamera(CameraUpdate.unwrap(update));
    }

    @Override
    public void animateCamera(de.quist.app.mapsabstraction.CameraUpdate update) {
        original.animateCamera(CameraUpdate.unwrap(update));
    }

    @Override
    public void animateCamera(de.quist.app.mapsabstraction.CameraUpdate update, final CancelableCallback callback) {
        com.google.android.gms.maps.GoogleMap.CancelableCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.google.android.gms.maps.GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    callback.onFinish();
                }

                @Override
                public void onCancel() {
                    callback.onCancel();
                }
            };
        }
        original.animateCamera(CameraUpdate.unwrap(update), wrapperCallback);
    }

    @Override
    public void animateCamera(de.quist.app.mapsabstraction.CameraUpdate update, int durationMs, final CancelableCallback callback) {
        com.google.android.gms.maps.GoogleMap.CancelableCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.google.android.gms.maps.GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    callback.onFinish();
                }

                @Override
                public void onCancel() {
                    callback.onCancel();
                }
            };
        }
        original.animateCamera(CameraUpdate.unwrap(update), durationMs, wrapperCallback);
    }

    @Override
    public void stopAnimation() {
        original.stopAnimation();
    }

    @Override
    public de.quist.app.mapsabstraction.model.Polyline addPolyline(de.quist.app.mapsabstraction.model.PolylineOptions options) {
        return Polyline.wrap(original.addPolyline(PolylineOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.mapsabstraction.model.Polygon addPolygon(de.quist.app.mapsabstraction.model.PolygonOptions options) {
        return Polygon.wrap(original.addPolygon(PolygonOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.mapsabstraction.model.Circle addCircle(de.quist.app.mapsabstraction.model.CircleOptions options) {
        return Circle.wrap(original.addCircle(CircleOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.mapsabstraction.model.Marker addMarker(de.quist.app.mapsabstraction.model.MarkerOptions options) {
        return Marker.wrap(original.addMarker(MarkerOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.mapsabstraction.model.GroundOverlay addGroundOverlay(de.quist.app.mapsabstraction.model.GroundOverlayOptions options) {
        return GroundOverlay.wrap(original.addGroundOverlay(GroundOverlayOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileOverlay addTileOverlay(de.quist.app.mapsabstraction.model.TileOverlayOptions options) {
        return TileOverlay.wrap(original.addTileOverlay(TileOverlayOptions.unwrap(options)));
    }

    @Override
    public void clear() {
        original.clear();
    }

    @Override
    public de.quist.app.mapsabstraction.model.IndoorBuilding getFocusedBuilding() {
        return IndoorBuilding.wrap(original.getFocusedBuilding());
    }

    @Override
    public void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnIndoorStateChangeListener() {
                @Override
                public void onIndoorBuildingFocused() {
                    listener.onIndoorBuildingFocused();
                }

                @Override
                public void onIndoorLevelActivated(com.google.android.gms.maps.model.IndoorBuilding indoorBuilding) {
                    listener.onIndoorLevelActivated(IndoorBuilding.wrap(indoorBuilding));
                }
            };
        }
        original.setOnIndoorStateChangeListener(wrapperListener);
    }

    @Override
    public int getMapType() {
        return original.getMapType();
    }

    @Override
    public void setMapType(int type) {
        original.setMapType(type);
    }

    @Override
    public boolean isTrafficEnabled() {
        return original.isTrafficEnabled();
    }

    @Override
    public void setTrafficEnabled(boolean enabled) {
        original.setTrafficEnabled(enabled);
    }

    @Override
    public boolean isIndoorEnabled() {
        return original.isIndoorEnabled();
    }

    @Override
    public boolean setIndoorEnabled(boolean enabled) {
        return original.setIndoorEnabled(enabled);
    }

    @Override
    public boolean isBuildingsEnabled() {
        return original.isBuildingsEnabled();
    }

    @Override
    public void setBuildingsEnabled(boolean enabled) {
        original.setBuildingsEnabled(enabled);
    }

    @Override
    public boolean isMyLocationEnabled() {
        return original.isMyLocationEnabled();
    }

    @Override
    public void setMyLocationEnabled(boolean enabled) {
        original.setMyLocationEnabled(enabled);
    }

    @Override
    public void setLocationSource(final LocationSource source) {
        original.setLocationSource(new com.google.android.gms.maps.LocationSource() {
            @Override
            public void activate(final OnLocationChangedListener onLocationChangedListener) {
                if (onLocationChangedListener != null) {
                    source.activate(new LocationSource.OnLocationChangedListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            onLocationChangedListener.onLocationChanged(location);
                        }
                    });
                } else {
                    source.activate(null);
                }
            }

            @Override
            public void deactivate() {
                source.deactivate();
            }
        });
    }

    @Override
    public de.quist.app.mapsabstraction.UiSettings getUiSettings() {
        return UiSettings.wrap(original.getUiSettings());
    }

    @Override
    public de.quist.app.mapsabstraction.Projection getProjection() {
        return Projection.wrap(original.getProjection());
    }

    @Override
    public void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        com.google.android.gms.maps.GoogleMap.OnCameraChangeListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnCameraChangeListener() {
                @Override
                public void onCameraChange(com.google.android.gms.maps.model.CameraPosition cameraPosition) {
                    listener.onCameraChange(CameraPosition.wrap(cameraPosition));
                }
            };
        }
        original.setOnCameraChangeListener(wrapperListener);
    }

    @Override
    public void setOnMapClickListener(final OnMapClickListener listener) {
        com.google.android.gms.maps.GoogleMap.OnMapClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnMapClickListener() {

                @Override
                public void onMapClick(com.google.android.gms.maps.model.LatLng latLng) {
                    listener.onMapClick(LatLng.wrap(latLng));
                }
            };
        }
        original.setOnMapClickListener(wrapperListener);
    }

    @Override
    public void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        com.google.android.gms.maps.GoogleMap.OnMapLongClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnMapLongClickListener() {

                @Override
                public void onMapLongClick(com.google.android.gms.maps.model.LatLng latLng) {
                    listener.onMapLongClick(LatLng.wrap(latLng));
                }
            };
        }
        original.setOnMapLongClickListener(wrapperListener);
    }

    @Override
    public void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        com.google.android.gms.maps.GoogleMap.OnMarkerClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnMarkerClickListener() {

                @Override
                public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {
                    return listener.onMarkerClick(Marker.wrap(marker));
                }
            };
        }
        original.setOnMarkerClickListener(wrapperListener);
    }

    @Override
    public void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        com.google.android.gms.maps.GoogleMap.OnMarkerDragListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnMarkerDragListener() {

                @Override
                public void onMarkerDragStart(com.google.android.gms.maps.model.Marker marker) {
                    listener.onMarkerDragStart(Marker.wrap(marker));
                }

                @Override
                public void onMarkerDrag(com.google.android.gms.maps.model.Marker marker) {
                    listener.onMarkerDrag(Marker.wrap(marker));
                }

                @Override
                public void onMarkerDragEnd(com.google.android.gms.maps.model.Marker marker) {
                    listener.onMarkerDragEnd(Marker.wrap(marker));
                }
            };
        }
        original.setOnMarkerDragListener(wrapperListener);
    }

    @Override
    public void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {

                @Override
                public void onInfoWindowClick(com.google.android.gms.maps.model.Marker marker) {
                    listener.onInfoWindowClick(Marker.wrap(marker));
                }
            };
        }
        original.setOnInfoWindowClickListener(wrapperListener);
    }

    @Override
    public void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        com.google.android.gms.maps.GoogleMap.InfoWindowAdapter wrapperAdapter = null;
        if (adapter != null) {
            wrapperAdapter = new com.google.android.gms.maps.GoogleMap.InfoWindowAdapter() {

                @Override
                public View getInfoWindow(com.google.android.gms.maps.model.Marker marker) {
                    return adapter.getInfoWindow(Marker.wrap(marker));
                }

                @Override
                public View getInfoContents(com.google.android.gms.maps.model.Marker marker) {
                    return adapter.getInfoContents(Marker.wrap(marker));
                }
            };
        }
        original.setInfoWindowAdapter(wrapperAdapter);
    }

    @Override
    public void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener() {

                @Override
                public boolean onMyLocationButtonClick() {
                    return listener.onMyLocationButtonClick();
                }
            };
        }
        original.setOnMyLocationButtonClickListener(wrapperListener);
    }

    @Override
    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback() {

                @Override
                public void onMapLoaded() {
                    callback.onMapLoaded();
                }
            };
        }
        original.setOnMapLoadedCallback(wrapperCallback);
    }

    @Override
    public void snapshot(final SnapshotReadyCallback callback) {
        com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback() {

                @Override
                public void onSnapshotReady(Bitmap bitmap) {
                    callback.onSnapshotReady(bitmap);
                }
            };
        }
        original.snapshot(wrapperCallback);
    }

    @Override
    public void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback() {

                @Override
                public void onSnapshotReady(Bitmap bitmap) {
                    callback.onSnapshotReady(bitmap);
                }
            };
        }
        original.snapshot(wrapperCallback, bitmap);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        original.setPadding(left, top, right, bottom);
    }

    @Override
    public void setContentDescription(String description) {
        original.setContentDescription(description);
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GoogleMap)) {
            return false;
        }

        GoogleMap other = (GoogleMap)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }

}
