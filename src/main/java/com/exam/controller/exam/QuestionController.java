package com.exam.controller.exam;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.exam.QuestionService;
import com.exam.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //Add Question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {return ResponseEntity.ok(this.questionService.addQuestion(question)); }
    // update Question
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
    {return ResponseEntity.ok(this.questionService.addQuestion(question)); }


    // delete Question
    @DeleteMapping("/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Long questionId)
    {this.questionService.deleteQuestion(questionId);}

    //get Question
    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getQuestion(@PathVariable("questionId") Long questionId)
    {return ResponseEntity.ok(this.questionService.getQuestion(questionId));}

    //get Question by Quiz
    @GetMapping("/quizId/{quizId}")
    public ResponseEntity<?> getQuestionByQuizId(@PathVariable("quizId") Long quizId)
    {
//        Quiz quiz=new Quiz();
//        quiz.setQid(quizId);
//        return ResponseEntity.ok(this.questionService.getQuestionByQuiz(quiz));

        Quiz quiz=this.quizService.getQuiz(quizId);
        if(quiz!=null) {
            Set<Question> questions = quiz.getQuestions();

            List list = new ArrayList<>(questions);
            if (list.size() > Integer.parseInt(quiz.getNumberOfQuestion())) {
                list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion() + 1));
            }
            Collections.shuffle(list);
            return ResponseEntity.ok(list);
        }
        else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question Not Found");}

    }

}
