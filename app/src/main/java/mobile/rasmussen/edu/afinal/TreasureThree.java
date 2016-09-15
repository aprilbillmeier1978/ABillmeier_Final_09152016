package mobile.rasmussen.edu.afinal;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TreasureThree extends AppCompatActivity implements View.OnClickListener {




    Button hintButton1;
    Button hintButton2;
    Button hintButton3;
    Button hintButton4;

    Button enter_button;
    Button back_button;

    TextView score;
    TextView clue1, clue2, clue3, clue4;
    TextView collectionTextView;
    TextView answerTextView;
    TextView enterAttempts;


    EditText guessArtEditText;
    TextView scoreText;

    ImageView artImageView;

    int enter_counter = 3;
    int score_counter2 = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treasure_three);


        enter_button = (Button) findViewById(R.id.enter_button);
        enter_button.setOnClickListener(this);

        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        enterAttempts = (TextView) findViewById(R.id.enterAttempts);
        enterAttempts.setText(Integer.toString(enter_counter));

        hintButton1 = (Button) findViewById(R.id.hintButton1);
        hintButton1.setOnClickListener(this);

        hintButton2 = (Button) findViewById(R.id.hintButton2);
        hintButton2.setOnClickListener(this);


        hintButton3 = (Button) findViewById(R.id.hintButton3);
        hintButton3.setOnClickListener(this);

        hintButton4 = (Button) findViewById(R.id.hintButton4);
        hintButton4.setOnClickListener(this);

        score = (TextView) findViewById(R.id.score);

        scoreText = (TextView) findViewById(R.id.scoreText);

        clue1 = (TextView) findViewById(R.id.clue1);
        clue2 = (TextView) findViewById(R.id.clue2);
        clue3 = (TextView) findViewById(R.id.clue3);
        clue4 = (TextView) findViewById(R.id.clue4);


        collectionTextView = (TextView) findViewById(R.id.collectionTextView);

        answerTextView = (TextView) findViewById(R.id.answerTextView);

        guessArtEditText = (EditText) findViewById(R.id.guessArtEditText);

        artImageView = (ImageView) findViewById(R.id.artImageView);



    }

    public void enter_artName() {
        if (guessArtEditText.getText().toString().equals("A Sunday Afternoon on " +
                "the Island of La Grande Jatte")) {
            collectionTextView.setVisibility(View.VISIBLE);
            collectionTextView.setTextColor(Color.GREEN);
        } else {
            enter_counter--;
            enterAttempts.setText(Integer.toString(enter_counter));
            if (enter_counter == 0) {
                enter_button.setEnabled(false);
                answerTextView.setVisibility(View.VISIBLE);
                answerTextView.setTextColor(Color.RED);
                collectionTextView.setVisibility(View.VISIBLE);
                collectionTextView.setTextColor(Color.RED);
            }

        }
    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.back_button:
                getScore();
                break;
            case R.id.enter_button:
                enter_artName();
                break;
            case R.id.hintButton1:
                hintButtonOne();
                break;
            case R.id.hintButton2:
                hintButtonTwo();
                break;
            case R.id.hintButton3:
                hintButtonThree();
                break;
            case R.id.hintButton4:
                hintButtonFour();
                break;

        }
    }


    public void hintButtonOne() {
        score_counter2--;
        scoreText.setText(Integer.toString(score_counter2));
        hintButton1.setEnabled(false);
        clue1.setVisibility(View.VISIBLE);
        clue1.setTextColor(Color.BLACK);
    }

    public void hintButtonTwo() {
        score_counter2--;
        scoreText.setText(Integer.toString(score_counter2));
        hintButton2.setEnabled(false);
        clue2.setVisibility(View.VISIBLE);
        clue2.setTextColor(Color.BLACK);
    }

    public void hintButtonThree() {
        score_counter2--;
        scoreText.setText(Integer.toString(score_counter2));
        hintButton3.setEnabled(false);
        clue3.setVisibility(View.VISIBLE);
        clue3.setTextColor(Color.BLACK);
    }

    public void hintButtonFour() {
        score_counter2--;
        scoreText.setText(Integer.toString(score_counter2));
        hintButton4.setEnabled(false);
        clue4.setVisibility(View.VISIBLE);
        clue4.setTextColor(Color.BLACK);
    }

    public void getScore() {
        Intent intent = new Intent(TreasureThree.this, GamePlay.class);
        Bundle b = new Bundle();
        b.putInt("score", score_counter2); //Your score
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
    }
}







