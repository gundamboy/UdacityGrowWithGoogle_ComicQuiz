package com.wickedsword.retar.comicquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup question_1_answers;
    RadioGroup question_2_answers;
    RadioGroup question_3_answers;
    RadioGroup question_4_answers;
    RadioGroup question_5_answers;
    CheckBox question_6_answer_1;
    CheckBox question_6_answer_2;
    CheckBox question_6_answer_3;
    EditText question_7_answer;
    int score = 0;
    int wrong_answers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question_1_answers = (RadioGroup) findViewById(R.id.question_1_answers);
        question_2_answers = (RadioGroup) findViewById(R.id.question_2_answers);
        question_3_answers = (RadioGroup) findViewById(R.id.question_3_answers);
        question_4_answers = (RadioGroup) findViewById(R.id.question_4_answers);
        question_5_answers = (RadioGroup) findViewById(R.id.question_5_answers);
        question_6_answer_1 = (CheckBox) findViewById(R.id.question_6_answer_1);
        question_6_answer_2 = (CheckBox) findViewById(R.id.question_6_answer_2);
        question_6_answer_3 = (CheckBox) findViewById(R.id.question_6_answer_3);
        question_7_answer = (EditText) findViewById(R.id.question_7_answer);
    }

    /**
     * method used to check the quiz answers
     * @param view
     */
    public void checkAnswers(View view) {
        String question1 = getRadioGroupAnswer(question_1_answers.getCheckedRadioButtonId());
        String question2 = getRadioGroupAnswer(question_2_answers.getCheckedRadioButtonId());
        String question3 = getRadioGroupAnswer(question_3_answers.getCheckedRadioButtonId());
        String question4 = getRadioGroupAnswer(question_4_answers.getCheckedRadioButtonId());
        String question5 = getRadioGroupAnswer(question_5_answers.getCheckedRadioButtonId());

        // compare the returned radio selection to the proper answers
        if (question1.equals(getString(R.string.question_1_answer_2))) {
            score += 1;
        } else {
            wrong_answers +=1;
        }

        if (question2.equals(getString(R.string.question_2_answer_3))) {
            score += 1;
        } else {
            wrong_answers +=1;
        }

        if (question3.equals(getString(R.string.question_3_answer_1))) {
            score += 1;
        } else {
            wrong_answers +=1;
        }

        if (question4.equals(getString(R.string.question_4_answer_2))) {
            score += 1;
        } else {
            wrong_answers +=1;
        }

        if (question5.equals(getString(R.string.question_5_answer_1))) {
            score += 1;
        } else {
            wrong_answers +=1;
        }

        // make sure question 6 is only correct for the two choices
        if (question_6_answer_1.isChecked() && question_6_answer_2.isChecked() && !question_6_answer_3.isChecked()) {
            score += 1;
        } else {
            wrong_answers +=1;
        }

        // compare strings
        String answerQuestion7 = question_7_answer.getText().toString();
        if (answerQuestion7.toLowerCase().equals("martha")) {
            score += 1;
        } else {
            wrong_answers +=1;
        }

        showToast();

    }

    /**
     * method for retrieving the value of the selected radio button for a given radio group
     * @param id the id of the radio button
     * @return string
     */
    private String getRadioGroupAnswer(int id) {
        // Handle the case where the user did not make a choice
        if (id != -1) {
            RadioButton getSelectedRadioButton = (RadioButton) findViewById(id);
            String answer = getSelectedRadioButton.getText().toString();
            return answer;
        } else {
            // the user did not choose an answer, return an empty string
            return "";
        }

    }

    /**
     * method for showing a toast message to the user at the end of the quiz
     */
    private void showToast() {
        String toastMessage = getString(R.string.end_message, score, wrong_answers);
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

        resetScore();
    }

    /**
     * method used to reset the scoring of the quiz
     */
    private void resetScore() {
        score = 0;
        wrong_answers = 0;
    }
}
