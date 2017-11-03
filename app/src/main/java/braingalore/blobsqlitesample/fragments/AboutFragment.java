package braingalore.blobsqlitesample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import braingalore.blobsqlitesample.R;

/**
 * Created by s92 on 11/3/2017.
 */
public class AboutFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_about, vg, false);
    }
}
