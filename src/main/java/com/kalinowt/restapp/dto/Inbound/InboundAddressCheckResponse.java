package com.kalinowt.restapp.dto.Inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

@Setter
@Getter
@Accessors(chain = true)
public class InboundAddressCheckResponse {
        @JsonProperty("northcountries")
        Set<String> countries;

        public InboundAddressCheckResponse(){
                this.countries = new TreeSet<>();
        }
}
