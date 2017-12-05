package com.coketea.dt.coordinator;

import com.coketea.dt.server.annotation.DTServerType;
import com.coketea.dt.server.annotation.EnableDTServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDTServer
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
