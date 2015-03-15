package de.quist.app.maps.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import de.quist.app.maps.MapOptions;
import de.quist.app.maps.MapsBinding;
import de.quist.app.maps.R;
import de.quist.app.maps.model.CameraPosition;
import de.quist.app.maps.model.LatLng;

public final class LayoutUtils {

    private static final String TAG = LayoutUtils.class.getSimpleName();

    public static MapsBinding resolveMapsBindingFromAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRef) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.AbsMapAttrs,
                defStyleAttr,
                defStyleRef);
        try {
            String bindingClassName = a.getString(R.styleable.AbsMapAttrs_abs_binding);
            return MapsBindingResolver.resolve(bindingClassName);
        } finally {
            a.recycle();
        }
    }

    public static MapOptions mapOptionsCreateFromAttributes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRef) {
        MapsBinding binding = resolveMapsBindingFromAttributes(context, attrs, defStyleAttr, defStyleRef);
        if (binding != null) {
            return mapOptionsCreateFromAttributes(binding, context, attrs);
        }
        return null;
    }

    public static MapOptions mapOptionsCreateFromAttributes(MapsBinding binding, Context context, AttributeSet attrs) {
        TypedArray a = context.getResources().obtainAttributes(
                attrs,
                R.styleable.AbsMapAttrs);
        try {
            MapOptions options = binding.newMapOptions();

            if(a.hasValue(R.styleable.AbsMapAttrs_abs_mapType))
                options.mapType(a.getInt(R.styleable.AbsMapAttrs_abs_mapType, -1));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_zOrderOnTop))
                options.zOrderOnTop(a.getBoolean(R.styleable.AbsMapAttrs_abs_zOrderOnTop, false));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_useViewLifecycle))
                options.useViewLifecycleInFragment(a.getBoolean(R.styleable.AbsMapAttrs_abs_useViewLifecycle, false));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_uiCompass))
                options.compassEnabled(a.getBoolean(R.styleable.AbsMapAttrs_abs_uiCompass, true));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_uiRotateGestures))
                options.rotateGesturesEnabled(a.getBoolean(R.styleable.AbsMapAttrs_abs_uiRotateGestures, true));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_uiScrollGestures))
                options.scrollGesturesEnabled(a.getBoolean(R.styleable.AbsMapAttrs_abs_uiScrollGestures, true));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_uiTiltGestures))
                options.tiltGesturesEnabled(a.getBoolean(R.styleable.AbsMapAttrs_abs_uiTiltGestures, true));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_uiZoomGestures))
                options.zoomGesturesEnabled(a.getBoolean(R.styleable.AbsMapAttrs_abs_uiZoomGestures, true));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_uiZoomControls))
                options.zoomControlsEnabled(a.getBoolean(R.styleable.AbsMapAttrs_abs_uiZoomControls, true));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_liteMode))
                options.liteMode(a.getBoolean(R.styleable.AbsMapAttrs_abs_liteMode, false));
            if(a.hasValue(R.styleable.AbsMapAttrs_abs_uiMapToolbar))
                options.mapToolbarEnabled(a.getBoolean(R.styleable.AbsMapAttrs_abs_uiMapToolbar, true));

            CameraPosition cameraPosition = cameraPositionCreateFromAttributes(binding, context, attrs);
            options.camera(cameraPosition);

            return options;
        } finally {
            a.recycle();
        }
    }

    public static CameraPosition cameraPositionCreateFromAttributes(MapsBinding binding, Context context, AttributeSet attrs) {
        if(attrs == null)
            return null;
        TypedArray typedarray = context.getResources().obtainAttributes(
                attrs,
                R.styleable.AbsMapAttrs);

        try {
            float lat = 0.0F;
            float lng = 0.0F;
            if (typedarray.hasValue(R.styleable.AbsMapAttrs_abs_cameraTargetLat))
                lat = typedarray.getFloat(R.styleable.AbsMapAttrs_abs_cameraTargetLat, 0.0F);
            if (typedarray.hasValue(R.styleable.AbsMapAttrs_abs_cameraTargetLng))
                lng = typedarray.getFloat(R.styleable.AbsMapAttrs_abs_cameraTargetLng, 0.0F);

            LatLng latlng = binding.newLatLng(lat, lng);
            CameraPosition.IBuilder cameraPosBuilder = binding.cameraPositionBuilder();
            cameraPosBuilder.target(latlng);
            if (typedarray.hasValue(R.styleable.AbsMapAttrs_abs_cameraZoom))
                cameraPosBuilder.zoom(typedarray.getFloat(R.styleable.AbsMapAttrs_abs_cameraZoom, 0.0F));
            if (typedarray.hasValue(R.styleable.AbsMapAttrs_abs_cameraBearing))
                cameraPosBuilder.bearing(typedarray.getFloat(R.styleable.AbsMapAttrs_abs_cameraBearing, 0.0F));
            if (typedarray.hasValue(R.styleable.AbsMapAttrs_abs_cameraTilt))
                cameraPosBuilder.tilt(typedarray.getFloat(R.styleable.AbsMapAttrs_abs_cameraTilt, 0.0F));
            return cameraPosBuilder.build();
        } finally {
            typedarray.recycle();
        }
    }
}

