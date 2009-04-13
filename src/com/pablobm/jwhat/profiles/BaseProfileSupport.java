package com.pablobm.jwhat.profiles;

import java.util.*;

public abstract class BaseProfileSupport
	implements ProfileSupport
{
	protected String name;
	protected String longName;
	protected String version;
	protected String description;
	protected int supportLevel;
	
	public String getName() {
		return name;
	}
	public String getLongName() {
		return longName;
	}
	public String getDescription() {
		return description;
	}
	public String getVersion() {
		return version;
	}
	public boolean isSupported() {
		return version != null;
	}

	public abstract Enumeration getFeatures();
	
	protected boolean boolProp(String property) {
		return System.getProperty(property).equals("true");
	}
	protected String strProp(String property) {
		return System.getProperty(property);
	}
}

