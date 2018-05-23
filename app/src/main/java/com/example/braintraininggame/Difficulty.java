package com.example.braintraininggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Difficulty extends AppCompatActivity {

    //adding difficulty buttons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        Button noviceBtn = (Button)findViewById(R.id.noviceBtn);
        noviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Difficulty.this,gameNovice.class));
            }
        });

        Button easyBtn = (Button)findViewById(R.id.easyBtn);
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Difficulty.this,gameEasy.class));
            }
        });

        Button mediumBtn = (Button)findViewById(R.id.mediumBtn);
        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Difficulty.this,gameMedium.class));
            }
        });

        Button guruBtn = (Button)findViewById(R.id.guruBtn);
        guruBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Difficulty.this,gameGuru.class));
            }
        });
    }
}
