package com.pablobm.jwhat.profiles;

public interface ProfileSupport
{
	public final int NO_SUPPORT = 0;
	public final int SUPPORTED = 1;
	public final int PARTIAL = 2;
	
	public String getName();
	public String getLongName();
	public String getVersion();
	public String getDescription();
	public String getSummary();
	public boolean hasSupport();
	public boolean hasPartialSupport();
	public boolean hasNoSupport();
}
