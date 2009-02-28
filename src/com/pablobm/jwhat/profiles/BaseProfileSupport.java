package com.pablobm.jwhat.profiles;

public abstract class BaseProfileSupport
	implements ProfileSupport
{
	protected final int NO_SUPPORT = 0;
	protected final int SUPPORTED = 1;
	protected final int PARTIAL = 2;

	protected String name;
	protected String longName;
	protected String version;
	protected String description;
	protected String summary;
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
	public String getSummary() {
		return summary;
	}
	public String getVersion() {
		return version;
	}
	public boolean hasSupport() {
		return supportLevel == SUPPORTED;
	}
	public boolean hasPartialSupport() {
		return supportLevel == PARTIAL;
	}
	public boolean hasNoSupport() {
		return supportLevel == NO_SUPPORT;
	}
	
	
	protected boolean boolProp(String property) {
		return System.getProperty(property).equals("true");
	}
	protected String strProp(String property) {
		return System.getProperty(property);
	}
}
