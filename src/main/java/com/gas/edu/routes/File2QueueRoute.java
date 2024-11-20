package com.gas.edu.routes;

import lombok.extern.java.Log;
import org.apache.camel.builder.RouteBuilder;

@Log
public class File2QueueRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input-folder?antInclude=*.bat&noop=true")
        //from("jms:queue:QueueAny1")
                .process(exchange -> {
                    Object obj = exchange.getMessage().getBody();
                    System.out.println(obj);
                })
                .convertBodyTo(String.class)
                .to("jms:queue:QueueAny2");
    }
}
