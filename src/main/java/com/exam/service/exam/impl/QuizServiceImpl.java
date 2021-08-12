package com.exam.service.exam.impl;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.exam.QuizRepository;
import com.exam.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {


    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
       // return this.quizRepository.findById(quizId).get();
        return  this.quizRepository.finByIdAndActiveTrue(quizId,true);
    }

    @Override
    public void deleteQuiz(Long quizId) {
            this.quizRepository.deleteById(quizId);
    }

    @Override
    public Set<Quiz> getQuizByCategory(Category category) {
        return this.quizRepository.findByCategory(category);
    }
}
