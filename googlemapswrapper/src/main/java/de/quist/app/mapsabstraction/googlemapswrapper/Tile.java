package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Parcel;
import android.os.Parcelable;

class Tile implements de.quist.app.mapsabstraction.model.Tile {

    static com.google.android.gms.maps.model.Tile unwrap(de.quist.app.mapsabstraction.model.Tile tile) {
        return tile != null ? ((Tile)tile).original : null;
    }

    static Tile wrap(com.google.android.gms.maps.model.Tile tile) {
        return tile != null ? new Tile(tile) : null;
    }

    final com.google.android.gms.maps.model.Tile original;

    private Tile(com.google.android.gms.maps.model.Tile original) {
        this.original = original;
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

    @Override
    public int hashCode() {
        return original.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tile)) {
            return false;
        }

        Tile other = (Tile)o;
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

    public static final Parcelable.Creator<Tile> CREATOR
            = new Parcelable.Creator<Tile>() {
        public Tile createFromParcel(Parcel in) {
            return Tile.wrap(com.google.android.gms.maps.model.Tile.CREATOR.dm(in));
        }

        public Tile[] newArray(int size) {
            return new Tile[size];
        }
    };
}
