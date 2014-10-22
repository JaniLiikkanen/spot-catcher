package fi.tiko.tamk.spotcatcher.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import fi.tiko.tamk.spotcatcher.R;

public class MainActivity extends Activity {

    MyItemizedOverlay myItemizedOverlay = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        BoundingBoxE6 bBox = new BoundingBoxE6(71.5000, 38.0000, 58.6297, 8.0000);
        mapView.setScrollableAreaLimit(bBox);
        mapView.setMinZoomLevel(5);

        IMapController controller = mapView.getController();
        controller.setZoom(5);

        Drawable marker=getResources().getDrawable(android.R.drawable.star_big_on);
        int markerWidth = marker.getIntrinsicWidth();
        int markerHeight = marker.getIntrinsicHeight();
        marker.setBounds(0, markerHeight, markerWidth, 0);

        ResourceProxy resourceProxy = new DefaultResourceProxyImpl(getApplicationContext());

        myItemizedOverlay = new MyItemizedOverlay(marker, resourceProxy);
        mapView.getOverlays().add(myItemizedOverlay);
        GeoPoint myPoint1 = new GeoPoint(61.9056831, 23.743599);
        myItemizedOverlay.addItem(myPoint1, "myPoint1", "myPoint1");
        GeoPoint myPoint2 = new GeoPoint(63.5000, 25.743599);
        myItemizedOverlay.addItem(myPoint2, "myPoint2", "myPoint2");
    }
}
