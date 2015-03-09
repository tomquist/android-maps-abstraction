package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.TileProvider;

class TileOverlayOptions implements de.quist.app.mapsabstraction.model.TileOverlayOptions {

    static com.google.android.gms.maps.model.TileOverlayOptions unwrap(de.quist.app.mapsabstraction.model.TileOverlayOptions tileOverlayOptions) {
        return tileOverlayOptions != null ? ((TileOverlayOptions)tileOverlayOptions).original : null;
    }

    static TileOverlayOptions wrap(com.google.android.gms.maps.model.TileOverlayOptions tileOverlayOptions) {
        return tileOverlayOptions != null ? new TileOverlayOptions(tileOverlayOptions) : null;
    }

    final com.google.android.gms.maps.model.TileOverlayOptions original;

    private TileOverlayOptions(com.google.android.gms.maps.model.TileOverlayOptions original) {
        this.original = original;
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileOverlayOptions tileProvider(de.quist.app.mapsabstraction.model.TileProvider tileProvider) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.tileProvider(WrapperTileProvider.wrap(tileProvider));
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileOverlayOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileOverlayOptions visible(boolean visible) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileOverlayOptions fadeIn(boolean fadeIn) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.fadeIn(fadeIn);
        if (ret == original) {
            return this;
        } else {
            return wrap(ret);
        }
    }

    @Override
    public de.quist.app.mapsabstraction.model.TileProvider getTileProvider() {
        TileProvider tileProvider = original.getTileProvider();
        if (tileProvider instanceof WrapperTileProvider) {
            return WrapperTileProvider.unwrap(tileProvider);
        } else {
            return de.quist.app.mapsabstraction.googlemapswrapper.TileProvider.wrap(tileProvider);
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
            return TileOverlayOptions.wrap(com.google.android.gms.maps.model.TileOverlayOptions.CREATOR.dn(in));
        }

        public TileOverlayOptions[] newArray(int size) {
            return new TileOverlayOptions[size];
        }
    };
}
