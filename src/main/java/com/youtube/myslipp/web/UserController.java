package com.youtube.myslipp.web;

import com.youtube.myslipp.domain.User;
import com.youtube.myslipp.domain.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        User user = userRepository.findByUserId(userId);
        if(user == null) {
            System.out.println("Login Failure!");
            return "redirect:/users/loginForm";
        }
        if(!user.matchPassword(password)) {
            System.out.println("Login Failure!");
            return "redirect:/users/loginForm";
        }

        System.out.println("Login Success!");
        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);

        return "redirect:/";
    }

    @GetMapping("/form")
    public String form() {
        return "user/form";
    }

    @PostMapping("")
    public String create(User user) {
        System.out.println("user = " + user);
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@PathVariable Long id, Model model, HttpSession session) {
        if (!checkUser(id, session)) return "redirect:/users/loginForm";

        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "user/updateForm";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, User updatedUser, HttpSession session) {
        if (!checkUser(id, session)) return "redirect:/users/loginForm";

        User user = userRepository.findById(id).get();
        user.update(updatedUser);
        userRepository.save(user);
        return "redirect:/users";
    }

    private boolean checkUser(@PathVariable Long id, HttpSession session) {
        if (HttpSessionUtils.isLoginUser(session)) {
            return true;
        }

        User sessionUser = HttpSessionUtils.getUserFromSession(session);
        if (!sessionUser.matchId(id)) {
            throw new IllegalStateException("자신의 정보만 수정할 수 있습니다.");
        }
        return false;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.removeAttribute(HttpSessionUtils.USER_SESSION_KEY);
        return "redirect:/";
    }
}
