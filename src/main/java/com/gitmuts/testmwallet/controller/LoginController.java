package com.gitmuts.testmwallet.controller;

import com.gitmuts.testmwallet.model.UserLogin;
import com.gitmuts.testmwallet.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin){
        try{
            log.info("Received request {}", userLogin);

            return new ResponseEntity(loginService.login(userLogin), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error occurred in login ", e);
            return new ResponseEntity("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
