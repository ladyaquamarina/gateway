package gateway.controller;

import gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

// контроллер для верификации пользователя
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    public Mono<String> loginNewUser(String login, String password) {
        return userService.loginNewUser(login, password);
    }

    @GetMapping
    public Mono<String> getUserIdByLoginAndPassword(String login, String password) {
        return userService.getUserId(login, password);
    }
}
