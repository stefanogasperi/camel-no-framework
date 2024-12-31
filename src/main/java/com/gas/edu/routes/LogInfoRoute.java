package com.gas.edu.routes;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.camel.builder.RouteBuilder;

@Log4j
public class LogInfoRoute extends RouteBuilder  {
    final String message;

    public LogInfoRoute(String message) {
        this.message = message;
    }

    @Override
    public void configure() throws Exception {
        log.info(message);
    }
}
