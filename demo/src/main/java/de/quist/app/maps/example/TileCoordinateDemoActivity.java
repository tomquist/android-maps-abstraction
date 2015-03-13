package de.quist.app.maps.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import java.io.ByteArrayOutputStream;

import de.quist.app.maps.Map;
import de.quist.app.maps.MapFragmentWrapper;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.model.Tile;
import de.quist.app.maps.model.TileProvider;

/**
 * This demonstrates tile overlay coordinates.
 */
public class TileCoordinateDemoActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tile_coordinate_demo);

        MapFragmentWrapper mapFragmentWrapper =
                BuildConfig.MAP_BINDING.mapFragmentWrapperFrom(getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragmentWrapper.getMapAsync(this);
    }

    @Override
    public void onMapReady(Map map) {
        TileProvider coordTileProvider = new CoordTileProvider(this.getApplicationContext());
        map.addTileOverlay(BuildConfig.MAP_BINDING.newTileOverlayOptions().tileProvider(coordTileProvider));
    }

    private static class CoordTileProvider implements TileProvider {
        private static final int TILE_SIZE_DP = 256;
        private float mScaleFactor;
        private Paint mBorderPaint;
        private Bitmap mBorderTile;

        public CoordTileProvider(Context context) {
            /* Scale factor based on density, with a 0.6 multiplier to increase tile generation
             * speed */
            mScaleFactor = context.getResources().getDisplayMetrics().density * 0.6f;
            mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mBorderPaint.setStyle(Paint.Style.STROKE);
            mBorderTile = Bitmap.createBitmap((int) (TILE_SIZE_DP * mScaleFactor),
                    (int) (TILE_SIZE_DP * mScaleFactor), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(mBorderTile);
            canvas.drawRect(0, 0, TILE_SIZE_DP * mScaleFactor, TILE_SIZE_DP * mScaleFactor,
                    mBorderPaint);
        }

        @Override
        public Tile getTile(int x, int y, int zoom) {
            Bitmap coordTile = drawTileCoords(x, y, zoom);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            coordTile.compress(Bitmap.CompressFormat.PNG, 0, stream);
            byte[] bitmapData = stream.toByteArray();
            return BuildConfig.MAP_BINDING.newTile((int) (TILE_SIZE_DP * mScaleFactor),
                    (int) (TILE_SIZE_DP * mScaleFactor), bitmapData);
        }

        private Bitmap drawTileCoords(int x, int y, int zoom) {
            Bitmap copy = mBorderTile.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(copy);
            String tileCoords = "(" + x + ", " + y + ")";
            String zoomLevel = "zoom = " + zoom;
            /* Paint is not thread safe. */
            Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mTextPaint.setTextAlign(Paint.Align.CENTER);
            mTextPaint.setTextSize(18 * mScaleFactor);
            canvas.drawText(tileCoords, TILE_SIZE_DP * mScaleFactor / 2,
                    TILE_SIZE_DP * mScaleFactor / 2, mTextPaint);
            canvas.drawText(zoomLevel, TILE_SIZE_DP * mScaleFactor / 2,
                    TILE_SIZE_DP * mScaleFactor * 2 / 3, mTextPaint);
            return copy;
        }
    }
}
