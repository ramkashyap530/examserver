package com.exam.repo.exam;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Queue;
import java.util.Set;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    Set<Quiz> findByCategory(Category category);

   // Quiz findByIdActiveTrue();

    @Query("select u from Quiz u where u.qid = ?1 and u.active=?2")
    Quiz finByIdAndActiveTrue(Long quizId,boolean b);
}
