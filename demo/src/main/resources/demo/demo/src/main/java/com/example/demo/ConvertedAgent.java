package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.demo.OldConnection.getResponse;

@RestController
public class ConvertedAgent {

    static String endpoint = "/services/apexrest/leadsagentcoverted?converted";

    @GetMapping(value = "/leadsagentcoverted")
    public String data() throws Exception {
        return Objects.requireNonNull(getResponse(endpoint)).toString();
    }

}