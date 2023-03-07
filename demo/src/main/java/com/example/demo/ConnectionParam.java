package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class ConnectionParam {


    private @Getter String USERNAME = "darshan.yadav@credextechnology.com";
    private @Getter String PASSWORD="Credex@2023hEJBJK5bVVEeZciIVO9Hs2YsS";
    private @Getter String LOGINURL="https://credextechnology7-dev-ed.develop.my.salesforce.com";
    private @Getter String GRANTSERVICE="/services/oauth2/token?grant_type=password";
    private @Getter String CLIENTID="3MVG9n_HvETGhr3DRMz8SCHXq6cXrYqRYUSJMZIMfRZQ2qBv2NxS0JMphnAT0Nm_2XJ3wuqrM8q8vrztxRFVs";
    private @Getter String CLIENTSECRET= "5E95FCEFCA68552D78C4BF3235F1FC7AE7002C3A2BEC3EFAB135942E6373F850";
}
