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

    public String holdingV2(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.HOLDINGS);
    }

    public String netPositionNetWiseV1(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.POSITIONS);
    }

    public String marginV3(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.MARGIN);
    }

    public String squareOff(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.SQUARE_OFF);
    }

    public String tradeBook(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.TRADE_BOOK);
    }

    public String placeOrder(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.PLACE_ORDER);
    }

    public String placeBracketOrder(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.PLACE_BRACKET_ORDER);
    }


    public String orderBook(JSONObject requestBody) throws IOException {
        return ac.callPOSTWithAccessToken(requestBody, APITypes.ORDER_BOOK);
    }

    public Response smoOrderRequest(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken2(requestBody, smoOrderRequest, pr.requestCodeSmoOrderReq, config);
    }

    public Response modifySmoOrder(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken2(requestBody, modifySmoOrder, pr.requestCodeModifySmoOrder, config);
    }

    public Response modifyOrderRequest(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken2(requestBody, modifyOrderRequest, pr.orderRequest, config);
    }

    public Response cancelOrderRequest(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken2(requestBody, cancelOrderRequest, pr.orderRequest, config);
    }


    public Response marketFeed(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken2((requestBody), marketFeed, pr.marketFeed, config);
    }

    public Response orderStatus(JSONObject requestBody) throws IOException, ParseException {
        return ac.callPOSTWithAccessToken2(requestBody, orderStatus, pr.orderStatus, config);
    }

    public void setJWTToken(String jwtToken) {
        this.ac.setJwtToken(jwtToken);
    }
}
