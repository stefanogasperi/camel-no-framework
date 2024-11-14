package com.gas.edu;

import com.gas.edu.routes.Produce2SedaConsumerRoute;
import com.gas.edu.utils.Utility;
import lombok.extern.java.Log;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

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
        camelContext.addRoutes(new Produce2SedaConsumerRoute());

        camelContext.start();
        Utility.keepAliveForSeconds(2, camelContext);

        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        producerTemplate.sendBody("direct:produce","Input message");
        ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
        String message = consumerTemplate.receiveBody("seda:consume",String.class);
        log.info("message:"+message);


    }

}
