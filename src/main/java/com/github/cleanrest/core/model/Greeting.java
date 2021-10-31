package com.github.cleanrest.core.model;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Greeting {

    String forWhom;
    String message;

}
