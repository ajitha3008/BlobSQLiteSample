package braingalore.blobsqlitesample.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import java.io.File;

import braingalore.blobsqlitesample.R;

/**
 * Created by s92 on 11/3/2017.
 */
public class StorageUtil {

    /**
     * Get output media file URI
     * @param context
     * @param imageType
     * @return
     */
    public static Uri getOutputMediaFileUri(Context context, int imageType) {
        File imagesFolder = new File(Environment.getExternalStorageDirectory(), context.getString(R.string.app_name));
        imagesFolder.mkdirs(); // <----
        File image = new File(imagesFolder, String.valueOf(System.currentTimeMillis()));
        return Uri.fromFile(image);
    }
}
