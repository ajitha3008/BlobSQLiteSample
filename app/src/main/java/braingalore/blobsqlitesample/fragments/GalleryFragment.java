package braingalore.blobsqlitesample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import braingalore.blobsqlitesample.R;
import braingalore.blobsqlitesample.database.DBHelperClass;
import braingalore.blobsqlitesample.utils.ImageUtil;

/**
 * Created by s92 on 11/3/2017.
 */
public class GalleryFragment extends Fragment {

    DBHelperClass dbHelper;

    ImageView imgView;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        dbHelper = new DBHelperClass(getActivity());
        View view = inflater.inflate(R.layout.content_gallery, vg, false);
        imgView = (ImageView) view.findViewById(R.id.image_container);
        loadImageFromDB();
        return view;
    }

    Boolean loadImageFromDB() {
        try {
            dbHelper.open();
            byte[] bytes = dbHelper.retreiveImageFromDB();
            dbHelper.close();
            // Show Image from DB in ImageView
            if (bytes != null) {
                imgView.setImageBitmap(ImageUtil.getImage(bytes));
            }
            return true;
        } catch (Exception e) {
            Log.e("ajitha", "<loadImageFromDB> Error : " + e.getLocalizedMessage());
            dbHelper.close();
            return false;
        }
    }
}
