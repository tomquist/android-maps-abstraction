package de.quist.app.maps.amazon;

import android.graphics.Bitmap;

import de.quist.app.maps.utils.Wrapper;

class BitmapDescriptorFactory implements de.quist.app.maps.model.BitmapDescriptorFactory {

    private static final Wrapper.Mapper<de.quist.app.maps.model.BitmapDescriptor, BitmapDescriptor, com.amazon.geo.mapsv2.model.BitmapDescriptor> M = BitmapDescriptor.MAPPER;

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromResource(int resourceId) {
        return M.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromResource(resourceId));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromAsset(String assetName) {
        return M.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromAsset(assetName));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromFile(String fileName) {
        return M.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromFile(fileName));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromPath(String absolutePath) {
        return M.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromPath(absolutePath));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor defaultMarker() {
        return M.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.defaultMarker());
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor defaultMarker(float hue) {
        return M.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.defaultMarker(hue));
    }

    @Override
    public de.quist.app.maps.model.BitmapDescriptor fromBitmap(Bitmap image) {
        return M.wrap(com.amazon.geo.mapsv2.model.BitmapDescriptorFactory.fromBitmap(image));
    }

}
