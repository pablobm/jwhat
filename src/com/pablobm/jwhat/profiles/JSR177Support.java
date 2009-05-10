package com.pablobm.jwhat.profiles;

import java.util.*;

public class JSR177Support
	extends BaseProfileSupport
{
	public JSR177Support() {
		name = "JSR-177";
		version = System.getProperty("microedition.smartcardslots") == null ? null : "1.0";
		longName = "Security and Trust Services API";
		description = "Cryptographic package";
	}

	public Enumeration getFeatures() {
		Vector ret = new Vector();

		storeStringFeature(ret, "microedition.smartcardslots");

		return ret.elements();
	}

	private void storeStringFeature(Vector storage, String featureName) {
		storage.addElement(new BaseFeature(featureName, strProp(featureName)));
	}
}

