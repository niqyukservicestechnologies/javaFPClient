
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.FivePaisa.api.RestClient;
import com.FivePaisa.config.AppConfig;
import com.FivePaisa.service.Properties;

import okhttp3.Response;

public class TestJava {

    AppConfig config = new AppConfig();
    Properties properties = new Properties();

    RestClient apis = new RestClient(config, properties);
    JSONParser parser = new JSONParser();
    String jwtToken = "";

    public void setConfig() {

        config.setAppName("5P50917600");// eg 5P12345678
        config.setAppVer("1.0");
        config.setOsName("WEB");
        config.setEncryptKey("zmXOeiLBVvhCEYkcBdTZ2aTfsojPWvWa"); // eg.ABCDEFGHIJKLMNOPQURSTUVWXYZANCDE
        config.setKey("WjkVW3BPenaxAD46q5DSxBECquJFEvnY");// eg ABCDEFGHIJKLMNOPQURSTUVWXYZANCDEF
        config.setUserId("OipjgKOd03r");
        config.setPassword("gcwjZlmPbUG");// eg. ABCDEFGHIJK
        config.setLoginId("51447797");// eg 12345678
        properties.setClientcode("51447797");// eg 12345678
    }

    @Test
    public void HoldingV2() throws IOException, ParseException {
        setConfig();
        System.out.println(" \n ************* HoldingV2  ************* \n");
        JSONObject obj3 = new JSONObject();
        obj3.put("ClientCode", properties.clientcode);
        apis.setJWTToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjUwOTE3NjAwIiwicm9sZSI6Ildqa1ZXM0JQZW5heEFENDZxNURTeEJFQ3F1SkZFdm5ZIiwiU3RhdGUiOiIwZGIyYmQ1ZS02ZmIxLTQwODYtOTc3Ny1hMWYyZTExZTBhMWIiLCJuYmYiOjE3MDg0MDc5NzIsImV4cCI6MTcwODQwODAzMiwiaWF0IjoxNzA4NDA3OTcyfQ.5MzPKQNbJfMNRgz2M2v3ga435XDX1jubY50NYtmfMt8");
        Response response = apis.holdingV2(obj3);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void OrderRequest() throws IOException, ParseException {
        setConfig();
        System.out.println(" \n ************* OrderRequest  ************* \n");
        JSONObject obj3 = new JSONObject();
        obj3.put("ClientCode", properties.clientcode);
        obj3.put("OrderFor", "P");
        obj3.put("Exchange", "N");
        obj3.put("ExchangeType", "C");
        obj3.put("Price", 200);
        obj3.put("OrderID", 2);
        obj3.put("OrderType", "BUY");
        obj3.put("Qty", 1);
        obj3.put("OrderDateTime", "/Date(1563857357612)/");
        obj3.put("ScripCode", 1660);
        obj3.put("AtMarket", false);
        obj3.put("RemoteOrderID", "s0002201907231019172");
        obj3.put("ExchOrderID", 0);
        obj3.put("DisQty", 1);
        obj3.put("IsStopLossOrder", false);
        obj3.put("StopLossPrice", 0);
        obj3.put("IsVTD", false);
        obj3.put("IOCOrder", false);
        obj3.put("IsIntraday", false);
        obj3.put("PublicIP", "192.168.84.215");
        obj3.put("AHPlaced", "N");
        obj3.put("ValidTillDate", "/Date(1600248018615)/");
        obj3.put("iOrderValidity", 0);
        obj3.put("OrderRequesterCode", properties.clientcode);
        obj3.put("TradedQty", 0);
        obj3.put("AppSource", properties.AppSource);
        // obj3.put("OrderDateTime", "/Date(" + System.currentTimeMillis() + ")/");
        // obj3.put("ValidTillDate", "/Date(" + System.currentTimeMillis() + ")/");
        apis.setJWTToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjUwOTE3NjAwIiwicm9sZSI6Ildqa1ZXM0JQZW5heEFENDZxNURTeEJFQ3F1SkZFdm5ZIiwiU3RhdGUiOiIwZGIyYmQ1ZS02ZmIxLTQwODYtOTc3Ny1hMWYyZTExZTBhMWIiLCJuYmYiOjE3MDg0MDc5NzIsImV4cCI6MTcwODQwODAzMiwiaWF0IjoxNzA4NDA3OTcyfQ.5MzPKQNbJfMNRgz2M2v3ga435XDX1jubY50NYtmfMt8");
        // System.out.println("\n JSON OBJ >> " + obj3.toJSONString());
        Response response = null;
        try {
             response = apis.placeOrderRequest(obj3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String resp = response.body().string();
        System.out.println("\n Response =========>> " + resp);

        assertTrue(response.isSuccessful());
    }

    @Test
    public void MarginV3() throws IOException, ParseException {
        setConfig();
        System.out.println(" \n ************* MarginV3  ************* \n");
        JSONObject obj3 = new JSONObject();
        obj3.put("ClientCode", properties.clientcode);
        ;
        Response response = apis.marginV3(obj3);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void OrderBookV2() throws IOException, ParseException {
        setConfig();
        System.out.println(" \n ************* OrderBookV2  ************* \n");
        JSONObject obj3 = new JSONObject();
        obj3.put("ClientCode", properties.clientcode);
        Response response = apis.orderBookV2(obj3);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void NetPositionNetWiseV1() throws IOException, ParseException {
        setConfig();
        System.out.println(" \n ************* NetPositionNetWiseV1  ************* \n");
        JSONObject obj3 = new JSONObject();
        obj3.put("ClientCode", properties.clientcode);
        Response response = apis.netPositionNetWiseV1(obj3);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void MarketFeed() throws IOException, ParseException {
        setConfig();
        System.out.println(" ************* NetPositionNetWiseV1  *************");

        JSONObject obj3 = new JSONObject();
        JSONObject ordStatusReqObj = new JSONObject();
        List<JSONObject> ordStatusListReqObj = new ArrayList<JSONObject>();
        ordStatusReqObj.put("Exch", "N");
        ordStatusReqObj.put("ExchType", "C");
        ordStatusReqObj.put("Symbol", "BHEL");
        ordStatusReqObj.put("Expiry", "");
        ordStatusReqObj.put("StrikePrice", "0");
        ordStatusReqObj.put("OptionType", "");

        JSONObject ordStatusReqObj2 = new JSONObject();
        ordStatusReqObj2.put("Exch", "N");
        ordStatusReqObj2.put("ExchType", "C");
        ordStatusReqObj2.put("Symbol", "INFY 29 Oct 2020");
        ordStatusReqObj2.put("Expiry", "20201029");
        ordStatusReqObj2.put("StrikePrice", "0");
        ordStatusReqObj2.put("OptionType", "XX");

        ordStatusListReqObj.add(ordStatusReqObj);
        ordStatusListReqObj.add(ordStatusReqObj2);

        obj3.put("Count", 2);
        obj3.put("ClientLoginType", 0);
        obj3.put("LastRequestTime", "/Date(1600248018615)/");
        obj3.put("RefreshRate", "H");
        obj3.put("MarketFeedData", ordStatusListReqObj);

        Response response = apis.marketFeed(obj3);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void OrderStatus() throws IOException, ParseException {
        setConfig();

        System.out.println(" \n ************* OrderStatus  ************* \n");

        JSONObject obj3 = new JSONObject();
        JSONObject ordStatusReqObj = new JSONObject();
        List<JSONObject> ordStatusListReqObj = new ArrayList<JSONObject>();
        ordStatusReqObj.put("Exch", "N");
        ordStatusReqObj.put("RemoteOrderID", "<Enter the RemoteOrderID here>");
        ordStatusListReqObj.add(ordStatusReqObj);
        obj3.put("ClientCode", properties.clientcode);
        obj3.put("OrdStatusReqList", ordStatusListReqObj);
        Response response = apis.orderStatus(obj3);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void TradeInformation() throws IOException, ParseException {
        setConfig();

        System.out.println(" \n ************* TradeInformation  ************* \n");

        JSONObject obj3 = new JSONObject();
        JSONObject ordStatusReqObj = new JSONObject();
        List<JSONObject> ordStatusListReqObj = new ArrayList<JSONObject>();
        ordStatusReqObj.put("Exch", "B");
        ordStatusReqObj.put("ExchType", "C");
        ordStatusReqObj.put("ScripCode", 3045);
        ordStatusReqObj.put("RemoteOrderID", "<Enter the RemoteOrderID here>");
        ordStatusListReqObj.add(ordStatusReqObj);
        obj3.put("ClientCode", properties.clientcode);
        obj3.put("TradeDetailList", ordStatusListReqObj);

        Response response = apis.tradeInformation(obj3);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void smoOrderReq() throws IOException, ParseException {
        setConfig();

        System.out.println(" \n ************* smoOrderReq  ************* \n");

        JSONObject smoOrderOb = new JSONObject();

        smoOrderOb.put("ClientCode", properties.clientcode);
        smoOrderOb.put("OrderRequesterCode", "52502185");
        smoOrderOb.put("RequestType", "P");
        smoOrderOb.put("BuySell", "B");
        smoOrderOb.put("Qty", 1);
        smoOrderOb.put("Exch", "B");
        smoOrderOb.put("ExchType", "C");
        smoOrderOb.put("DisQty", 0);
        smoOrderOb.put("AtMarket", true);
        smoOrderOb.put("ExchOrderId", 0);
        smoOrderOb.put("LimitPriceInitialOrder", 0);
        smoOrderOb.put("TriggerPriceInitialOrder", "0");
        smoOrderOb.put("LimitPriceProfitOrder", 420);
        smoOrderOb.put("LimitPriceForSL", 0);
        smoOrderOb.put("TriggerPriceForSL", 386);
        smoOrderOb.put("TrailingSL", 0);
        smoOrderOb.put("StopLoss", 0);
        smoOrderOb.put("ScripCode", "532215");
        smoOrderOb.put("OrderFor", "S");
        smoOrderOb.put("UniqueOrderIDNormal", "5000009120154900067");
        smoOrderOb.put("UniqueOrderIDSL", 0);
        smoOrderOb.put("UniqueOrderIDLimit", 0);
        smoOrderOb.put("LocalOrderIDNormal", 5);
        smoOrderOb.put("LocalOrderIDSL", 0);
        smoOrderOb.put("LocalOrderIDLimit", 0);
        // smoOrderOb.put("PublicIP", "");
        smoOrderOb.put("AppSource", 6);
        smoOrderOb.put("TradedQty", 0);

        Response response = apis.smoOrderRequest(smoOrderOb);
        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }

    @Test
    public void modifySmoOrder() throws IOException, ParseException {
        setConfig();

        System.out.println(" \n ************* modifySmoOrder  ************* \n");
        JSONObject modifysmoOrderOb = new JSONObject();

        modifysmoOrderOb.put("ClientCode", properties.clientcode);

        modifysmoOrderOb.put("OrderFor", "M");
        modifysmoOrderOb.put("Exchange", "B");
        modifysmoOrderOb.put("ExchangeType", "C");
        modifysmoOrderOb.put("Price", 717.65);
        modifysmoOrderOb.put("OrderID", 0);
        modifysmoOrderOb.put("OrderType", "BUY");
        modifysmoOrderOb.put("Qty", 1);
        modifysmoOrderOb.put("OrderDateTime", "/Date(1569396922334)/");
        modifysmoOrderOb.put("ScripCode", 532215);
        modifysmoOrderOb.put("AtMarket", false);
        modifysmoOrderOb.put("RemoteOrderID", "5000009120154900067");
        modifysmoOrderOb.put("ExchOrderID", "1606801033587000415");
        modifysmoOrderOb.put("DisQty", 0);
        modifysmoOrderOb.put("TriggerPriceForSL", 386);
        modifysmoOrderOb.put("IsStopLossOrder", false);
        modifysmoOrderOb.put("IOCOrder", true);
        modifysmoOrderOb.put("IsIntraday", false);
        modifysmoOrderOb.put("IsVTD", false);
        modifysmoOrderOb.put("AHPlaced", "N");
        modifysmoOrderOb.put("iOrderValidity", 0);
        modifysmoOrderOb.put("TradedQty", 0);
        modifysmoOrderOb.put("OrderRequesterCode", "59999998");
        modifysmoOrderOb.put("TrailingSL", 0.02);
        modifysmoOrderOb.put("LegType", 0);
        // smoOrderOb.put("PublicIP", "");
        modifysmoOrderOb.put("AppSource", 6);
        modifysmoOrderOb.put("TMOPartnerOrderID", 0);

        Response response = apis.smoOrderRequest(modifysmoOrderOb);

        System.out.println("\n Response >> " + response.body().string());
        assertTrue(response.isSuccessful());
    }
}
