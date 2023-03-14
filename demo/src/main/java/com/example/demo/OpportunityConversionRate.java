package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.demo.Connection.getResponse;
@RestController
public class OpportunityConversionRate {
    static String endpoint = "/services/apexrest/OpportunityConversionRate";

    @GetMapping(value = "/OpportunityConversionRate")
    public String data() throws Exception {
        return Objects.requireNonNull(getResponse(endpoint)).toString();
    }
}
