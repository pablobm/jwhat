package com.pablobm.jwhat.profiles;

import java.util.*;

public class JSR82Support
	extends BaseProfileSupport
{
	public JSR82Support() {
		name = "JSR-82";
		version = readVersion();
		longName = "Mobile Media API";
		description = "Handling of media content and protocols";
	}

	public Enumeration getFeatures() {
		Vector ret = new Vector();
		
		storeStringFeature(ret, "bluetooth.master.switch");
		storeStringFeature(ret, "bluetooth.sd.attr.retrievable.max");
		storeStringFeature(ret, "bluetooth.connected.devices.max");
		storeStringFeature(ret, "bluetooth.l2cap.receiveMTU.max");
		storeStringFeature(ret, "bluetooth.sd.trans.max");
		storeStringFeature(ret, "bluetooth.connected.inquiry.scan");
		storeStringFeature(ret, "bluetooth.connected.page.scan");
		storeStringFeature(ret, "bluetooth.connected.inquiry");
		storeStringFeature(ret, "bluetooth.connected.page");
		
		return ret.elements();
	}

	private String readVersion() {
		String ret = null;
		
		try {
			Class.forName("javax.bluetooth.LocalDevice");
			ret = javax.bluetooth.LocalDevice.getProperty("bluetooth.api.version");
		}
		catch (ClassNotFoundException e) {
			// Ignore
		}
		
		return ret;
	}
	
	private void storeStringFeature(Vector storage, String featureName) {
		storage.addElement(new BaseFeature(featureName, strProp(featureName)));
	}
	
	protected String strProp(String property) {
		return System.getProperty(property);
	}


}

