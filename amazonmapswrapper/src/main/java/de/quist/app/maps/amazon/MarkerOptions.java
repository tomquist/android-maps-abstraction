package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

class MarkerOptions implements de.quist.app.maps.model.MarkerOptions {

    static com.amazon.geo.mapsv2.model.MarkerOptions unwrap(de.quist.app.maps.model.MarkerOptions markerOptions) {
        return markerOptions != null ? ((MarkerOptions)markerOptions).original : null;
    }

    static MarkerOptions wrap(com.amazon.geo.mapsv2.model.MarkerOptions markerOptions) {
        return markerOptions != null ? new MarkerOptions(markerOptions) : null;
    }

    final com.amazon.geo.mapsv2.model.MarkerOptions original;

    private MarkerOptions(com.amazon.geo.mapsv2.model.MarkerOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions position(de.quist.app.maps.model.LatLng position) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.position(LatLng.unwrap(position));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions icon(de.quist.app.maps.model.BitmapDescriptor icon) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.icon(BitmapDescriptor.unwrap(icon));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions anchor(float u, float v) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.anchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions infoWindowAnchor(float u, float v) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.infoWindowAnchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions title(String title) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.title(title);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions snippet(String snippet) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.snippet(snippet);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions draggable(boolean draggable) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.draggable(draggable);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions flat(boolean flat) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.flat(flat);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions rotation(float rotation) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.rotation(rotation);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions alpha(float alpha) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.alpha(alpha);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.LatLng getPosition() {
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
    public de.quist.app.maps.model.BitmapDescriptor getIcon() {
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
            return MarkerOptions.wrap(com.amazon.geo.mapsv2.model.MarkerOptions.CREATOR.createFromParcel(in));
        }

        public MarkerOptions[] newArray(int size) {
            return new MarkerOptions[size];
        }
    };
}
