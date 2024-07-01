package com.automationexcercise.browsers;

public enum Browser {
	
	CHROME("Google Chrome"),
	EDGE("Microsoft Edge");

	private String browserCompanies;
	
	Browser(String string) {
		this.browserCompanies = string;
	}

	public String getBrowserCompanies() {
		return browserCompanies;
	}

}
