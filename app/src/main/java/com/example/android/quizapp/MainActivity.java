package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean selectedOne, selectedTwo, selectedThree, selectedFour, selectedFive, selectedSix, selectedRadioThree, selectedRadioFour;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        CheckBox one = findViewById(R.id.one);
        CheckBox two = findViewById(R.id.two);
        CheckBox three = findViewById(R.id.three);
        CheckBox four = findViewById(R.id.four);
        CheckBox five = findViewById(R.id.fifth);
        CheckBox six = findViewById(R.id.sixth);
        selectedOne = one.isChecked();
        selectedTwo = two.isChecked();
        selectedThree = three.isChecked();
        selectedFour = four.isChecked();
        selectedFive = five.isChecked();
        selectedSix = six.isChecked();

        RadioButton radioThree = findViewById(R.id.radioButtonThree);
        selectedRadioThree = radioThree.isChecked();
        RadioButton radioFour = findViewById(R.id.radioButtonFour);
        selectedRadioFour = radioFour.isChecked();

        int q1 = questionOne();
        int q2 = questionTwo();
        int q3 = questionThree();
        int q4 = questionFour();
        score = q1 + q2 + q3 + q4;

        displayScore(score);
    }

    public int questionOne() {
        if ((selectedOne && selectedTwo && selectedThree && selectedSix) && !selectedFour && !selectedFive) {
            return 1;
            //score+=1;
        }
        else {
            return 0;
        }
    }

    public int questionTwo() {
        if (selectedRadioThree) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int questionThree() {
        if (selectedRadioFour) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int questionFour() {
        //In general, you need to find the view (EditText) that holds the content. You already have learned about the "findViewById"
        // method :)Second, once you have a reference to the edit text... How to get the string? There is a very useful method called
        // getText that will return you an Editable. You can then, call toString() to get the text.Now, the question is, how to
        // compare strings?You can use equals and equalsIgnoreCaseequals: "Jean" and "JeAn" => falseequals: "Jean" and "Jean" =>
        // trueequalsIgnoreCase: "Jean" and "Jean" => trueequalsIgnoreCase: "Jean" and "JeAn" => truethink about which one fits
        // better to your context ;)
        EditText q4 = findViewById(R.id.q4textbox);
        String answer = q4.getText().toString();
        if (answer.equalsIgnoreCase("touchdown")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void displayScore(int scoreParameter) {
        TextView scoreTextview = findViewById(R.id.scoreTextview);
        scoreTextview.setText("Score: " + scoreParameter + "/4");
    }
}
