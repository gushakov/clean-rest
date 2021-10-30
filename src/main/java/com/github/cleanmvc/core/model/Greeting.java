package com.github.cleanmvc.core.model;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Greeting {

    String forWhom;
    String message;

}
