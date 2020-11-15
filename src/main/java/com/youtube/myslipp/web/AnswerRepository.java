package com.youtube.myslipp.web;

import com.youtube.myslipp.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
