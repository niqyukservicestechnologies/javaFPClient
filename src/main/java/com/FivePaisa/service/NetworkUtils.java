package com.FivePaisa.service;


import lombok.experimental.UtilityClass;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class NetworkUtils {

    private static final Logger aLogger = LoggerFactory.getLogger(NetworkUtils.class);

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();

    public static String makeRequest(APITypes apiTypes, String verb, JSONObject requestBody,
                                     String accessToken, Map<String, String> additionalHeaders) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(fetchEndpoint(apiTypes))
                .headers(getHeaders(accessToken, additionalHeaders));
        try (Response response = client.newCall((switch (verb) {
                    case "POST" -> builder.post(generatePayload(requestBody));
                    case "GET" -> builder.get();
                    default -> throw new IllegalStateException("Unexpected value: " + verb);
                }).build())
                .execute()) {
            if (!List.of(200,201,202).contains(response.code()))
                throw new IOException("Non 2XX Response " + Objects.requireNonNull(response.body()).string());
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public static Headers getHeaders(String accessToken, Map<String, String> additionalHeaders) {
        Headers.Builder headersBuilder = new Headers.Builder()
                .add("Authorization", "Bearer " + accessToken);
        additionalHeaders.forEach(headersBuilder::add);
        return headersBuilder.build();
    }

    public static RequestBody generatePayload(JSONObject payload) {
        aLogger.info("Java FivePaisa Client Request Payload : {}", payload.toJSONString());
        return RequestBody.create(payload.toJSONString(), JSON);
    }

    public static String fetchEndpoint(APITypes apiTypes) {
        return switch (apiTypes) {
            case HOLDINGS -> "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V3/Holding";
            case POSITIONS -> "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V2/NetPositionNetWise";
            case MARGIN -> "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V4/Margin";
            case ORDER_BOOK -> "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V3/OrderBook";
            case SQUARE_OFF -> "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/SquareOffAll";
            case TRADE_BOOK -> "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V1/TradeBook";
            case PLACE_ORDER -> "https://openapi.5paisa.com/VendorsAPI/Service1.svc/V1/PlaceOrderRequest";
            case PLACE_BRACKET_ORDER -> "https://openapi.5paisa.com/VendorsAPI/Service1.svc/V1/BracketOrderRequest";
            default -> "/";
        };
    }
}
