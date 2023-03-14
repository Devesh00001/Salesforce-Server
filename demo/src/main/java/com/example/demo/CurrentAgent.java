package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.demo.Connection.getResponse;

@RestController
public class CurrentAgent {

    static String endpoint = "/services/apexrest/leadcurrentworkingsalesagent";

    @GetMapping(value = "/leadsagentcurrent")
    public String data() throws Exception {
        return Objects.requireNonNull(getResponse(endpoint)).toString();
    }
}