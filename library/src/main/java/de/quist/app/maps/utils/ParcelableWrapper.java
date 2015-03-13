package de.quist.app.maps.utils;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class ParcelableWrapper<T extends Parcelable> extends Wrapper<T> implements Parcelable {

    public ParcelableWrapper(T original) {
        super(original);
    }

    protected ParcelableWrapper(Parcel in, Creator<T> creator) {
        this(creator.createFromParcel(in));
    }

    @Override
    public int describeContents() {
        return original.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        original.writeToParcel(dest, flags);
    }

}
