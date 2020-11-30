package com.kalinowt.restapp.mappers;

import com.kalinowt.restapp.dto.Inbound.InboundAddressCheckRequest;
import com.kalinowt.restapp.dto.Inbound.InboundAddressCheckResponse;
import com.kalinowt.restapp.models.IncomingIpApiQuery;
import com.kalinowt.restapp.models.OutboundIpApiQuery;
import com.kalinowt.restapp.dto.Outbound.OutboundIpApiRequest;
import com.kalinowt.restapp.dto.Outbound.OutboundIpApiResponse;
import com.kalinowt.restapp.util.FilterUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DTOMapper {

    public static OutboundIpApiRequest toIpApiRequest(InboundAddressCheckRequest request, String fields) {
        List<OutboundIpApiQuery> queries = request.getAddresses().stream()
                .filter(FilterUtils::filterIpAddresses)
                .map(address -> new OutboundIpApiQuery().setFields(fields).setQuery(address))
                .collect(Collectors.toList());
        return new OutboundIpApiRequest().setQueries(queries);
    }
    public static InboundAddressCheckResponse toAddressCheckResponse(OutboundIpApiResponse response) {
        Set<String> countries = response.getResponseQueries().stream()
                .map(IncomingIpApiQuery::getCountry)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toSet());
        return new InboundAddressCheckResponse().setCountries(countries);
    }
}
