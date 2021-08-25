
package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView choice1;
    TextView choice2;
    TextView choice3;
    TextView choice4;
    TextView equation;
    TextView correctOrWrong;
    TextView startbuttonn;
    androidx.gridlayout.widget.GridLayout gridLayout;
    TextView score;
    Random rand= new Random();
    int correctAnswer;
    int random_LHS;
    int random_RHS;
    int randomResult;
    TextView timer ;
    String secsString;
    int minutes;
    int secs;
    ArrayList<Integer> answers=new ArrayList<Integer>();

    public void timerFunction (int secsLeft){
        minutes =secsLeft /60 ;
        secs = secsLeft-(minutes*60);
        secsString = Integer.toString(secs);

        if (secs<=9){
            secsString="0"+secsString;
        }

        timer.setText(Integer.toString(minutes)+" : " + secsString );
    }

    public void startbutton(View view){
        gridLayout.setVisibility(View.VISIBLE);
        equation.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        startbuttonn.setVisibility(View.INVISIBLE);
        new CountDownTimer(90000+100,1000){
            public void onTick(long l){
                timerFunction((int)l/1000);
            }
            public void onFinish(){
            }
        }.start();
    }


    public void choice(View view){
        if (Integer.toString(correctAnswer).equals(view.getTag().toString())){
            correctOrWrong.setText("CORRECT !");
        }
        else {
            correctOrWrong.setText("Wrong :/");
        }

        Toast.makeText(this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
        correctOrWrong.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        correctOrWrong=findViewById(R.id.correctOrWrong);
        startbuttonn=findViewById(R.id.startbuttonn);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        equation=findViewById(R.id.equation);
        timer=findViewById(R.id.timer);
        score=findViewById(R.id.score);
         gridLayout=findViewById(R.id.gridlayout);
        gridLayout.setVisibility(View.INVISIBLE);
        equation.setVisibility(View.INVISIBLE);
        correctOrWrong.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);

        random_LHS=rand.nextInt(31);
        random_RHS=rand.nextInt(31);
        equation.setText(Integer.toString(random_LHS)+" + "+Integer.toString(random_RHS));
        int correctAnswer =rand.nextInt(4);
        for (int i=0; i<4;i++){
            if (i==correctAnswer){
                answers.add(random_LHS+random_RHS);
            }else {
                int wronganswer =rand.nextInt(61);
                while (wronganswer==random_LHS+random_RHS){
                    wronganswer=rand.nextInt(61);
                }
                answers.add(wronganswer);
            }
        }
        choice1.setText(Integer.toString(answers.get(0)));
        choice2.setText(Integer.toString(answers.get(1)));
        choice3.setText(Integer.toString(answers.get(2)));
        choice4.setText(Integer.toString(answers.get(3)));

        Toast.makeText(this, Integer.toString(correctAnswer), Toast.LENGTH_SHORT).show();

    }
}