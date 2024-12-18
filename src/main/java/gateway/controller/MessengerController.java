package gateway.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
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

// контроллер для отправки эндпоинтов в мессенджер, все методы - заглушки
@RestController
@RequestMapping("/messenger")
public class MessengerController {
    private static final String MESSENGER = "Messenger";

    @PostMapping
    public Mono<String> sendMessage(@RequestParam String chatId,
                                    @RequestParam String userId,
                                    @RequestBody String message) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, MESSENGER,
                "отправка сообщения пользователем", Arrays.asList(chatId, userId, message)));
    }

    @GetMapping("/to_show")
    public Mono<String> getMessage(@RequestParam String chatId,
                                       @RequestParam String userId,
                                       @RequestParam String messageId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, MESSENGER,
                "получение сообщения пользователем", Arrays.asList(chatId, userId, messageId)));
    }

    @GetMapping("/to_answer")
    public Mono<String> getMessage(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, MESSENGER,
                "получение сообщения пользователя сотрудником техподдержки", userId));
    }

    @GetMapping("/all")
    public Mono<String> getMessages(@RequestParam String chatId,
                                        @RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, MESSENGER,
                "получение всех сообщений чата пользователем", Arrays.asList(chatId, userId)));
    }

    @DeleteMapping
    public Mono<String> deleteMessage(@RequestParam String messageId,
                                      @RequestParam String userId,
                                      @RequestParam String chatId){

        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, MESSENGER,
                "удаление сообщения пользователем", Arrays.asList(messageId, userId, chatId)));
    }
}
