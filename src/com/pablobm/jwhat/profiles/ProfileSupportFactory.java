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
		ret.addElement(new MIDPSupport());
		ret.addElement(new JSR75Support());
		ret.addElement(new JSR135Support());
		ret.addElement(new WMASupport());
		ret.addElement(new JSR184Support());
		ret.addElement(new JSR177Support());
		ret.addElement(new JSR82Support());
		return ret.elements();
	}
}
