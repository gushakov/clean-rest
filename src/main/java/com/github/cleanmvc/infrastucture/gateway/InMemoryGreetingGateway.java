package com.github.cleanmvc.infrastucture.gateway;

import com.github.cleanmvc.core.model.Greeting;
import com.github.cleanmvc.core.port.GreetingGatewayOutputPort;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InMemoryGreetingGateway implements GreetingGatewayOutputPort {

    private static final Map<String, String> greetings =
            Stream.of(new String[]{"George", "Hello %s"},
                            new String[]{"Brad", "Hi %s, how are you?"})
                    .collect(Collectors.toUnmodifiableMap(pair -> pair[0], pair -> pair[1]));


    @Override
    public Greeting retrievePersonalGreeting(String forWhom) {
        return Optional.ofNullable(greetings
                        .get(forWhom))
                .map(template -> template.formatted(forWhom))
                .map(message -> Greeting.builder()
                        .forWhom(forWhom)
                        .message(message)
                        .build())
                .orElse(Greeting.builder()
                        .forWhom("Somebody")
                        .message("Hi, stranger!")
                        .build());
    }
}
