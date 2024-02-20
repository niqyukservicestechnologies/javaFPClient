package com.FivePaisa.service;

public class Properties {

	public static int threadTime = 500;

	public String requestCodeLoginv2 = "5PLoginV2";
	public String requestCodeLoginv3 = "5PLoginV3";
	public String requestCodeLoginv4 = "5PLoginV4";
	public String requestCodeLoginCheck = "5PLoginCheck";

	public String requestCodeSmoOrderReq = "SMOOrderRequest";

	public String requestCodeModifySmoOrder = "5PSModMOOrd";

	public String holding = "5PMarginV3";

	public String marketFeed = "5PMF";

	public String orderRequest = "5POrdReq";

	public String orderStatus = "5POrdStatus";

	public String tradeInformation = "5PTrdInfo";

	public String margin = "5PMarginV3";

	public String orderBook = "5POrdBkV2";

	public String netPositionNetWise = "5PNPNWV1";
	public String clientcode = "51447797";
	public int AppSource = 19184;// Your App source;

	public String remoteIpAddress = "192.0.0.0";
	public String machineID = "039377";

	public Properties() {

	}

	// public final String encryptKey = "Your Encryption key";
	public int getThreadTime() {
		return threadTime;
	}

	public void setThreadTime(int threadTime) {
		this.threadTime = threadTime;
	}

	public String getClientcode() {
		return clientcode;
	}

	public void setClientcode(String clientcode) {
		this.clientcode = clientcode;
	}

	public int getAppSource() {
		return AppSource;
	}

	public void setAppSource(int appSource) {
		AppSource = appSource;
	}

	public String getRequestCodeLoginv2() {
		return requestCodeLoginv2;
	}

	public void setRequestCodeLoginv2(String requestCodeLoginv2) {
		this.requestCodeLoginv2 = requestCodeLoginv2;
	}

	public String getRequestCodeLoginv3() {
		return requestCodeLoginv3;
	}

	public void setRequestCodeLoginv3(String requestCodeLoginv3) {
		this.requestCodeLoginv3 = requestCodeLoginv3;
	}

	public String getRequestCodeLoginv4() {
		return requestCodeLoginv4;
	}

	public void setRequestCodeLoginv4(String requestCodeLoginv4) {
		this.requestCodeLoginv4 = requestCodeLoginv4;
	}

	public String getRequestCodeLoginCheck() {
		return requestCodeLoginCheck;
	}

	public void setRequestCodeLoginCheck(String requestCodeLoginCheck) {
		this.requestCodeLoginCheck = requestCodeLoginCheck;
	}

	public String getRequestCodeSmoOrderReq() {
		return requestCodeSmoOrderReq;
	}

	public void setRequestCodeSmoOrderReq(String requestCodeSmoOrderReq) {
		this.requestCodeSmoOrderReq = requestCodeSmoOrderReq;
	}

	public String getRequestCodeModifySmoOrder() {
		return requestCodeModifySmoOrder;
	}

	public void setRequestCodeModifySmoOrder(String requestCodeModifySmoOrder) {
		this.requestCodeModifySmoOrder = requestCodeModifySmoOrder;
	}

	public String getHolding() {
		return holding;
	}

	public void setHolding(String holding) {
		this.holding = holding;
	}

	public String getMarketFeed() {
		return marketFeed;
	}

	public void setMarketFeed(String marketFeed) {
		this.marketFeed = marketFeed;
	}

	public String getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(String orderRequest) {
		this.orderRequest = orderRequest;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getTradeInformation() {
		return tradeInformation;
	}

	public void setTradeInformation(String tradeInformation) {
		this.tradeInformation = tradeInformation;
	}

	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	public String getOrderBook() {
		return orderBook;
	}

	public void setOrderBook(String orderBook) {
		this.orderBook = orderBook;
	}

	public String getNetPositionNetWise() {
		return netPositionNetWise;
	}

	public void setNetPositionNetWise(String netPositionNetWise) {
		this.netPositionNetWise = netPositionNetWise;
	}

	public String getRemoteIpAddress() {
		return remoteIpAddress;
	}

	public void setRemoteIpAddress(String remoteIpAddress) {
		this.remoteIpAddress = remoteIpAddress;
	}

	public String getMachineID() {
		return machineID;
	}

	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}

}
