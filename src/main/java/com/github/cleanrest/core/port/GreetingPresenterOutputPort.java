package com.github.cleanrest.core.port;

import com.github.cleanrest.core.model.Greeting;

public interface GreetingPresenterOutputPort {
    void presentGreeting(Greeting greeting);
}
