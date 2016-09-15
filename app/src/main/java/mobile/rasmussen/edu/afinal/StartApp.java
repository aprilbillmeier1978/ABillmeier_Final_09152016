package mobile.rasmussen.edu.afinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartApp extends Activity {

    Button start_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_app);

        start_button = (Button) findViewById(R.id.start_button);

    }

    public void onClick(View view) {

        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }
}




