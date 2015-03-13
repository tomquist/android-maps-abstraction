package de.quist.app.maps.amazon;

import android.os.Parcel;
import android.os.Parcelable;

import de.quist.app.maps.utils.ParcelableWrapper;

class Tile extends ParcelableWrapper<com.amazon.geo.mapsv2.model.Tile> implements de.quist.app.maps.model.Tile {

    static final Mapper<de.quist.app.maps.model.Tile, Tile, com.amazon.geo.mapsv2.model.Tile> MAPPER = new DefaultMapper<de.quist.app.maps.model.Tile, Tile, com.amazon.geo.mapsv2.model.Tile>() {

        @Override
        public Tile createWrapper(com.amazon.geo.mapsv2.model.Tile original) {
            return original != null ? new Tile(original) : null;
        }
    };

    private Tile(com.amazon.geo.mapsv2.model.Tile original) {
        super(original);
    }

    @Override
    public int width() {
        return original.width;
    }

    @Override
    public int height() {
        return original.height;
    }

    @Override
    public byte[] data() {
        return original.data;
    }

    public static final Parcelable.Creator<Tile> CREATOR
            = new Parcelable.Creator<Tile>() {
        public Tile createFromParcel(Parcel in) {
            return Tile.MAPPER.wrap(com.amazon.geo.mapsv2.model.Tile.CREATOR.createFromParcel(in));
        }

        public Tile[] newArray(int size) {
            return new Tile[size];
        }
    };
}
