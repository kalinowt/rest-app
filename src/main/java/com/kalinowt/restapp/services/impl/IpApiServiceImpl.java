package com.kalinowt.restapp.services.impl;

import com.kalinowt.restapp.dto.Inbound.AddressCheckRequest;
import com.kalinowt.restapp.dto.Inbound.AddressCheckResponse;
import com.kalinowt.restapp.dto.Outbound.IpApiRequest;
import com.kalinowt.restapp.models.IncomingIpApiQuery;
import com.kalinowt.restapp.mappers.DTOMapper;
import com.kalinowt.restapp.dto.Outbound.IpApiResponse;
import com.kalinowt.restapp.services.IpApiService;
import com.kalinowt.restapp.util.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/** https://ip-api.com/docs/api:batch
 * IpApi Query for multiple addresses:
 * POST at http://ip-api.com/batch
 * [
 *   {"query": "208.80.152.201", "fields": "city,country,countryCode,query", "lang": "ru"},
 *   "8.8.8.8",
 *   "24.48.0.1"
 * ]
 *
 * */
@Service
public class IpApiServiceImpl implements IpApiService {

    @Value("${ip-api.query-fields}")
    String fields;
    @Value("${ip-api.address.value}")
    String address;
    @Value("${ip-api.address.batch-path}")
    String path;

    @Autowired
    @Qualifier("address-service")
    private RestTemplate restTemplate;

    @Override
    public AddressCheckResponse getCountriesForNorthHemisphere(AddressCheckRequest request) {
        IpApiRequest ipApiRequest = DTOMapper.toIpApiRequest(request,fields);
        IncomingIpApiQuery[] responseQuery = restTemplate.postForObject(address+path,ipApiRequest.getQueries(), IncomingIpApiQuery[].class);
        IpApiResponse ipApiResponse = new IpApiResponse().setResponseQueries(responseQuery);
        FilterUtils.filterNorthHemisphereCountries(ipApiResponse);
        return DTOMapper.toAddressCheckResponse(ipApiResponse);
    }



}
