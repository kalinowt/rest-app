package com.kalinowt.restapp.dto.Inbound;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class AddressCheckRequest {
    List<String> addresses;
    String fields;
}
