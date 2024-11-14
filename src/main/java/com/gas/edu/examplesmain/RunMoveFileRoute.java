package com.gas.edu.examplesmain;

import com.gas.edu.routes.MoveFileRoute;
import com.gas.edu.utils.Utility;
import lombok.extern.java.Log;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

@Log
public class RunMoveFileRoute
{
    public static void main( String[] args ) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
        try (CamelContext camelContext = new DefaultCamelContext()) {
            camelContext.addRoutes(new MoveFileRoute());

            Utility.keepAliveForSeconds(2, camelContext);
            //camelContext.start();
        }
    }

}