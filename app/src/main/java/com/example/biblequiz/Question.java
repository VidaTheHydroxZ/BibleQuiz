package com.example.biblequiz;

import java.util.List;

public class Question {

    private String questionText;
    private List<String> questionOptions;
    private int correctAnswerIndex;

    public Question() {}

    public Question (String questionText, List<String> questionOptions, int correctAnswerIndex)
    {
        this.questionText = questionText;
        this.questionOptions = questionOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText()
    {
        return questionText;
    }

    public List<String> getQuestionOptions()
    {
        return questionOptions;
    }

    public int getCorrectAnswerIndex()
    {
        return correctAnswerIndex;
    }

    public void setQuestionText(String questionText)
    {
        this.questionText = questionText;
    }

    public void setQuestionOptions(List<String> newOptions)
    {
        this.questionOptions = newOptions;
    }

    public void setCorrectAnswerIndex(int newCorrectAnswerIndex)
    {
        this.correctAnswerIndex = newCorrectAnswerIndex;
    }
}
