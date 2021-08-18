package com.example.braintrainerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView choice1;
    TextView choice2;
    TextView choice3;
    TextView choice4;
    TextView equation;
    TextView score;
    int random1;
    int random2;
    int random3;
    int random4;
    int random_LHS;
    int random_RHS;
    int randomResult;


    public void choiceOne(View view){
        random1=new Random().nextInt(99);
        random2=new Random().nextInt(99);
        random3=new Random().nextInt(99);
        random4=new Random().nextInt(99);

        random_LHS=new Random().nextInt(99);
        random_RHS=new Random().nextInt(99);
        randomResult=random_LHS+random_RHS;


        choice1.setText(Integer.toString(randomResult));
        choice2.setText(Integer.toString(random2));
        choice3.setText(Integer.toString(random3));
        choice4.setText(Integer.toString(random4));

        equation.setText(Integer.toString(random_LHS)+" + "+Integer.toString(random_RHS));



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        equation=findViewById(R.id.equation);
    }
}