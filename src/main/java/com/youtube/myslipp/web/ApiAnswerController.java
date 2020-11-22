package com.youtube.myslipp.web;

import com.youtube.myslipp.domain.Answer;
import com.youtube.myslipp.domain.Question;
import com.youtube.myslipp.domain.QuestionRepository;
import com.youtube.myslipp.domain.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/questions/{questionId}/answers")
public class ApiAnswerController {

    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;

    public ApiAnswerController(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @PostMapping("")
    public Answer create(@PathVariable Long questionId, String contents, HttpSession session) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return null;
        }

        User loginUser = HttpSessionUtils.getUserFromSession(session);
        Question question = questionRepository.findById(questionId).orElseThrow();
        Answer answer = new Answer(loginUser, question, contents);
        return answerRepository.save(answer);
    }

}
