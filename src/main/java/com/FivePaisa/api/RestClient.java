package com.FivePaisa.api;

import com.FivePaisa.config.AppConfig;
import com.FivePaisa.service.APITypes;
import com.FivePaisa.service.ApiCalls;
import com.FivePaisa.service.Properties;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class RestClient {

    private String marketFeed = "MarketFeed";
    private String placeOrderRequest = "PlaceOrderRequest";
    private String modifyOrderRequest = "ModifyOrderRequest";
    private String cancelOrderRequest = "CancelOrderRequest";
    private String orderStatus = "V2/OrderStatus";
    private String margin = "V4/Margin";
    private String smoOrderRequest = "SMOOrderRequest";
    private String modifySmoOrder = "5PSModMOOrd";

    ApiCalls ac = new ApiCalls();
    Properties pr;
    AppConfig config;

    public RestClient(AppConfig config, Properties properties) {
        this.config = config;
        this.pr = properties;
    }

    public Response holdingV2(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.HOLDINGS);
    }

    public Response netPositionNetWiseV1(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.POSITIONS);
    }

    public Response marginV3(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.MARGIN);
    }

    public Response squareOff(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.SQUARE_OFF);
    }

    public Response tradeBook(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.TRADE_BOOK);
    }

    public Response orderBook(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.ORDER_BOOK);
    }

    public Response smoOrderRequest(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken(requestBody, smoOrderRequest, pr.requestCodeSmoOrderReq, config);
    }

    public Response modifySmoOrder(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken(requestBody, modifySmoOrder, pr.requestCodeModifySmoOrder, config);
    }

    public Response placeOrderRequest(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken(requestBody, placeOrderRequest, pr.orderRequest, config);
    }

    public Response modifyOrderRequest(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken(requestBody, modifyOrderRequest, pr.orderRequest, config);
    }

    public Response cancelOrderRequest(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken(requestBody, cancelOrderRequest, pr.orderRequest, config);
    }


    public Response marketFeed(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken((requestBody), marketFeed, pr.marketFeed, config);
    }

    public Response orderStatus(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken(requestBody, orderStatus, pr.orderStatus, config);
    }

    public void setJWTToken(String jwtToken) {
        this.ac.setJwtToken(jwtToken);
    }
}
