package service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.forms.LoginForm;
import service.services.LoginService;
import service.transfer.TokenDto;


@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginService.login(loginForm));
    }

    @PostMapping("/loginOut")
    public ResponseEntity<TokenDto> loginOut(@RequestParam("token") String tokenName) {
        loginService.loginOut(tokenName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/checkToken")
    public ResponseEntity<Object> checkToken(@RequestParam("token") String tokenName) {
        loginService.checkToken(tokenName);
        return ResponseEntity.ok().build();
    }
}
