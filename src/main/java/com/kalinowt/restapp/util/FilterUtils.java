package com.kalinowt.restapp.util;


import com.kalinowt.restapp.dto.Outbound.OutboundIpApiResponse;
import com.kalinowt.restapp.models.IncomingIpApiQuery;


import java.util.List;
import java.util.stream.Collectors;

public class FilterUtils {
    public static void filterNorthHemisphereCountries(OutboundIpApiResponse response) {
        assert response != null;
        List<IncomingIpApiQuery> filteredQueries= response.getResponseQueries().stream()
                .filter(m -> m.getLat() > 0)
                .collect(Collectors.toList());
        response.setResponseQueries(filteredQueries);
    }

    public static boolean filterIpAddresses(String s) {
        return s.matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$");
    }
}
