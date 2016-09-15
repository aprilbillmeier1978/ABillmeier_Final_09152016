package mobile.rasmussen.edu.afinal;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GamePlay extends FragmentActivity implements OnMapReadyCallback ,
        View.OnClickListener {



    Button button1, button2, button3, button4, button5;

    TextView total_score;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        total_score = (TextView)findViewById(R.id.total_score);
        Intent intent = getIntent();
        int score_counter = intent.getIntExtra("score", 0);
        int score_counter1 = intent.getIntExtra("score", 0);
        int score_counter2 = intent.getIntExtra("score", 0);
        int score_counter3 = intent.getIntExtra("score", 0);
        int score_counter4 = intent.getIntExtra("score", 0);


        int sum = score_counter + score_counter1 + score_counter2 + score_counter3 + score_counter4;


        total_score.setText("Your score is " + sum);


        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng artinstitute = new LatLng(41.8795847364, -87.6237132042);
        mMap.addMarker(new MarkerOptions().position(artinstitute).title("You are Here").snippet("The Art Institute of Chicago"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(artinstitute, 25));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.88049288931945, -87.62176539748907))
                .title("Treasure One"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.87961120381466, -87.6227105408907))
                .title("Treasure Two"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.879599412245, -87.62291137129067))
                .title("Treasure Three"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.87910095896771, -87.6232362538561))
                .title("Treasure Four"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.8715462972797, -87.62215297669172))
                .title("Treasure Five"));


    }


    private void start_TreasureOne()
    {
        Intent intent = new Intent(this, TreasureOne.class);
        startActivity(intent);
    }

    private void start_TreasureTwo()
    {
        Intent intent = new Intent(this, TreasureTwo.class);
        startActivity(intent);
    }

    private void start_TreasureThree()
    {
        Intent intent = new Intent(this, TreasureThree.class);
        startActivity(intent);
    }

    private void start_TreasureFour()
    {
        Intent intent = new Intent(this, TreasureFour.class);
        startActivity(intent);
    }

    private void start_TreasureFive()
    {
        Intent intent = new Intent(this, TreasureFive.class);
        startActivity(intent);
    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.button1:
                start_TreasureOne();
                break;
            case R.id.button2:
                start_TreasureTwo();
                break;
            case R.id.button3:
                start_TreasureThree();
                break;
            case R.id.button4:
                start_TreasureFour();
                break;
            case R.id.button5:
                start_TreasureFive();
                break;
        }
    }
}


