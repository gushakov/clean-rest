package com.github.cleanmvc.core.port;

import com.github.cleanmvc.core.model.Greeting;

import java.util.Optional;

public interface GreetingGatewayOutputPort {

    Greeting retrievePersonalGreeting(String forWhom);

}
