package de.quist.app.maps.google;

import android.os.Parcel;

import de.quist.app.maps.utils.ParcelableWrapper;

class Tile extends ParcelableWrapper<com.google.android.gms.maps.model.Tile> implements de.quist.app.maps.model.Tile {

    static final Mapper<de.quist.app.maps.model.Tile, Tile, com.google.android.gms.maps.model.Tile> MAPPER = new DefaultMapper<de.quist.app.maps.model.Tile, Tile, com.google.android.gms.maps.model.Tile>() {

        @Override
        public Tile createWrapper(com.google.android.gms.maps.model.Tile original) {
            return original != null ? new Tile(original) : null;
        }
    };

    private Tile(com.google.android.gms.maps.model.Tile original) {
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

    public static final Creator<Tile> CREATOR
            = new Creator<Tile>() {
        public Tile createFromParcel(Parcel in) {
            return Tile.MAPPER.wrap(com.google.android.gms.maps.model.Tile.CREATOR.dm(in));
        }

        public Tile[] newArray(int size) {
            return new Tile[size];
        }
    };
}
