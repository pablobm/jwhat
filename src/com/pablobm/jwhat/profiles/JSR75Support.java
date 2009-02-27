package com.pablobm.jwhat.profiles;

public class JSR75Support
	extends BaseProfileSupport
{
	public JSR75Support() {
		name = "JSR-75";
		version = System.getProperty("microedition.pim.version");
		supportLevel = version == null ? NO_SUPPORT : SUPPORTED;
	}
}

