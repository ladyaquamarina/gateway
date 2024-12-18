package gateway.service;

import gateway.model.UserEntity;
import gateway.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<String> getUserId(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password)
                .map(UserEntity::getId);
    }

    public Mono<String> loginNewUser(String login, String password) {
        return userRepository.save(createUser(login, password))
                .map(UserEntity::getId)
//                .onErrorMap(e -> new Exception("such login already exist"))
                ;
    }

    private UserEntity createUser(String login, String password) {
        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setLogin(login);
        entity.setPassword(password);
        entity.setNew(true);
        return entity;
    }
}
