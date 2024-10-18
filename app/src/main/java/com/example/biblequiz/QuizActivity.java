package com.example.biblequiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private FirebaseFirestore database;
    private List<Question> questionList = new ArrayList<>();
    private TextView questionTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_quiz);
        database = FirebaseFirestore.getInstance();
        questionTextView = findViewById(R.id.question_textview);
        loadQuestions();
    }

    private void loadQuestions() {
        database.collection("BibleQuizQuestions").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Question question = document.toObject(Question.class);
                        questionList.add(question);
                    }
                    displayQuestion(0);
                } else {
                    Log.d("Firebase", "Error getting documents: ", task.getException());
                }
            }
        });
    }

    private void displayQuestion(int index) {
        if (index < questionList.size()) {
            Question question = questionList.get(index);
            questionTextView.setText(question.getQuestionText());
        } else {
            questionTextView.setText("No more questions available!");
        }
    }
}