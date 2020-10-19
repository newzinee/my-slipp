package com.youtube.myslipp.web;

import com.youtube.myslipp.domain.Question;
import com.youtube.myslipp.domain.QuestionRepository;
import com.youtube.myslipp.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/form")
    public String form(HttpSession session) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/users/loginForm";
        }
        return "qna/form";
    }

    @PostMapping("")
    public String create(HttpSession session,String title, String contents) {
        if(!HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/users/loginForm";
        }

        User sessionUser = HttpSessionUtils.getUserFromSession(session);
        Question newQuestion = new Question(sessionUser.getUserId(), title, contents);
        questionRepository.save(newQuestion);

        return "redirect:/";
    }

}
