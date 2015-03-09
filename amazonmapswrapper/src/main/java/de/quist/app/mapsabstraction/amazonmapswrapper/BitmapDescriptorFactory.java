package de.quist.app.mapsabstraction.amazonmapswrapper;

import android.graphics.Bitmap;

class BitmapDescriptorFactory implements de.quist.app.mapsabstraction.model.BitmapDescriptorFactory {

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor fromResource(int resourceId) {
        return BitmapDescriptor.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromResource(resourceId));
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor fromAsset(String assetName) {
        return BitmapDescriptor.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromAsset(assetName));
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor fromFile(String fileName) {
        return BitmapDescriptor.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromFile(fileName));
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor fromPath(String absolutePath) {
        return BitmapDescriptor.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromPath(absolutePath));
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor defaultMarker() {
        return BitmapDescriptor.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.defaultMarker());
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor defaultMarker(float hue) {
        return BitmapDescriptor.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.defaultMarker(hue));
    }

    @Override
    public de.quist.app.mapsabstraction.model.BitmapDescriptor fromBitmap(Bitmap image) {
        return BitmapDescriptor.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromBitmap(image));
    }

}
