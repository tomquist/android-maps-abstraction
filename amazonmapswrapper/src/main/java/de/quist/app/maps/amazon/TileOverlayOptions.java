package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import de.quist.app.maps.utils.ParcelableWrapper;

class TileOverlayOptions extends ParcelableWrapper<com.amazon.geo.mapsv2.model.TileOverlayOptions> implements de.quist.app.maps.model.TileOverlayOptions {

    static final Mapper<de.quist.app.maps.model.TileOverlayOptions, TileOverlayOptions, com.amazon.geo.mapsv2.model.TileOverlayOptions> MAPPER = new DefaultMapper<de.quist.app.maps.model.TileOverlayOptions, TileOverlayOptions, com.amazon.geo.mapsv2.model.TileOverlayOptions>() {

        @Override
        public TileOverlayOptions createWrapper(com.amazon.geo.mapsv2.model.TileOverlayOptions original) {
            return original != null ? new TileOverlayOptions(original) : null;
        }
    };

    private TileOverlayOptions(com.amazon.geo.mapsv2.model.TileOverlayOptions original) {
        super(original);
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions tileProvider(de.quist.app.maps.model.TileProvider tileProvider) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.tileProvider(WrapperTileProvider.MAPPER.wrap(tileProvider));
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions zIndex(float zIndex) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.zIndex(zIndex);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions visible(boolean visible) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.visible(visible);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileOverlayOptions fadeIn(boolean fadeIn) {
        com.amazon.geo.mapsv2.model.TileOverlayOptions ret = original.fadeIn(fadeIn);
        if (ret == original) {
            return this;
        } else {
            return MAPPER.wrap(ret);
        }
    }

    @Override
    public de.quist.app.maps.model.TileProvider getTileProvider() {
        com.amazon.geo.mapsv2.model.TileProvider tileProvider = original.getTileProvider();
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

    public static final Parcelable.Creator<TileOverlayOptions> CREATOR
            = new Parcelable.Creator<TileOverlayOptions>() {
        public TileOverlayOptions createFromParcel(Parcel in) {
            return TileOverlayOptions.MAPPER.wrap(com.amazon.geo.mapsv2.model.TileOverlayOptions.CREATOR.createFromParcel(in));
        }

        public TileOverlayOptions[] newArray(int size) {
            return new TileOverlayOptions[size];
        }
    };
}
