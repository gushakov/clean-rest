package com.github.cleanrest.core.port;

import com.github.cleanrest.core.model.Greeting;

public interface GreetingGatewayOutputPort {

    Greeting retrievePersonalGreeting(String forWhom);

}
