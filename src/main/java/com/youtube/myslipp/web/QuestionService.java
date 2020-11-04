package com.youtube.myslipp.web;

import com.youtube.myslipp.domain.Question;
import com.youtube.myslipp.domain.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public void update(Long id, String title, String contents) {
        Question question = questionRepository.findById(id).orElseThrow();
        question.update(title, contents);
    }
}
