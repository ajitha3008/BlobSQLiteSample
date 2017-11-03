package braingalore.blobsqlitesample.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by s92 on 11/3/2017.
 */

public class CameraUtils {

    /**
     * Returns if the device supports camera
     * @param context
     * @return
     */
    public static boolean isDeviceSupportCamera(Context context) {
        if (context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
}
