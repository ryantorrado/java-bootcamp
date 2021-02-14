package com.bootcamp.springboot.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail")
public class DatabaseConfig {
    private String Hostname;
    private int Port;

    public DatabaseConfig() {
    }

    public DatabaseConfig(String hostname, int port) {
        this.Hostname = hostname;
        this.Port = port;
    }
}
