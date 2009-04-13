package com.pablobm.jwhat.profiles;

import java.util.*;

public class WMASupport
	extends BaseProfileSupport
{
	public WMASupport() {
		name = "WMA";
		version = detectVersion();
		longName = "Wireless Messaging API";
		description = "Access to wireless communication resources";
	}

	public Enumeration getFeatures() {
		return new Vector().elements();
	}

	private String detectVersion() {
		String ret = "1.0";
		
		try {
			if (javax.wireless.messaging.MessageConnection.MULTIPART_MESSAGE == "multipart") {
				ret = "2.0";
			}
		}
		catch(Exception e) {
			// Do nothing
		}

		return ret;
	}
}

