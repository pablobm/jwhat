package com.pablobm.jwhat.profiles;

public interface Feature {
	public String getName();
	public void setName(String name);

	public String toString();

	public String strValue();
	public String strValue(String value);
	public int intValue();
	public int intValue(int value);
	public boolean boolValue();
	public boolean boolValue(boolean value);
}
