package com.bootcamp.springboot.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailConfig {
    private String Hostname;
    private int Port;

    public  MailConfig() {
    }

    public MailConfig(String hostname, int port) {
        this.Hostname = hostname;
        this.Port = port;
    }
}
