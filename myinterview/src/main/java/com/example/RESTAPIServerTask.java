package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class RESTAPIServerTask {

    public static void main(String[] args) {
        SpringApplication.run(RESTAPIServerTask.class, args);
    }

    @GetMapping("/api/mensagem")
    public String getMensagem() {
        return "Olá, mundo!";
    }

}
