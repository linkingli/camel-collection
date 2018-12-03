package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by lijun on 18-12-3.
 */@Component
public class SampleAutowiredAmqRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:foo")
                .to("log:sample");

        from("timer:bar")
                .setBody(constant("Hello from Camel"))
                .to("activemq:foo");
    }

}
