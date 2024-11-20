package com.gas.edu.examplesmain;

import com.gas.edu.routes.File2QueueRoute;
import com.gas.edu.utils.Utility;
import lombok.extern.java.Log;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Component;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;


@Log
public class RunFile2QueueRoute {


    public static void main( String[] args ) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        String url="";
        url="http://localhost:8161";
        //url="localhost";
        //url="vm://localhost";
        //url="tcp://localhost:61616";
        activeMQConnectionFactory.setUserName("admin");
        activeMQConnectionFactory.setPassword("password");
        activeMQConnectionFactory.setBrokerURL(url);

        //JmsComponent jmsComponent = new JmsComponent();
        JmsComponent jmsComponent = JmsComponent.jmsComponentAutoAcknowledge(activeMQConnectionFactory);
        //jmsComponent.setConnectionFactory(activeMQConnectionFactory);

        try (CamelContext camelContext = new DefaultCamelContext()) {

            camelContext.addComponent("jms", jmsComponent);
            camelContext.addRoutes(new File2QueueRoute());
            while(true)
                camelContext.start();
            //Utility.keepAliveForSeconds(20, camelContext);
        }
    }

}