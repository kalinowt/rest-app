package com.kalinowt.restapp.services;

import com.kalinowt.restapp.dto.Inbound.InboundAddressCheckRequest;
import com.kalinowt.restapp.dto.Inbound.InboundAddressCheckResponse;
import org.springframework.http.ResponseEntity;

public interface IpApiService {
    InboundAddressCheckResponse getCountriesForNorthHemisphere(InboundAddressCheckRequest request);
}
