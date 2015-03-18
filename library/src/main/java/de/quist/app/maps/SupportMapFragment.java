package de.quist.app.maps;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.quist.app.maps.utils.LayoutUtils;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class SupportMapFragment extends Fragment implements MapFragmentWrapper {

    private static final String MAP_FRAGMENT_TAG = "MapFragment";
    private MapsBinding mMapsBinding;
    private MapOptions mMapOptions;
    private MapFragmentWrapper mMapFragmentWrapper;
    private OnMapReadyCallback mCallback;

    public SupportMapFragment() {

    }

    public static Fragment newInstance(MapsBinding binding) {
        return binding.newSupportMapFragmentInstance();
    }

    public static Fragment newInstance(MapsBinding binding, MapOptions options) {
        return binding.newSupportMapFragmentInstance(options);
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        mMapsBinding = LayoutUtils.resolveMapsBindingFromAttributes(activity, attrs, 0, 0);
        if (mMapsBinding == null) {
            throw new IllegalArgumentException("Could not get maps binding. Specify a valid attribute app:abs_binding pointing to a MapsBinding class or static field");
        }
        mMapOptions = LayoutUtils.mapOptionsCreateFromAttributes(mMapsBinding, activity, attrs);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mMapsBinding == null) {
            throw new IllegalArgumentException("Could not get maps binding. You should instantiate fragment using method newInstance(binding)");
        }

        if (savedInstanceState == null) {
            Fragment mapFragment;
            if (mMapOptions != null) {
                mapFragment = mMapsBinding.newSupportMapFragmentInstance(mMapOptions);
            } else {
                mapFragment = mMapsBinding.newSupportMapFragmentInstance();
            }
            getChildFragmentManager().beginTransaction().add(R.id.abs_map_fragment_container, mapFragment, MAP_FRAGMENT_TAG).commit();
            mMapFragmentWrapper = mMapsBinding.mapFragmentWrapperFrom(mapFragment);
        } else {
            Fragment mapFragment = getChildFragmentManager().findFragmentByTag(MAP_FRAGMENT_TAG);
            mMapFragmentWrapper = mMapsBinding.mapFragmentWrapperFrom(mapFragment);
        }
        if (mCallback != null && mMapFragmentWrapper != null) {
            mMapFragmentWrapper.getMapAsync(mCallback);
            mCallback = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.abs_map_fragment, container, false);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            Fragment mapFragment = getChildFragmentManager().findFragmentByTag(MAP_FRAGMENT_TAG);
            mMapFragmentWrapper = mMapsBinding.mapFragmentWrapperFrom(mapFragment);
        }
        if (mCallback != null && mMapFragmentWrapper != null) {
            mMapFragmentWrapper.getMapAsync(mCallback);
            mCallback = null;
        }
    }

    @Override
    public Map getMap() {
        if (mMapFragmentWrapper == null) {
            return null;
        }
        return mMapFragmentWrapper.getMap();
    }

    @Override
    public void getMapAsync(OnMapReadyCallback callback) {
        if (mMapFragmentWrapper == null) {
            mCallback = callback;
        } else {
            mMapFragmentWrapper.getMapAsync(callback);
        }
    }

}
