package de.quist.app.maps;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import de.quist.app.maps.utils.LayoutUtils;

public class MapView extends FrameLayout implements MapViewWrapper {

    private View mMapView;
    private MapViewWrapper mMapViewWrapper;

    public MapView(Context context, MapsBinding binding) {
        super(context);
        mMapView = binding.newMapView(context);
        mMapViewWrapper = binding.mapViewWrapperFrom(mMapView);
        initializeMapView();
    }

    public MapView(Context context, MapsBinding binding, MapOptions mapOptions) {
        super(context);
        mMapView = binding.newMapView(context, mapOptions);
        mMapViewWrapper = binding.mapViewWrapperFrom(mMapView);
        initializeMapView();
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs, 0, 0);
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initialize(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        MapsBinding binding = LayoutUtils.resolveMapsBindingFromAttributes(context, attrs, defStyleAttr, defStyleRes);
        if (binding != null) {
            MapOptions options = LayoutUtils.mapOptionsCreateFromAttributes(binding, context, attrs);
            mMapView = binding.newMapView(context, options);
            mMapViewWrapper = binding.mapViewWrapperFrom(mMapView);
            initializeMapView();
        } else {
            throw new IllegalArgumentException("Could not get maps binding. Specify a valid attribute app:abs_binding pointing to a MapsBinding class or static field");
        }
    }

    private void initializeMapView() {
        this.addView(mMapView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public Map getMap() {
        return mMapViewWrapper.getMap();
    }

    @Override
    public void getMapAsync(OnMapReadyCallback callback) {
        mMapViewWrapper.getMapAsync(callback);
    }

    @Override
    public View getView() {
        return mMapViewWrapper.getView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mMapViewWrapper.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        mMapViewWrapper.onResume();
    }

    @Override
    public void onPause() {
        mMapViewWrapper.onPause();
    }

    @Override
    public void onDestroy() {
        mMapViewWrapper.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mMapViewWrapper.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mMapViewWrapper.onSaveInstanceState(outState);
    }
}
