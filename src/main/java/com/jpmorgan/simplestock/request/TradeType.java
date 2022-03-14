package com.jpmorgan.simplestock.request;

public enum TradeType {

	Buy("Buy"), Sell("Sell");
	
	private String type;
	
	TradeType(final String type) {
		this.type = type;
	}

	public static TradeType fromValue(String value) {
		for (TradeType b : TradeType.values()) {
			if (b.type.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
