package com.example.mcqapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText, progressText;
    private RadioGroup answerGroup;
    private RadioButton option1, option2, option3, option4;
    private Button nextButton, previousButton;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who developed the theory of relativity?",
            "What is the largest ocean on Earth?",
            "Which element has the chemical symbol 'O'?",
            "What is the capital of Japan?",
            "Which gas do plants absorb during photosynthesis?",
            "What is the square root of 64?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the hardest natural substance on Earth?"
    };

    private String[][] options = {
            {"Paris", "London", "Berlin", "Madrid"},
            {"Mars", "Venus", "Jupiter", "Saturn"},
            {"Newton", "Einstein", "Galileo", "Tesla"},
            {"Pacific", "Atlantic", "Indian", "Arctic"},
            {"Oxygen", "Gold", "Iron", "Carbon"},
            {"Tokyo", "Beijing", "Seoul", "Bangkok"},
            {"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
            {"6", "7", "8", "9"},
            {"Shakespeare", "Hemingway", "Austen", "Dickens"},
            {"Diamond", "Gold", "Iron", "Platinum"}
    };
    private int[] correctAnswers = {0, 0, 1, 0, 0, 0, 1, 2, 0, 0};
    private int[] userAnswers = new int[questions.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        progressText = findViewById(R.id.progressText);
        answerGroup = findViewById(R.id.answerGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);
        for (int i = 0; i < userAnswers.length; i++) {
            userAnswers[i] = -1;
        }

        loadQuestion();
        nextButton.setOnClickListener(v -> {
            int selectedId = answerGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(QuizActivity.this, "Please select an answer!", Toast.LENGTH_SHORT).show();
            } else {
                if (selectedId == option1.getId()) userAnswers[currentQuestionIndex] = 0;
                if (selectedId == option2.getId()) userAnswers[currentQuestionIndex] = 1;
                if (selectedId == option3.getId()) userAnswers[currentQuestionIndex] = 2;
                if (selectedId == option4.getId()) userAnswers[currentQuestionIndex] = 3;

                if (userAnswers[currentQuestionIndex] == correctAnswers[currentQuestionIndex]) {
                    score++;
                }
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion();
                } else {
                    showResult();
                }
            }
        });
        previousButton.setOnClickListener(v -> {
            if (currentQuestionIndex > 0) {
                currentQuestionIndex--;
                loadQuestion();
            }
        });
    }

    private void loadQuestion() {
        // Update Question & Options
        questionText.setText(questions[currentQuestionIndex]);
        progressText.setText((currentQuestionIndex + 1) + "/" + questions.length);

        option1.setText(options[currentQuestionIndex][0]);
        option2.setText(options[currentQuestionIndex][1]);
        option3.setText(options[currentQuestionIndex][2]);
        option4.setText(options[currentQuestionIndex][3]);

        answerGroup.clearCheck();
        if (userAnswers[currentQuestionIndex] != -1) {
            if (userAnswers[currentQuestionIndex] == 0) option1.setChecked(true);
            if (userAnswers[currentQuestionIndex] == 1) option2.setChecked(true);
            if (userAnswers[currentQuestionIndex] == 2) option3.setChecked(true);
            if (userAnswers[currentQuestionIndex] == 3) option4.setChecked(true);
        }
        previousButton.setEnabled(currentQuestionIndex > 0);


        if (currentQuestionIndex == questions.length - 1) {
            nextButton.setText("Finish");
        } else {
            nextButton.setText("Next");
        }
    }

    private void showResult() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("USER_NAME",getIntent().getStringExtra("USER_NAME"));
        intent.putExtra("FINAL_SCORE", score);
        intent.putExtra("TOTAL_QUESTIONS",questions.length);

        startActivity(intent);
        finish();
    }
}