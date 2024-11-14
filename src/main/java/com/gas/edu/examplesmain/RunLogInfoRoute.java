package com.gas.edu.examplesmain;

import com.gas.edu.routes.LogInfoRoute;
import lombok.extern.java.Log;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

@Log
public class RunLogInfoRoute
{
    public static void main( String[] args ) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
        try (CamelContext camelContext = new DefaultCamelContext()) {
            camelContext.addRoutes(new LogInfoRoute("LOG start"));
            camelContext.addRoutes(new LogInfoRoute("LOG end"));
            camelContext.start();

        }
    }

}
