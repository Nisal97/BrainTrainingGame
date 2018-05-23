package com.example.braintraininggame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nmmut on 2018-03-12.
 */

public class gameMedium extends AppCompatActivity {

    TextView qTxtView;
    TextView viewCorrect;
    TextView timer;
    TextView typeAns;
    char[] charArr = {'+', '-', '/', '*'};
    int answer;
    int timeRemain;
    int TermsMax = 4;
    int TermsMin = 2;
    List numberList = new ArrayList();
    List operatorList = new ArrayList();
    boolean on;
    int hintCount;
    int clickCount;
    int questionCount = 0;
    int score = 0;

    CountDownTimer c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        remainingTime();

        qTxtView = (TextView) findViewById(R.id.question);
        viewCorrect = (TextView) findViewById(R.id.correct);
        typeAns = (TextView) findViewById(R.id.answer);
        mediumQuestion();

        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.third);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);
        Button next = (Button) findViewById(R.id.hash);
        Button dash = (Button) findViewById(R.id.dash);
        Button del = (Button) findViewById(R.id.delete);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.append("0");
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                if (clickCount == 1) {
                    check();
                } else {
                    if (questionCount < 10) {
                        mediumQuestion();
                    } else {
                        Intent mediumScore = new Intent(gameMedium.this, Score.class);
                        mediumScore.putExtra("mediumScore", score);
                        startActivity(mediumScore);
                    }

                }
                typeAns.setText("");
            }
        });

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typeAns.setText("-");
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans = String.valueOf(typeAns.getText());
                ans = ans.substring(0, ans.length() - 1);
                typeAns.setText(ans);
            }
        });
    }

    public void onToggleClicked(View view) {
        on = ((ToggleButton) view).isChecked();
    }

    private void mediumQuestion() {

        questionCount++;
        clickCount = 0;
        hintCount = 0;
        c.cancel();
        qTxtView.setText("");
        remainingTime();
        numberList.clear();
        operatorList.clear();
        int qAnswer = 0;
        int terms = (int) (Math.random() * (TermsMax - TermsMin + 1) + TermsMin);
        char operator;  //set random number to qAnswer in first run of set operator


        while (terms > 0) {
            int randomNum = (int) ((Math.random() * 100) + 1);
            qTxtView.append(String.valueOf(randomNum));
            numberList.add(randomNum);

            if (terms > 1) {
                operator = charArr[(int) (Math.random() * 4)];
                operatorList.add(operator);
                qTxtView.append(String.valueOf(operator));
            }
            terms--;
        }

        this.answer = calcAnswer();
    }

    private int calcAnswer() {
        int answer = (int) numberList.get(0);
        for (int x = 0; x < (numberList.size() - 1); x++) {
            switch ((char) operatorList.get(x)) {
                case '+':
                    answer += (int) numberList.get(x + 1);
                    break;
                case '-':
                    answer -= (int) numberList.get(x + 1);
                    break;
                case '*':
                    answer *= (int) numberList.get(x + 1);
                    break;
                case '/':
                    answer = (int) (Math.round(answer * 1.0 / (int) numberList.get(x + 1)));
                    break;
            }
        }
        System.out.println(answer);
        return answer;
    }


    private void check() {
        TextView ansTxt = (TextView) findViewById(R.id.answer);
        int check = Integer.valueOf(String.valueOf(ansTxt.getText()));


        if (on) {  //checking toggle button status
            if (hintCount < 4) {
                if (check > answer) {
                    viewCorrect.setText("Less");
                } else if (check < answer) {
                    viewCorrect.setText("Greater");
                } else {
                    viewCorrect.setText("Correct");
                }
            } else {
                mediumQuestion();
            }
            hintCount++;
        } else {
            if (check == answer) {
                viewCorrect.setText("Correct");
                viewCorrect.setTextColor(Color.parseColor("Green"));
                score = 100 / (10 - Integer.parseInt(String.valueOf(timer.getText())));
                score = score + score;
            } else {
                viewCorrect.setText("Wrong");
                viewCorrect.setTextColor(Color.parseColor("Red"));
            }
        }
    }

    public void remainingTime() {
        timeRemain = 10;
        timer = (TextView) findViewById(R.id.time);
        c = new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeRemain--;
                timer.setText(String.valueOf(timeRemain));
            }

            @Override
            public void onFinish() {
                mediumQuestion();
            }
        };
        c.start();
    }
}