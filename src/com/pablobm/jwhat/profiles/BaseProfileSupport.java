package com.pablobm.jwhat.profiles;

public abstract class BaseProfileSupport
	implements ProfileSupport
{
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
		if (summary == null) {
			summary = composeSummary();
		}

		return summary;
	}
	public String getVersion() {
		return version;
	}
	public boolean isSupported() {
		return version != null;
	}
	
	protected boolean boolProp(String property) {
		return System.getProperty(property).equals("true");
	}
	protected String strProp(String property) {
		return System.getProperty(property);
	}
	protected String composeSummary() {
		return summary;
	}
}
