package com.gas.edu.routes;

import lombok.extern.java.Log;
import org.apache.camel.builder.RouteBuilder;

import java.io.File;
import java.io.FileReader;

@Log
public class MoveFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input-folder?antInclude=*.bat&noop=true")
                .process(exchange -> {
                    File fileBody = exchange.getMessage().getBody(File.class);
                    String body = "";

                    FileReader fr = new FileReader(fileBody);
                    int i;
                    while ((i = fr.read())>-1) {
                        body = body.concat(String.valueOf((char)i));
                    }

                    log.info("MoveFileRoute: inBody="+body);
                    exchange.getMessage().setBody("dir12"+body);
                })
                .to("file:output-folder");
    }
}
