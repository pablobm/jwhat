package com.pablobm.jwhat.profiles;

import java.util.*;

public class JSR184Support
	extends BaseProfileSupport
{
	public JSR184Support() {
		name = "JSR-184";
		version = System.getProperty("microedition.m3g.version");
		longName = "Mobile 3D Graphics API";
		description = "3D graphics for platforms with low processing power";
	}

	public Enumeration getFeatures() {
		return null;
	}
}

