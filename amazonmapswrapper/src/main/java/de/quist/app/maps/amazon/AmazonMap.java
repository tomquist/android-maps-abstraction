package de.quist.app.maps.amazon;

import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;

import de.quist.app.maps.LocationSource;
import de.quist.app.maps.Map;
import de.quist.app.maps.utils.Wrapper;

class AmazonMap extends Wrapper<com.amazon.geo.mapsv2.AmazonMap> implements Map {

    static final Mapper<Map, AmazonMap, com.amazon.geo.mapsv2.AmazonMap> MAPPER = new DefaultMapper<Map, AmazonMap, com.amazon.geo.mapsv2.AmazonMap>() {

        @Override
        public AmazonMap createWrapper(com.amazon.geo.mapsv2.AmazonMap original) {
            return original != null ? new AmazonMap(original) : null;
        }
    };

    public AmazonMap(com.amazon.geo.mapsv2.AmazonMap original) {
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
        original.animateCamera(CameraUpdate.MAPPER.unwrap(update), wrapperCallback);
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
        com.amazon.geo.mapsv2.AmazonMap.OnIndoorStateChangeListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnIndoorStateChangeListener() {

                @Override
                public void onIndoorBuildingsFocused() {
                    listener.onIndoorBuildingFocused();
                }

                @Override
                public void onIndoorLevelActivated(com.amazon.geo.mapsv2.model.IndoorBuilding indoorBuilding) {
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
        return UiSettings.MAPPER.wrap(original.getUiSettings());
    }

    @Override
    public de.quist.app.maps.Projection getProjection() {
        return Projection.MAPPER.wrap(original.getProjection());
    }

    @Override
    public void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        com.amazon.geo.mapsv2.AmazonMap.OnCameraChangeListener wrapperListener = null;
        if (listener != null) {
            wrapperListener = new com.amazon.geo.mapsv2.AmazonMap.OnCameraChangeListener() {
                @Override
                public void onCameraChange(com.amazon.geo.mapsv2.model.CameraPosition cameraPosition) {
                    listener.onCameraChange(CameraPosition.MAPPER.wrap(cameraPosition));
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
                    listener.onMapClick(LatLng.MAPPER.wrap(latLng));
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
                    listener.onMapLongClick(LatLng.MAPPER.wrap(latLng));
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
                    return listener.onMarkerClick(Marker.MAPPER.wrap(marker));
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
                    listener.onMarkerDragStart(Marker.MAPPER.wrap(marker));
                }

                @Override
                public void onMarkerDrag(com.amazon.geo.mapsv2.model.Marker marker) {
                    listener.onMarkerDrag(Marker.MAPPER.wrap(marker));
                }

                @Override
                public void onMarkerDragEnd(com.amazon.geo.mapsv2.model.Marker marker) {
                    listener.onMarkerDragEnd(Marker.MAPPER.wrap(marker));
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
                    listener.onInfoWindowClick(Marker.MAPPER.wrap(marker));
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
                    return adapter.getInfoWindow(Marker.MAPPER.wrap(marker));
                }

                @Override
                public View getInfoContents(com.amazon.geo.mapsv2.model.Marker marker) {
                    return adapter.getInfoContents(Marker.MAPPER.wrap(marker));
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

}
