package de.quist.app.mapsabstraction.model;

public interface BitmapDescriptorFactory {

    public static final float HUE_RED = 0.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_YELLOW = 60.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ROSE = 330.0f;
    
    BitmapDescriptor fromResource(int resourceId);

    BitmapDescriptor fromAsset(java.lang.String assetName);

    BitmapDescriptor fromFile(java.lang.String fileName);

    BitmapDescriptor fromPath(java.lang.String absolutePath);

    BitmapDescriptor defaultMarker();

    BitmapDescriptor defaultMarker(float hue);

    BitmapDescriptor fromBitmap(android.graphics.Bitmap image);
    
}
