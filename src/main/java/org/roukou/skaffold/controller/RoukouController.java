package org.roukou.skaffold.controller;

import lombok.extern.slf4j.Slf4j;
import org.roukou.skaffold.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
@RequestMapping( "skaffold/api/v1.0" )
public class RoukouController
{
    private AtomicLong counter = new AtomicLong();

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Greeting getGreeting()
    {
        return Greeting.builder()
            .requestId( counter.incrementAndGet() )
            .message( "skaffold demo=" + counter.longValue() )
            .build();
    }
}
