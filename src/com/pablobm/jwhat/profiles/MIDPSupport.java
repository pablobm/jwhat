package com.pablobm.jwhat.profiles;

import java.util.*;

public class MIDPSupport
	extends BaseProfileSupport
{
	public MIDPSupport() {
		name = "MIDP";
		version = System.getProperty("microedition.profiles");
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

	private void storeStringFeature(Vector storage, String featureName) {
		storage.addElement(new BaseFeature(featureName, strProp(featureName)));
	}
}

