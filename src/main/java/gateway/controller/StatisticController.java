package gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;

import static gateway.util.Util.HANDLED_ENDPOINT_AND_PARAMS;

@RestController
@RequestMapping("/statistic")
public class StatisticController {
    private static final String STATISTIC = "Statistic";

    @GetMapping("/user/location")
    public Mono<String> getUserLocations(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, STATISTIC,
                "статистика по территориальному расположению пользователей", userId));
    }
    @GetMapping("/messenger/average_messages_count")
    public Mono<String> getAverageMessagesCount(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, STATISTIC,
                "статистика по среднему количеству обращений в техподдержку по пользователям", userId));
    }

    @GetMapping("/tutor/views")
    public Mono<String> getTutor(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, STATISTIC,
                "статистика по просмотрам туториалов", userId));
    }

    @GetMapping("/notificator/target_type")
    public Mono<String> getTutors(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, STATISTIC,
                "статистика по предпочитаемым типам уведомлений пользователей", userId));
    }
}
