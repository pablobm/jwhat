package com.pablobm.jwhat.profiles;

public interface ProfileSupport
{
	public String getName();
	public String getLongName();
	public String getVersion();
	public String getDescription();
	public boolean isSupported();
}
