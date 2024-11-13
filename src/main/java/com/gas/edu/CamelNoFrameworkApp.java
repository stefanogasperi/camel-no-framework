package com.gas.edu;

import com.gas.edu.routes.LongInfoRoute;
import com.gas.edu.routes.MoveFileRoute;
import com.gas.edu.routes.ProduceConsumerRoute;
import lombok.extern.java.Log;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
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
        /*
        camelContext.addRoutes(new LongInfoRoute("LOG start"));
        camelContext.addRoutes(new MoveFileRoute());
        camelContext.addRoutes(new LongInfoRoute("LOG end")); */
        camelContext.addRoutes(new ProduceConsumerRoute());

        camelContext.start();
        //keepAliveforSeconds(10, camelContext);

        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        producerTemplate.sendBody("direct:produce","Input message");
        ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
        String message = consumerTemplate.receiveBody("seda:consume",String.class);
        log.info("message:"+message);



    }

    private static void keepAliveforSeconds(int i, CamelContext camelContext) {
        Long startMillis = System.currentTimeMillis();
        Long endMillis = startMillis + 10000L;
        log.info("Running...");
        while (true) {
            camelContext.start();
            if (System.currentTimeMillis()>endMillis) {
                break;
            }
        }
        log.info("...the end");
    }


}
