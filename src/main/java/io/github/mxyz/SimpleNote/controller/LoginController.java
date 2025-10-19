package io.github.mxyz.SimpleNote.controller;


import io.github.mxyz.SimpleNote.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("{mail}")
    public String login(@PathVariable("mail") String mail) {
        loginService.loginByMail(mail);
        return "success";
    }
}
