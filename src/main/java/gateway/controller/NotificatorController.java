package gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;
import java.util.Arrays;

import static gateway.util.Util.HANDLED_ENDPOINT_AND_PARAMS;

// контроллер для отправки эндпоинтов в нотификатор, все методы - заглушки
@RestController
@RequestMapping("/notificator")
public class NotificatorController {
    private static final String NOTIFICATOR = "Notificator";

    @PostMapping
    public Mono<String> sendNotification(@RequestParam String userId,
                                         @RequestBody String message) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, NOTIFICATOR,
                "отправка всех уведомлений пользователю", Arrays.asList(userId, message)));
    }

    @PostMapping("/email")
    public Mono<String> sendEmailNotification(@RequestParam String userId,
                                              @RequestBody String message) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, NOTIFICATOR,
                "отправка email пользователю", Arrays.asList(userId, message)));
    }

    @PostMapping("/push")
    public Mono<String> sendPushNotification(@RequestParam String userId,
                                             @RequestBody String message) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, NOTIFICATOR,
                "отправка push пользователю", Arrays.asList(userId, message)));
    }

    @PostMapping("/phone")
    public Mono<String> sendPhoneNotification(@RequestParam String userId,
                                              @RequestBody String message) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, NOTIFICATOR,
                "отправка уведомления по телефону пользователю", Arrays.asList(userId, message)));
    }

    @GetMapping("/push")
    public Mono<String> getPushNotification(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, NOTIFICATOR,
                "получение push, отправленных пользователю", userId));
    }
}
