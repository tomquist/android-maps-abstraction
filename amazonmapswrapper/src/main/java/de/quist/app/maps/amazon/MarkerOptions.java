package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import de.quist.app.maps.utils.ParcelableWrapper;

class MarkerOptions extends ParcelableWrapper<com.amazon.geo.mapsv2.model.MarkerOptions> implements de.quist.app.maps.model.MarkerOptions {

    static final Mapper<de.quist.app.maps.model.MarkerOptions, MarkerOptions, com.amazon.geo.mapsv2.model.MarkerOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.MarkerOptions, MarkerOptions, com.amazon.geo.mapsv2.model.MarkerOptions>() {

        @Override
        public MarkerOptions createWrapper(com.amazon.geo.mapsv2.model.MarkerOptions original) {
            return original != null ? new MarkerOptions(original) : null;
        }
    };

    private MarkerOptions(com.amazon.geo.mapsv2.model.MarkerOptions original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions position(de.quist.app.maps.model.LatLng position) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.position(LatLng.MAPPER.unwrap(position));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions icon(de.quist.app.maps.model.BitmapDescriptor icon) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.icon(BitmapDescriptor.MAPPER.unwrap(icon));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions anchor(float u, float v) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.anchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions infoWindowAnchor(float u, float v) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.infoWindowAnchor(u, v);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions title(String title) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.title(title);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions snippet(String snippet) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.snippet(snippet);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions draggable(boolean draggable) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.draggable(draggable);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions flat(boolean flat) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.flat(flat);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions rotation(float rotation) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.rotation(rotation);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.MarkerOptions alpha(float alpha) {
        com.amazon.geo.mapsv2.model.MarkerOptions ret = original.alpha(alpha);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.LatLng getPosition() {
        return LatLng.MAPPER.wrap(original.getPosition());
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
        return BitmapDescriptor.MAPPER.wrap(original.getIcon());
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

    public static final Parcelable.Creator<MarkerOptions> CREATOR
            = new Parcelable.Creator<MarkerOptions>() {
        public MarkerOptions createFromParcel(Parcel in) {
            return MarkerOptions.MAPPER.wrap(com.amazon.geo.mapsv2.model.MarkerOptions.CREATOR.createFromParcel(in));
        }

        public MarkerOptions[] newArray(int size) {
            return new MarkerOptions[size];
        }
    };
}
