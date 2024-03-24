package com.ms.borrowingservice.config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();
        xStream.allowTypesByWildcard(new String[] {
                "com.ms.**" // group name
        });
        return xStream;
    }
//    @Bean
//    public XStream xStream() {
//        XStream xStream = new XStream();
//        xStream.addPermission(AnyTypePermission.ANY);
//
//        return xStream;
//    }
}
