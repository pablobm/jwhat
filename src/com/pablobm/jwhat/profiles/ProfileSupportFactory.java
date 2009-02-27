package com.pablobm.jwhat.profiles;

import java.util.*;

public class ProfileSupportFactory
{
	private ProfileSupportFactory() {
	}
	
	public static ProfileSupportFactory instance = null;
	public static synchronized ProfileSupportFactory getInstance() {
		if (instance == null) {
			instance = new ProfileSupportFactory();
		}
		return instance;
	}
	
	public Enumeration createAll() {
		Vector ret = new Vector();
		ret.addElement(new JSR75Support());
		return ret.elements();
	}
}