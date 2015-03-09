package de.quist.app.maps.amazon;

import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;

import de.quist.app.maps.LocationSource;
import de.quist.app.maps.Map;

class AmazonMap implements Map {

    public static com.amazon.geo.mapsv2.AmazonMap unwrap(Map map) {
        return map != null ? ((AmazonMap)map).original : null;
    }

    public static AmazonMap wrap(com.amazon.geo.mapsv2.AmazonMap map) {
        return map != null ? new AmazonMap(map) : null;
    }

    private final com.amazon.geo.mapsv2.AmazonMap original;

    public AmazonMap(com.amazon.geo.mapsv2.AmazonMap original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.CameraPosition getCameraPosition() {
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
    public void moveCamera(de.quist.app.maps.CameraUpdate update) {
        original.moveCamera(CameraUpdate.unwrap(update));
    }

    @Override
    public void animateCamera(de.quist.app.maps.CameraUpdate update) {
        original.animateCamera(CameraUpdate.unwrap(update));
    }

    @Override
    public void animateCamera(de.quist.app.maps.CameraUpdate update, final CancelableCallback callback) {
        com.amazon.geo.mapsv2.AmazonMap.CancelableCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.amazon.geo.mapsv2.AmazonMap.CancelableCallback() {
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
    public void animateCamera(de.quist.app.maps.CameraUpdate update, int durationMs, final CancelableCallback callback) {
        com.amazon.geo.mapsv2.AmazonMap.CancelableCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.amazon.geo.mapsv2.AmazonMap.CancelableCallback() {
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
    public de.quist.app.maps.model.Polyline addPolyline(de.quist.app.maps.model.PolylineOptions options) {
        return Polyline.wrap(original.addPolyline(PolylineOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.Polygon addPolygon(de.quist.app.maps.model.PolygonOptions options) {
        return Polygon.wrap(original.addPolygon(PolygonOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.Circle addCircle(de.quist.app.maps.model.CircleOptions options) {
        return Circle.wrap(original.addCircle(CircleOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.Marker addMarker(de.quist.app.maps.model.MarkerOptions options) {
        return Marker.wrap(original.addMarker(MarkerOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.GroundOverlay addGroundOverlay(de.quist.app.maps.model.GroundOverlayOptions options) {
        return GroundOverlay.wrap(original.addGroundOverlay(GroundOverlayOptions.unwrap(options)));
    }

    @Override
    public de.quist.app.maps.model.TileOverlay addTileOverlay(de.quist.app.maps.model.TileOverlayOptions options) {
        return TileOverlay.wrap(original.addTileOverlay(TileOverlayOptions.unwrap(options)));
    }

    @Override
    public void clear() {
        original.clear();
    }

    @Override
    public de.quist.app.maps.model.IndoorBuilding getFocusedBuilding() {
        return IndoorBuilding.wrap(original.getFocusedBuilding());
    }

    @Override
    public void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnIndoorStateChangeListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnIndoorStateChangeListener() {

                @Override
                public void onIndoorBuildingsFocused() {
                    listener.onIndoorBuildingFocused();
                }

                @Override
                public void onIndoorLevelActivated(com.amazon.geo.mapsv2.model.IndoorBuilding indoorBuilding) {
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
        original.setLocationSource(new com.amazon.geo.mapsv2.LocationSource() {
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
        return UiSettings.wrap(original.getUiSettings());
    }

    @Override
    public de.quist.app.maps.Projection getProjection() {
        return Projection.wrap(original.getProjection());
    }

    @Override
    public void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnCameraChangeListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnCameraChangeListener() {
                @Override
                public void onCameraChange(com.amazon.geo.mapsv2.model.CameraPosition cameraPosition) {
                    listener.onCameraChange(CameraPosition.wrap(cameraPosition));
                }
            };
        }
        original.setOnCameraChangeListener(wrapperListener);
    }

    @Override
    public void setOnMapClickListener(final OnMapClickListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnMapClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnMapClickListener() {

                @Override
                public void onMapClick(com.amazon.geo.mapsv2.model.LatLng latLng) {
                    listener.onMapClick(LatLng.wrap(latLng));
                }
            };
        }
        original.setOnMapClickListener(wrapperListener);
    }

    @Override
    public void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnMapLongClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnMapLongClickListener() {

                @Override
                public void onMapLongClick(com.amazon.geo.mapsv2.model.LatLng latLng) {
                    listener.onMapLongClick(LatLng.wrap(latLng));
                }
            };
        }
        original.setOnMapLongClickListener(wrapperListener);
    }

    @Override
    public void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnMarkerClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnMarkerClickListener() {

                @Override
                public boolean onMarkerClick(com.amazon.geo.mapsv2.model.Marker marker) {
                    return listener.onMarkerClick(Marker.wrap(marker));
                }
            };
        }
        original.setOnMarkerClickListener(wrapperListener);
    }

    @Override
    public void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnMarkerDragListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnMarkerDragListener() {

                @Override
                public void onMarkerDragStart(com.amazon.geo.mapsv2.model.Marker marker) {
                    listener.onMarkerDragStart(Marker.wrap(marker));
                }

                @Override
                public void onMarkerDrag(com.amazon.geo.mapsv2.model.Marker marker) {
                    listener.onMarkerDrag(Marker.wrap(marker));
                }

                @Override
                public void onMarkerDragEnd(com.amazon.geo.mapsv2.model.Marker marker) {
                    listener.onMarkerDragEnd(Marker.wrap(marker));
                }
            };
        }
        original.setOnMarkerDragListener(wrapperListener);
    }

    @Override
    public void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnInfoWindowClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnInfoWindowClickListener() {

                @Override
                public void onInfoWindowClick(com.amazon.geo.mapsv2.model.Marker marker) {
                    listener.onInfoWindowClick(Marker.wrap(marker));
                }
            };
        }
        original.setOnInfoWindowClickListener(wrapperListener);
    }

    @Override
    public void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        com.amazon.geo.mapsv2.AmazonMap.InfoWindowAdapter wrapperAdapter = null;
        if (adapter != null) {
            wrapperAdapter = new com.amazon.geo.mapsv2.AmazonMap.InfoWindowAdapter() {

                @Override
                public View getInfoWindow(com.amazon.geo.mapsv2.model.Marker marker) {
                    return adapter.getInfoWindow(Marker.wrap(marker));
                }

                @Override
                public View getInfoContents(com.amazon.geo.mapsv2.model.Marker marker) {
                    return adapter.getInfoContents(Marker.wrap(marker));
                }
            };
        }
        original.setInfoWindowAdapter(wrapperAdapter);
    }

    @Override
    public void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnMyLocationButtonClickListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnMyLocationButtonClickListener() {

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
        com.amazon.geo.mapsv2.AmazonMap.OnMapLoadedCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.amazon.geo.mapsv2.AmazonMap.OnMapLoadedCallback() {

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
        com.amazon.geo.mapsv2.AmazonMap.SnapshotReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.amazon.geo.mapsv2.AmazonMap.SnapshotReadyCallback() {

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
        com.amazon.geo.mapsv2.AmazonMap.SnapshotReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.amazon.geo.mapsv2.AmazonMap.SnapshotReadyCallback() {

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
        // Not available
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AmazonMap)) {
            return false;
        }

        AmazonMap other = (AmazonMap)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }
}
