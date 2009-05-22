package com.pablobm.jwhat.profiles;

import java.util.*;

public class MIDPSupport
	extends BaseProfileSupport
{
	public MIDPSupport() {
		String versionString = System.getProperty("microedition.profiles");
		name = "MIDP";
		version = versionString.substring(versionString.indexOf('-')+1);
		longName = "Mobile Information Device Profile";
		description = "Architecture and APIs for mobile applications development";
	}

	public Enumeration getFeatures() {
		Vector ret = new Vector();

		storeStringFeature(ret, "microedition.profiles");
		storeStringFeature(ret, "microedition.configuration");
		storeStringFeature(ret, "microedition.locale");
		storeStringFeature(ret, "microedition.commports");
		storeStringFeature(ret, "microedition.hostname");

		return ret.elements();
	}
}

