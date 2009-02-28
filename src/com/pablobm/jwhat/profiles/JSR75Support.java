package com.pablobm.jwhat.profiles;

public class JSR75Support
	extends BaseProfileSupport
{
	public JSR75Support() {
		name = "JSR-75";
		longName = "PDA Optional Packages";
		version = System.getProperty("microedition.pim.version");
		description = "Access to filesystem and PIM data.";
		summary = composeSummary();
		supportLevel = version == null ? NO_SUPPORT : SUPPORTED;
	}

	
	private String composeSummary() {
		return "test";
	}
}

