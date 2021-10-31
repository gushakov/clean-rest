package com.github.cleanrest.infrastucture.controller;

import com.github.cleanrest.core.port.GreetingInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GreetingRestController {

    private final ApplicationContext applicationContext;

    @GetMapping("/greet")
    public void greet(@RequestParam String name) {

        /*
            We are getting our use case from the DI container, then we
            just execute the use case leaving it to decide for itself how
            it should present the results.
         */

        // Get an instance of the use case from the DI
        final GreetingInputPort greetingUseCase = applicationContext.getBean(GreetingInputPort.class);

        // Just fire and forget
        greetingUseCase.sayHello(name);

        // Notice that we are not returning anything here,
        // use case will tell the presenter what to present.
    }

}
