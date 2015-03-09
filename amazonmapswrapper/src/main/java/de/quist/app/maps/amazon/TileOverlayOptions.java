package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

class TileOverlayOptions implements de.quist.app.maps.model.TileOverlayOptions {

    static com.amazon.geo.mapsv2.model.TileOverlayOptions unwrap(de.quist.app.maps.model.TileOverlayOptions tileOverlayOptions) {
        return tileOverlayOptions != null ? ((TileOverlayOptions)tileOverlayOptions).original : null;
    }

    static TileOverlayOptions wrap(com.amazon.geo.mapsv2.model.TileOverlayOptions tileOverlayOptions) {
        return tileOverlayOptions != null ? new TileOverlayOptions(tileOverlayOptions) : null;
    }

    final com.amazon.geo.mapsv2.model.TileOverlayOptions original;

    private TileOverlayOptions(com.amazon.geo.mapsv2.model.TileOverlayOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions tileProvider(de.quist.app.maps.model.TileProvider tileProvider) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.tileProvider(WrapperTileProvider.wrap(tileProvider));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions zIndex(float zIndex) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions fadeIn(boolean fadeIn) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.fadeIn(fadeIn);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileProvider getTileProvider() {
        com.amazon.geo.mapsv2.model.TileProvider tileProvider = original.getTileProvider();
        if (tileProvider instanceof WrapperTileProvider) {
            return WrapperTileProvider.unwrap(tileProvider);
        } else {
            return TileProvider.wrap(tileProvider);
        }
    }

    @Override
    public float getZIndex() {
        return original.getZIndex();
    }

    @Override
    public boolean isVisible() {
        return original.isVisible();
    }

    @Override
    public boolean getFadeIn() {
        return original.getFadeIn();
    }

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TileOverlayOptions)) {
            return false;
        }

        TileOverlayOptions other = (TileOverlayOptions)o;
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

    public static final Parcelable.Creator<TileOverlayOptions> CREATOR
            = new Parcelable.Creator<TileOverlayOptions>() {
        public TileOverlayOptions createFromParcel(Parcel in) {
            return TileOverlayOptions.wrap(com.amazon.geo.mapsv2.model.TileOverlayOptions.CREATOR.createFromParcel(in));
        }

        public TileOverlayOptions[] newArray(int size) {
            return new TileOverlayOptions[size];
        }
    };
}
