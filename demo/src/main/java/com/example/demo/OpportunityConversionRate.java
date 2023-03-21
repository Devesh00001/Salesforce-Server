package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.demo.Connection.getResponse;
@RestController
public class OpportunityConversionRate {
    static String endpoint = "/services/apexrest/OpportunityConversionRate";
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping(value = "/OpportunityConversionRate")
    public String data() throws Exception {
        return Objects.requireNonNull(getResponse(endpoint)).toString();
    }
}
