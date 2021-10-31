package com.github.cleanrest.infrastucture.config;

import com.github.cleanrest.core.port.GreetingGatewayOutputPort;
import com.github.cleanrest.core.port.GreetingInputPort;
import com.github.cleanrest.core.usecase.GreetSomeoneUseCase;
import com.github.cleanrest.infrastucture.presenter.GreetingRestPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class AppConfig {

    @Bean(autowireCandidate = false)
    @Scope("request")
    public GreetingInputPort greetingRestUseCase(HttpServletResponse httpServletResponse,
                                                 MappingJackson2HttpMessageConverter jacksonConverter,
                                                 GreetingGatewayOutputPort greetingGateway) {
        return new GreetSomeoneUseCase(new GreetingRestPresenter(httpServletResponse, jacksonConverter),
                greetingGateway);
    }

}
