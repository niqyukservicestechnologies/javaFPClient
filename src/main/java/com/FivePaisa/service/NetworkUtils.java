package com.FivePaisa.service;


import okhttp3.*;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Map;

public class NetworkUtils {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL = "https://example.com/api"; // Replace with your actual base URL

    // Generic network call method
    public static Response makeRequest(APITypes apiTypes, String verb, RequestBody body, Headers headers) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(fetchEndpoint(apiTypes))
                .headers(headers);

        if ("POST".equalsIgnoreCase(verb)) {
            builder.post(body);
        } else if ("GET".equalsIgnoreCase(verb)) {
            builder.get();
        } // Add more conditions for other HTTP verbs if needed
        Request request = builder.build();
        try (Response response = client.newCall(request).execute()) {
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
            default:
                return "/";
        }
    }
}
