package com.example.braintraininggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button button = (Button)findViewById(R.id.backtomenubutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this,MainActivity.class));
            }
        });

        Button exit = (Button) findViewById(R.id.exitbutton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });


        scoreView = (TextView)findViewById(R.id.scorelabel);

        scoreView.setText(String.valueOf(getIntent().getIntExtra("easyScore", 0)));
        scoreView.setText(String.valueOf(getIntent().getIntExtra("noviceScore",0)));
        scoreView.setText(String.valueOf(getIntent().getIntExtra("mediumScore",0)));
        scoreView.setText(String.valueOf(getIntent().getIntExtra("guruScore",0)));
    }
}
