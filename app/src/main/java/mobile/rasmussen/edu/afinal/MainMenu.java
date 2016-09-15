package mobile.rasmussen.edu.afinal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity implements View.OnClickListener {

    Button start_splash;
    Button start_profile;
    Button start_treasure;
    Button start_game;
    Button start_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        start_splash = (Button)findViewById(R.id.start_splash);
        start_splash.setOnClickListener(this);
        start_profile = (Button)findViewById(R.id.start_profile);
        start_profile.setOnClickListener(this);
        start_treasure = (Button)findViewById(R.id.start_treasure);
        start_treasure.setOnClickListener(this);
        start_game = (Button)findViewById(R.id.start_game);
        start_game.setOnClickListener(this);
        start_help = (Button)findViewById(R.id.start_help);
        start_help.setOnClickListener(this);
    }

    private void start_splashClick()
    {
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }

    private void start_profileClick()
    {
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }

    private void start_treasureClick()
    {
        Intent intent = new Intent(this, CreateTreasure.class);
        startActivity(intent);
    }

    private void start_gameClick()
    {
        Intent intent = new Intent(this, GamePlay.class);
        startActivity(intent);
    }

    private void start_helpClick()
    {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.start_splash:
                start_splashClick();
                break;
            case R.id.start_profile:
                start_profileClick();
                break;
            case R.id.start_treasure:
                start_treasureClick();
                break;
            case R.id.start_game:
                start_gameClick();
                break;
            case R.id.start_help:
                start_helpClick();
                break;
        }
    }
}
