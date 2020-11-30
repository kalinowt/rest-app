package com.kalinowt.restapp.mappers;

import com.kalinowt.restapp.dto.Inbound.AddressCheckRequest;
import com.kalinowt.restapp.dto.Inbound.AddressCheckResponse;
import com.kalinowt.restapp.models.IncomingIpApiQuery;
import com.kalinowt.restapp.models.IpApiQuery;
import com.kalinowt.restapp.dto.Outbound.IpApiRequest;
import com.kalinowt.restapp.dto.Outbound.IpApiResponse;
import com.kalinowt.restapp.util.FilterUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DTOMapper {

    public static IpApiRequest toIpApiRequest(AddressCheckRequest request, String fields) {
        List<IpApiQuery> queries = request.getAddresses().stream()
                .filter(FilterUtils::filterIpAddresses)
                .map(address -> new IpApiQuery().setFields(fields).setQuery(address))
                .collect(Collectors.toList());
        return new IpApiRequest().setQueries(queries);
    }
    public static AddressCheckResponse toAddressCheckResponse(IpApiResponse response) {
        Set<String> countries = response.getResponseQueries().stream()
                .map(IncomingIpApiQuery::getCountry)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toSet());
        return new AddressCheckResponse().setCountries(countries);
    }
}
