package com.pablobm.jwhat.profiles;

public class JSR75Support {

	public final int NO_SUPPORT = 0;
	public final int SUPPORTED = 1;

	public final String name;
	public String version;
	public int supportLevel;
	
	public JSR75Support() {
		name = "JSR-75";
		version = System.getProperty("microedition.pim.version");
		supportLevel = version == null ? NO_SUPPORT : SUPPORTED;
	}
}

