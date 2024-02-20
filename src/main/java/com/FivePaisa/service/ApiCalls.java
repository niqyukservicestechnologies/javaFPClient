package com.FivePaisa.service;

import com.FivePaisa.config.AppConfig;
import com.FivePaisa.util.ServerDetails;
import lombok.Setter;
import okhttp3.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;

public class ApiCalls {

    private static final Logger aLogger = LoggerFactory.getLogger(ApiCalls.class);

    public final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    @Setter
    String jwtToken;
    String apiUrl = "https://Openapi.5paisa.com/VendorsAPI/Service1.svc/";

    JSONParser parser = new JSONParser();

    public Response callPOSTWithAccessToken(JSONObject requestBody, String url, String rc, AppConfig config)
            throws IOException, ParseException {
        JSONObject body = new JSONObject();
        JSONObject OrderStatusJson = (JSONObject) requestBody;
        requestBody = ipConfig(OrderStatusJson);
        JSONObject requestHead = new JSONObject();
        requestHead = header(rc, config.getUserId(), config.getPassword(), config);
        body.put("body", requestBody);
        body.put("head", requestHead);
        Response resonse = apiCallWithCookies(url, body);
        return resonse;
    }

    public Response apiCall(String suburl, JSONObject reqbody, AppConfig config)
            throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient();
        String url = apiUrl + suburl;
        System.out.println("\n Url >> " + url);

        //

        //
        RequestBody body = RequestBody.create(reqbody.toJSONString(), JSON);
        System.out.println("\n Request >> " + reqbody);
        Request request = new Request.Builder().url(url)
                .post(body).build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (!response.isSuccessful())
            throw new IOException("Unexpected code " + response);
        return response;
    }

    public Response apiCallWithCookies(String suburl, JSONObject reqbody) throws IOException, ParseException {

        OkHttpClient client = new OkHttpClient();
        String url = apiUrl + suburl;
        System.out.println("\n Url >> " + url);
        System.out.println("\n Request >> " + reqbody);

        RequestBody body = RequestBody.create(reqbody.toJSONString(), JSON);
        Request request = new Request.Builder().url(url)
                .addHeader("Authorization", "Bearer " + jwtToken)
                .post(body)
                .build();
        System.out.println("\n Request header >> " + request.headers().toString());

        Call call = client.newCall(request);
        Response response = call.execute();
        BufferedReader br = new BufferedReader(new InputStreamReader(response.body().byteStream()));
        String x;
        StringBuilder sb = new StringBuilder();
        while ((x = br.readLine()) != null) {
            sb.append(x);
        }
        System.out.println("BODY IS " + sb.toString());
        if (!response.isSuccessful())
            throw new IOException("\n  Unexpected code " + response);
        return response;
    }

    public JSONObject header(String rc, String ui, String pw, AppConfig config) throws IOException, ParseException {
        JSONObject requestHead = new JSONObject();
        requestHead.put("requestCode", rc);
        requestHead.put("key", config.getKey());
        requestHead.put("appVer", config.getAppVer());
        requestHead.put("appName", config.getAppName());
        requestHead.put("osName", config.getOsName());
        requestHead.put("userId", ui);
        requestHead.put("password", pw);
        // System.out.println(AES.encrypt(ui)+"ENcrypted
        // Password=====:"+AES.encrypt(pw));
        return requestHead;
    }

    public JSONObject headerWss(String rc, String ui, AppConfig config) throws IOException, ParseException {
        JSONObject requestHead = new JSONObject();
        requestHead.put("requestCode", rc);
        requestHead.put("key", config.getKey());
        requestHead.put("appVer", config.getAppVer());
        requestHead.put("appName", config.getAppName());
        requestHead.put("osName", config.getOsName());
        requestHead.put("LoginId", config.getLoginId());
        // requestHead.put("password",pw);
        return requestHead;
    }

    public JSONObject ipConfig(JSONObject requestBody) throws IOException, ParseException {
        JSONObject ipDetails = ServerDetails.GetIP();
        requestBody.put("LocalIP", ipDetails.get("publicIp"));
        requestBody.put("PublicIP", ipDetails.get("privateIp"));
        return requestBody;
    }

    public Response callPOSTWithAccessToken(JSONObject requestBody, APITypes apiTypes) throws IOException {
        aLogger.info("Invoking Five Paisa API : {} ", apiTypes);
        return callWithAccessToken(requestBody, apiTypes, Collections.emptyMap(), "POST");
    }

    public Response callWithAccessToken(JSONObject requestBody, APITypes apiTypes, Map<String, String> additionalHeaders, String httpVerb) throws IOException {
        return NetworkUtils.makeRequest(apiTypes, httpVerb, requestBody, this.jwtToken, additionalHeaders);
    }
}
