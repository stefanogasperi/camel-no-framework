package com.gas.edu;

import com.gas.edu.routes.LongInfoRoute;
import com.gas.edu.routes.MoveFileRoute;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
@Log
public class CamelNoFrameworkApp
{
    public static void main( String[] args ) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new LongInfoRoute("LOG start"));
        camelContext.addRoutes(new MoveFileRoute());
        camelContext.addRoutes(new LongInfoRoute("LOG end"));
        Long startMillis = System.currentTimeMillis();
        Long endMillis = startMillis + 10000L;
        log.info("Running...");
        while (true) {
            camelContext.start();
            if (System.currentTimeMillis()>endMillis) {
                //break;
            }
        }
        //log.info("..stopped");

        //camelContext.stop();
    }
}
