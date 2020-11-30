package com.kalinowt.restapp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomingIpApiQuery {
    private String country;
    private Float lat;
    private String query;
}