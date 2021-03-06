package com.pablobm.jwhat.profiles;

import java.util.*;

public interface ProfileSupport
{
	public String getName();
	public String getLongName();
	public String getVersion();
	public String getDescription();
	public Enumeration getFeatures();
	public boolean isSupported();
}
