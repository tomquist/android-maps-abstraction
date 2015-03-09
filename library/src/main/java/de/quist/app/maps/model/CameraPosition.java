package de.quist.app.maps.model;

import android.os.Parcelable;

public interface CameraPosition extends Parcelable {

    LatLng target();
    float zoom();
    float tilt();
    float bearing();

    //public static com.google.android.gms.maps.model.CameraPosition createFromAttributes(android.content.Context context, android.util.AttributeSet attrs) { /* compiled code */ }

    public static interface IBuilder {

        IBuilder target(LatLng location);

        IBuilder zoom(float zoom);

        IBuilder tilt(float tilt);

        IBuilder bearing(float bearing);

        CameraPosition build();
    }

}
