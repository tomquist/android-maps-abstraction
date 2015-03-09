package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Parcel;
import android.os.Parcelable;

class MarkerOptions implements de.quist.app.mapsabstraction.model.MarkerOptions {

    static com.google.android.gms.maps.model.MarkerOptions unwrap(de.quist.app.mapsabstraction.model.MarkerOptions markerOptions) {
        return markerOptions != null ? ((MarkerOptions)markerOptions).original : null;
    }

    static MarkerOptions wrap(com.google.android.gms.maps.model.MarkerOptions markerOptions) {
        return markerOptions != null ? new MarkerOptions(markerOptions) : null;
    }

    final com.google.android.gms.maps.model.MarkerOptions original;

    private MarkerOptions(com.google.android.gms.maps.model.MarkerOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions position(de.quist.app.mapsabstraction.model.LatLng position) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.position(LatLng.unwrap(position));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions icon(de.quist.app.mapsabstraction.model.BitmapDescriptor icon) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.icon(BitmapDescriptor.unwrap(icon));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions anchor(float u, float v) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.anchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions infoWindowAnchor(float u, float v) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.infoWindowAnchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions title(String title) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.title(title);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions snippet(String snippet) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.snippet(snippet);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions draggable(boolean draggable) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.draggable(draggable);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions visible(boolean visible) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions flat(boolean flat) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.flat(flat);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions rotation(float rotation) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.rotation(rotation);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.MarkerOptions alpha(float alpha) {
        com.google.android.gms.maps.model.MarkerOptions ret = original.alpha(alpha);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.LatLng getPosition() {
        return LatLng.wrap(original.getPosition());
    }

    @Override
    public String getTitle() {
        return original.getTitle();
    }

    @Override
    public String getSnippet() {
        return original.getSnippet();
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor getIcon() {
        return BitmapDescriptor.wrap(original.getIcon());
    }

    @Override
    public float getAnchorU() {
        return original.getAnchorU();
    }

    @Override
    public float getAnchorV() {
        return original.getAnchorV();
    }

    @Override
    public boolean isDraggable() {
        return original.isDraggable();
    }

    @Override
    public boolean isVisible() {
        return original.isVisible();
    }

    @Override
    public boolean isFlat() {
        return original.isFlat();
    }

    @Override
    public float getRotation() {
        return original.getRotation();
    }

    @Override
    public float getInfoWindowAnchorU() {
        return original.getInfoWindowAnchorU();
    }

    @Override
    public float getInfoWindowAnchorV() {
        return original.getInfoWindowAnchorV();
    }

    @Override
    public float getAlpha() {
        return original.getAlpha();
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MarkerOptions)) {
            return false;
        }

        MarkerOptions other = (MarkerOptions)o;
        return original.equals(other.original);
    }

    @Override
    public String toString() {
        return original.toString();
    }

    @Override
    public int describeContents() {
        return original.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        original.writeToParcel(dest, flags);
    }

    public static final Parcelable.Creator<MarkerOptions> CREATOR
            = new Parcelable.Creator<MarkerOptions>() {
        public MarkerOptions createFromParcel(Parcel in) {
            return MarkerOptions.wrap(com.google.android.gms.maps.model.MarkerOptions.CREATOR.df(in));
        }

        public MarkerOptions[] newArray(int size) {
            return new MarkerOptions[size];
        }
    };
}
