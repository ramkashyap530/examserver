package com.exam.controller.exam;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //Add Quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //getQuiz
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("quizId") Long quizId)
    {return ResponseEntity.ok(this.quizService.getQuiz(quizId));}

    // getQuizzes
    @GetMapping("/")
    public ResponseEntity<?> getQuizzes()
    {return ResponseEntity.ok(this.quizService.getQuizzes());}

    // getQuizzesByCategory
    @GetMapping("/ByCategoryId/{categoryId}")
    public ResponseEntity<?> getQuizzesByCategory(@PathVariable("categoryId") Long categoryId)
    {
        Category category=new Category();
        category.setCid(categoryId);
        return ResponseEntity.ok(this.quizService.getQuizByCategory(category)) ;}

    //updateQuiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
    {return ResponseEntity.ok(this.quizService.updateQuiz(quiz));}

    //DeleteQuiz
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quiz)
    {this.quizService.deleteQuiz(quiz);}




}
