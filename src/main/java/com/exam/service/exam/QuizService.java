package com.exam.service.exam;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

    public Set<Quiz> getQuizByCategory(Category category);

}
