package gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;
import java.util.Arrays;

import static gateway.util.Util.HANDLED_ENDPOINT_AND_PARAMS;

@RestController
@RequestMapping("/operator")
public class OperatorController {
    private static final String OPERATOR = "Operator";

    @GetMapping("/amount")
    public Mono<String> getAmountOfMoney(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, OPERATOR,
                "получение текущего остатка на счете", userId));
    }

    @PostMapping("/minus")
    public Mono<String> minus(@RequestParam String userId,
                              @RequestParam Double money) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, OPERATOR,
                "отнять сумму от текущего счета", Arrays.asList(userId, money)));
    }

    @PostMapping("/plus")
    public Mono<String> plus(@RequestParam String userId,
                             @RequestParam Double money) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, OPERATOR,
                "прибавить сумму к текущему счету", Arrays.asList(userId, money)));
    }

    @PostMapping("/share")
    public Mono<String> shareInfoWithUser(@RequestParam String userId,
                                          @RequestParam String anotherUserId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, OPERATOR,
                "поделиться информацией по счету с другим пользователем", Arrays.asList(userId, anotherUserId)));
    }
}
