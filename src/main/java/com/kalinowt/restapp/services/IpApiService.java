package com.kalinowt.restapp.services;

import com.kalinowt.restapp.dto.Inbound.AddressCheckRequest;
import com.kalinowt.restapp.dto.Inbound.AddressCheckResponse;

public interface IpApiService {
    AddressCheckResponse getCountriesForNorthHemisphere(AddressCheckRequest request);
}
