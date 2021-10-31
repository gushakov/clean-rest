package com.github.cleanrest.infrastucture.presenter;

import com.github.cleanrest.core.model.Greeting;
import com.github.cleanrest.core.port.GreetingPresenterOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class GreetingRestPresenter implements GreetingPresenterOutputPort {

    private final HttpServletResponse httpServletResponse;
    private final MappingJackson2HttpMessageConverter jacksonConverter;

    @Override
    public void presentGreeting(Greeting greeting) {

        /*
            Doing a bit of heavy lifting here ourselves:
            need to serialize the response model as JSON
            to the HTTP response. This will normally will
            be done by Spring Web when a request handling
            method returning the response model and annotated
            with ResponseBody.
         */

        // construct HTTP output message working with Servlet HTTP
        // response
        final DelegatingServerHttpResponse httpOutputMessage =
                new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));

        // set status OK
        httpOutputMessage.setStatusCode(HttpStatus.OK);

        // serialize response model to JSON as the body of the message
        try {
            jacksonConverter.write(greeting, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            // just for this example
            throw new RuntimeException(e);
        }

    }
}
