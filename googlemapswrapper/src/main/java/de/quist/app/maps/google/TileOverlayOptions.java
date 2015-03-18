package de.quist.app.maps.google;

import android.os.Parcel;

import de.quist.app.maps.utils.ParcelableWrapper;

class TileOverlayOptions extends ParcelableWrapper<com.google.android.gms.maps.model.TileOverlayOptions> implements de.quist.app.maps.model.TileOverlayOptions {

    static final Mapper<de.quist.app.maps.model.TileOverlayOptions, TileOverlayOptions, com.google.android.gms.maps.model.TileOverlayOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.TileOverlayOptions, TileOverlayOptions, com.google.android.gms.maps.model.TileOverlayOptions>() {

        @Override
        public TileOverlayOptions createWrapper(com.google.android.gms.maps.model.TileOverlayOptions original) {
            return original != null ? new TileOverlayOptions(original) : null;
        }
    };

    private TileOverlayOptions(com.google.android.gms.maps.model.TileOverlayOptions original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions tileProvider(de.quist.app.maps.model.TileProvider tileProvider) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.tileProvider(WrapperTileProvider.MAPPER.wrap(tileProvider));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions zIndex(float zIndex) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions visible(boolean visible) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions fadeIn(boolean fadeIn) {
        com.google.android.gms.maps.model.TileOverlayOptions ret = original.fadeIn(fadeIn);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileProvider getTileProvider() {
        com.google.android.gms.maps.model.TileProvider tileProvider = original.getTileProvider();
        if (tileProvider instanceof WrapperTileProvider) {
            return WrapperTileProvider.unwrap(tileProvider);
        } else {
            return TileProvider.MAPPER.wrap(tileProvider);
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

    public static final Creator<TileOverlayOptions> CREATOR
            = new Creator<TileOverlayOptions>() {
        public TileOverlayOptions createFromParcel(Parcel in) {
            return TileOverlayOptions.MAPPER.wrap(com.google.android.gms.maps.model.TileOverlayOptions.CREATOR.dn(in));
        }

        public TileOverlayOptions[] newArray(int size) {
            return new TileOverlayOptions[size];
        }
    };
}
