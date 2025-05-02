package com.example.crypto_dashboard.service;

import com.example.crypto_dashboard.model.price.PriceResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PriceMonitorService {

    private final String apiUri;

    public PriceMonitorService(@Value("${price-monitor.api-uri}") String apiUri) {
        this.apiUri = apiUri;
    }

    // api를 호출하기 위해 필요하다
    private static final RestClient restClient = RestClient.create();

    public PriceResponse getPrice(String cryptoUnit) {
        return restClient.get().uri(apiUri, cryptoUnit).retrieve().body(PriceResponse.class);
    }

}
