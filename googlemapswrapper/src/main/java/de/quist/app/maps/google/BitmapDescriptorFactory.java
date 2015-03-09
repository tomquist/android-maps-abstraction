package de.quist.app.maps.google;

import android.graphics.Bitmap;

class BitmapDescriptorFactory implements de.quist.app.maps.model.BitmapDescriptorFactory {

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromResource(int resourceId) {
        return BitmapDescriptor.wrap(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(resourceId));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromAsset(String assetName) {
        return BitmapDescriptor.wrap(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(assetName));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromFile(String fileName) {
        return BitmapDescriptor.wrap(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromFile(fileName));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromPath(String absolutePath) {
        return BitmapDescriptor.wrap(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromPath(absolutePath));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor defaultMarker() {
        return BitmapDescriptor.wrap(com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker());
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor defaultMarker(float hue) {
        return BitmapDescriptor.wrap(com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(hue));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromBitmap(Bitmap image) {
        return BitmapDescriptor.wrap(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(image));
    }

}
