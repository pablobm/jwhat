package com.pablobm.jwhat.profiles;

public abstract class BaseProfileSupport
	implements ProfileSupport
{
	protected final int NO_SUPPORT = 0;
	protected final int SUPPORTED = 1;
	protected final int PARTIAL = 2;

	protected String name;
	protected String version;
	protected int supportLevel;
	
	public String getName() {
		return name;
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
}
