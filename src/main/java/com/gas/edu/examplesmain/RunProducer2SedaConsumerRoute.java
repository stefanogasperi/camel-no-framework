package com.gas.edu.examplesmain;

import com.gas.edu.routes.Produce2SedaConsumerRoute;
import lombok.extern.java.Log;
import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

@Log
public class RunProducer2SedaConsumerRoute
{
    public static void main( String[] args ) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "error");

        try (CamelContext camelContext = new DefaultCamelContext()) {
            camelContext.addRoutes(new Produce2SedaConsumerRoute());
            camelContext.start();

            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
            producerTemplate.sendBody("direct:produce","Input message");
            ConsumerTemplate consumerTemplate = camelContext.createConsumerTemplate();
            String message = consumerTemplate.receiveBody("seda:consume",String.class);
            log.info("consumed message ===>"+message);
        };

    }

}
