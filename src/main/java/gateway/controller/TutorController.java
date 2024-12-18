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

@RestController
@RequestMapping("/tutor")
public class TutorController {
    private static final String TUTOR = "Tutor";

    @PostMapping
    public Mono<String> createTutor(@RequestParam String userId,
                                    @RequestBody String text) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, TUTOR,
                "создание нового туториала", Arrays.asList(userId, text)));
    }

    @GetMapping
    public Mono<String> getTutor(@RequestParam String userId,
                                 @RequestParam String tutorId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, TUTOR,
                "получение туториала по id", Arrays.asList(userId, tutorId)));
    }

    @GetMapping("/all")
    public Mono<String> getTutors(@RequestParam String userId) {
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, TUTOR,
                "получение всех туториалов", Arrays.asList(userId)));
    }

    @DeleteMapping
    public Mono<String> deleteTutor(@RequestParam String userId,
                                    @RequestParam String tutorId){
        return Mono.just(MessageFormat.format(HANDLED_ENDPOINT_AND_PARAMS, TUTOR,
                "удаление туториала", Arrays.asList(userId, tutorId)));
    }
}
