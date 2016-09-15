package mobile.rasmussen.edu.afinal;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;

public class CreateTreasure extends AppCompatActivity implements View.OnClickListener {

    EditText artWorkName, artistName, yearMadeInfo, interestingFactInfo;
    Button save_button;

    private static final int ACTIVITY_START_CAMERA_APP = 0;
    private ImageView mPhotoCapturedImageView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_treasure);

        save_button = (Button)findViewById(R.id.save_button);
        save_button.setOnClickListener(this);


        artWorkName = (EditText)findViewById(R.id.artWork);
        artistName = (EditText)findViewById(R.id.artist);
        yearMadeInfo = (EditText)findViewById(R.id.yearMade);
        interestingFactInfo = (EditText)findViewById(R.id.interestingFact);

        mPhotoCapturedImageView = (ImageView) findViewById(R.id.capturePhotoImage);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        PreferenceManager.setDefaultValues(this, R.xml.user_settings, false);
        loadSavedPreferences();

    }


    private void loadSavedPreferences(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String artworkname = sharedPreferences.getString("storedArtwork", "Artwork Name");
        artWorkName.setText(artworkname);

        String artistname = sharedPreferences.getString("storedArtist", "Artist Name");
        artistName.setText(artistname);

        String yearmadeinfo = sharedPreferences.getString("storedYear", "Year Made");
        yearMadeInfo.setText(yearmadeinfo);

        String interestingfact = sharedPreferences.getString("storedFact", "Interesting Fact");
        interestingFactInfo.setText(interestingfact);
    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public void onClick(View view) {
        savePreferences("storedArtwork", artWorkName.getText().toString());
        savePreferences("storedArist", artistName.getText().toString());
        savePreferences("storedYear", yearMadeInfo.getText().toString());
        savePreferences("storedFact", interestingFactInfo.getText().toString());

        finish();
    }

    public void takePhoto(View view) {
        Intent callCameraApplicationIntent = new Intent();
        callCameraApplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(callCameraApplicationIntent, ACTIVITY_START_CAMERA_APP);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK) {
            Toast.makeText(this, "Picture taken successfully", Toast.LENGTH_SHORT).show();
            Bundle extras = data.getExtras();
            Bitmap photoCapturedBitmap = (Bitmap) extras.get("data");
            mPhotoCapturedImageView.setImageBitmap(photoCapturedBitmap);

        }

        String FILE_PATH_KEY = "file_path";


        try {
            ExifInterface exif = new ExifInterface(FILE_PATH_KEY);
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("GPS Datestamp: " + getExifTag(exif, ExifInterface.TAG_FLASH) + "\n");
            stringBuilder.append("GPS Latitude: " + getExifTag(exif, ExifInterface.TAG_GPS_LATITUDE) + "\n");
            stringBuilder.append("GPS Longitude: " + getExifTag(exif, ExifInterface.TAG_GPS_LONGITUDE) + "\n");

            TextView info = (TextView) findViewById(R.id.exif);

            info.setText(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle(FILE_PATH_KEY);
    }


    private String getExifTag(ExifInterface exif, String tag) {
        String attribute = exif.getAttribute(tag);

        return (null != attribute ? attribute : "");
    }

    private void setTitle(String filepath) {
        int pos = filepath.lastIndexOf("/");
        String title = filepath;

        if (-1 != pos) {
            title = filepath.substring(pos + 1);
        }

        super.setTitle("Exif Info: " + title);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CameraIntent Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://mobile.rasmussen.edu.afinal/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "CameraIntent Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://mobile.rasmussen.edu.afinal/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}