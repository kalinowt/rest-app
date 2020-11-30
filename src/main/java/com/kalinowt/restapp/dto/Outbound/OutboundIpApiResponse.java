package com.kalinowt.restapp.dto.Outbound;

import com.kalinowt.restapp.models.IncomingIpApiQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class OutboundIpApiResponse{
    List<IncomingIpApiQuery> responseQueries;

    public OutboundIpApiResponse(){
        this.responseQueries = new ArrayList<>();
    }

    public OutboundIpApiResponse setResponseQueries(IncomingIpApiQuery[] queries){
        this.responseQueries = Arrays.asList(queries);
        return this;
    }

    public void setResponseQueries(List<IncomingIpApiQuery> responseQueries) {
        this.responseQueries = responseQueries;
    }
}