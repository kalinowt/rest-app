package com.kalinowt.restapp.dto.Outbound;

import com.kalinowt.restapp.models.IpApiQuery;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class IpApiRequest {
    List<IpApiQuery> queries;
}
