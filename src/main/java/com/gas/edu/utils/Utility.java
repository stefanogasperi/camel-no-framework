package com.gas.edu.utils;

import lombok.extern.java.Log;
import org.apache.camel.CamelContext;

@Log
public class Utility {

    public static void keepAliveForSeconds(int i, CamelContext camelContext) {
        long startMillis = System.currentTimeMillis();
        long endMillis = startMillis + (long) i*1000L;
        log.info("Running... "+startMillis);
        do {
            camelContext.start();
        } while (System.currentTimeMillis() <= endMillis);
        log.info("...the end. "+endMillis+" - "+(System.currentTimeMillis()-startMillis));
    }

}
