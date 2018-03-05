package com.example.android.generalquiz;

import java.util.ArrayList;
import java.util.List;


class QuizAnswer {
    private List<Integer> quiz;
    private List<Integer> answer1;
    private List<Integer> answer2;
    private List<Integer> answer3;
    private List<Integer> correctAnswer;

    QuizAnswer() {
        quiz = new ArrayList<>();
        answer1 = new ArrayList<>();
        answer2 = new ArrayList<>();
        answer3 = new ArrayList<>();
        correctAnswer = new ArrayList<>();
    }

    void setQuiz(Integer quizI) {
        quiz.add(quizI);
    }

    Integer getQuiz(int counter) {
        return quiz.get(counter);
    }

    void setAnswer1(Integer answer1I) {
        answer1.add(answer1I);
    }

    Integer getAnswe1(int counter) {
        return answer1.get(counter);
    }

    void setAnswer2(Integer answer2I) {
        answer2.add(answer2I);
    }

    Integer getAnswe2(int counter) {
        return answer2.get(counter);
    }

    void setAnswer3(Integer answer3I) {
        answer3.add(answer3I);
    }

    Integer getAnswe3(int counter) {
        return answer3.get(counter);
    }

    void setCorrectAnswer(Integer correctAnswerI) {
        correctAnswer.add(correctAnswerI);
    }

    Integer getCorrectAnswer(int counter) {
        return correctAnswer.get(counter);
    }

}
