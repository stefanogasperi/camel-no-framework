package com.gas.edu.routes;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;

@Log
public class LongInfoRoute extends RouteBuilder  {
    final String message;

    public LongInfoRoute(String message) {
        this.message = message;
    }

    @Override
    public void configure() throws Exception {
        log.info(message);
    }
}
