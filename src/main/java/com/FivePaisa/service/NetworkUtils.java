package com.FivePaisa.service;


import okhttp3.*;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Map;

public class NetworkUtils {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL = "https://example.com/api"; // Replace with your actual base URL

    public static Response makeRequest(APITypes apiTypes, String verb, JSONObject requestBody,
                                       String accessToken, Map<String, String> additionalHeaders) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(fetchEndpoint(apiTypes))
                .headers(getHeaders(accessToken, additionalHeaders));
        try (Response response = client.newCall((switch (verb) {
                    case "POST" -> builder.post(NetworkUtils.generatePayload(requestBody));
                    case "GET" -> builder.get();
                    default -> throw new IllegalStateException("Unexpected value: " + verb);
                }).build())
                .execute()) {
            return response;
        }
    }

    public static Headers getHeaders(String accessToken, Map<String, String> additionalHeaders) {
        Headers.Builder headersBuilder = new Headers.Builder()
                .add("Authorization", "Bearer " + accessToken); // Replace with actual token retrieval logic
        additionalHeaders.forEach(headersBuilder::add);
        return headersBuilder.build();
    }

    public static RequestBody generatePayload(JSONObject payload) {
        System.out.println("\n Request >> " + payload.toJSONString());
        return RequestBody.create(payload.toJSONString(), JSON);
    }

    // API for fetching URL (endpoint)
    // This method can be expanded based on your API's structure, using parameters to determine the endpoint dynamically.
    public static String fetchEndpoint(APITypes apiTypes) {
        switch (apiTypes) {
            case HOLDINGS:
                return "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V3/Holding";
            case POSITIONS:
                return "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V2/NetPositionNetWise";
            case MARGIN:
                return "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V4/Margin";
            case ORDER_BOOK:
                return "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V3/OrderBook";
            case SQUARE_OFF:
                return "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/SquareOffAll";
            case TRADE_BOOK:
                return "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/V1/TradeBook";
            default:
                return "/";
        }
    }
}
