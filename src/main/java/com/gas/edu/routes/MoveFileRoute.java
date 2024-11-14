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
                .to("file:output-folder");
    }
}
