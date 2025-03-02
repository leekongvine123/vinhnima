package com.lcvinh.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
@OpenAPIDefinition(
        info = @Info(title = "vinhnima API", version = "0.1.0", description = "API Documentation"),
        servers = @Server(url = "http://localhost:8089/vinhnima/")

)
public class Application extends jakarta.ws.rs.core.Application {

}