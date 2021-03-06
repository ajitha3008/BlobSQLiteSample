package braingalore.blobsqlitesample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import braingalore.blobsqlitesample.fragments.AboutFragment;
import braingalore.blobsqlitesample.fragments.CameraFragment;
import braingalore.blobsqlitesample.fragments.GalleryFragment;
import braingalore.blobsqlitesample.utils.CameraUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int CAMERA_REQUEST = 1888;
    private FragmentManager fm;

    private FragmentTransaction fragmentTransaction;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(!CameraUtils.isDeviceSupportCamera(this)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);
            alertDialogBuilder.setTitle(getString(R.string.no_camera_title));
            alertDialogBuilder
                    .setMessage(getString(R.string.no_camera_msg))
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            MainActivity.this.finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        fm = getSupportFragmentManager();
        try {
            fragmentTransaction = fm.beginTransaction();
            AboutFragment f1 = new AboutFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            finish();
        }
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*
                *//*Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);*//*
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            //imageView.setImageBitmap(photo);
        }
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            fragmentTransaction = fm.beginTransaction();
            AboutFragment f1 = new AboutFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commitAllowingStateLoss();
            toolbar.setTitle("About");
        } else if (id == R.id.nav_camera) {
            fragmentTransaction = fm.beginTransaction();
            CameraFragment f1 = new CameraFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commitAllowingStateLoss();
            toolbar.setTitle("Capture");
        } else if (id == R.id.nav_gallery) {
            fragmentTransaction = fm.beginTransaction();
            GalleryFragment f1 = new GalleryFragment();
            fragmentTransaction.replace(R.id.fragment_container, f1);
            fragmentTransaction.commitAllowingStateLoss();
            toolbar.setTitle("Gallery");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
