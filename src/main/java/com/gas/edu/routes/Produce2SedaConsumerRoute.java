package com.gas.edu.routes;

import org.apache.camel.builder.RouteBuilder;

public class Produce2SedaConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:produce")
                .to("seda:consume");
    }

}
