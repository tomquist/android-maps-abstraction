package de.quist.app.maps.google;

import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;

import de.quist.app.maps.LocationSource;
import de.quist.app.maps.Map;
import de.quist.app.maps.utils.Wrapper;

class GoogleMap extends Wrapper<com.google.android.gms.maps.GoogleMap> implements Map {

    static final Mapper<Map, GoogleMap, com.google.android.gms.maps.GoogleMap> MAPPER = new DefaultMapper<Map, GoogleMap, com.google.android.gms.maps.GoogleMap>() {

        @Override
        public GoogleMap createWrapper(com.google.android.gms.maps.GoogleMap original) {
            return original != null ? new GoogleMap(original) : null;
        }
    };

    public GoogleMap(com.google.android.gms.maps.GoogleMap original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.CameraPosition getCameraPosition() {
        return CameraPosition.MAPPER.wrap(original.getCameraPosition());
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
    public void moveCamera(de.quist.app.maps.CameraUpdate update) {
        original.moveCamera(CameraUpdate.MAPPER.unwrap(update));
    }

    @Override
    public void animateCamera(de.quist.app.maps.CameraUpdate update) {
        original.animateCamera(CameraUpdate.MAPPER.unwrap(update));
    }

    @Override
    public void animateCamera(de.quist.app.maps.CameraUpdate update, final CancelableCallback callback) {
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
        original.animateCamera(CameraUpdate.MAPPER.unwrap(update), wrapperCallback);
    }

    @Override
    public void animateCamera(de.quist.app.maps.CameraUpdate update, int durationMs, final CancelableCallback callback) {
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
        original.animateCamera(CameraUpdate.MAPPER.unwrap(update), durationMs, wrapperCallback);
    }

    @Override
    public void stopAnimation() {
        original.stopAnimation();
    }

    @Override
    public de.quist.app.maps.model.Polyline addPolyline(de.quist.app.maps.model.PolylineOptions options) {
        return Polyline.MAPPER.wrap(original.addPolyline(PolylineOptions.MAPPER.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.Polygon addPolygon(de.quist.app.maps.model.PolygonOptions options) {
        return Polygon.MAPPER.wrap(original.addPolygon(PolygonOptions.MAPPER.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.Circle addCircle(de.quist.app.maps.model.CircleOptions options) {
        return Circle.MAPPER.wrap(original.addCircle(CircleOptions.MAPPER.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.Marker addMarker(de.quist.app.maps.model.MarkerOptions options) {
        return Marker.MAPPER.wrap(original.addMarker(MarkerOptions.MAPPER.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.GroundOverlay addGroundOverlay(de.quist.app.maps.model.GroundOverlayOptions options) {
        return GroundOverlay.MAPPER.wrap(original.addGroundOverlay(GroundOverlayOptions.MAPPER.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.TileOverlay addTileOverlay(de.quist.app.maps.model.TileOverlayOptions options) {
        return TileOverlay.MAPPER.wrap(original.addTileOverlay(TileOverlayOptions.MAPPER.unwrap(options)));
    }

    @Override
    public void clear() {
        original.clear();
    }

    @Override
    public de.quist.app.maps.model.IndoorBuilding getFocusedBuilding() {
        return IndoorBuilding.MAPPER.wrap(original.getFocusedBuilding());
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
                    listener.onIndoorLevelActivated(IndoorBuilding.MAPPER.wrap(indoorBuilding));
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
    public de.quist.app.maps.UiSettings getUiSettings() {
        return UiSettings.MAPPER.wrap(original.getUiSettings());
    }

    @Override
    public de.quist.app.maps.Projection getProjection() {
        return Projection.MAPPER.wrap(original.getProjection());
    }

    @Override
    public void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        com.google.android.gms.maps.GoogleMap.OnCameraChangeListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.google.android.gms.maps.GoogleMap.OnCameraChangeListener() {
                @Override
                public void onCameraChange(com.google.android.gms.maps.model.CameraPosition cameraPosition) {
                    listener.onCameraChange(CameraPosition.MAPPER.wrap(cameraPosition));
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
                    listener.onMapClick(LatLng.MAPPER.wrap(latLng));
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
                    listener.onMapLongClick(LatLng.MAPPER.wrap(latLng));
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
                    return listener.onMarkerClick(Marker.MAPPER.wrap(marker));
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
                    listener.onMarkerDragStart(Marker.MAPPER.wrap(marker));
                }

                @Override
                public void onMarkerDrag(com.google.android.gms.maps.model.Marker marker) {
                    listener.onMarkerDrag(Marker.MAPPER.wrap(marker));
                }

                @Override
                public void onMarkerDragEnd(com.google.android.gms.maps.model.Marker marker) {
                    listener.onMarkerDragEnd(Marker.MAPPER.wrap(marker));
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
                    listener.onInfoWindowClick(Marker.MAPPER.wrap(marker));
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
                    return adapter.getInfoWindow(Marker.MAPPER.wrap(marker));
                }

                @Override
                public View getInfoContents(com.google.android.gms.maps.model.Marker marker) {
                    return adapter.getInfoContents(Marker.MAPPER.wrap(marker));
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

}
