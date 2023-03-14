package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ConnectionParam {

    private  @Getter @Setter String Email;//"darshan.yadav@credextechnology.com";
    private  @Getter@Setter String Password;//"Credex@2023hEJBJK5bVVEeZciIVO9Hs2YsS";
    private  @Getter  String LOGINURL="https://credextechnology7-dev-ed.develop.my.salesforce.com";
    private  @Getter @Setter String GrantService ="/services/oauth2/token?grant_type=password";
    private  @Getter @Setter String ClientId;//"3MVG9n_HvETGhr3DRMz8SCHXq6cXrYqRYUSJMZIMfRZQ2qBv2NxS0JMphnAT0Nm_2XJ3wuqrM8q8vrztxRFVs";
    private  @Getter @Setter String ClientSecret;//"5E95FCEFCA68552D78C4BF3235F1FC7AE7002C3A2BEC3EFAB135942E6373F850";




}
