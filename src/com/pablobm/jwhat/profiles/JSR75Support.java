package com.pablobm.jwhat.profiles;

import java.util.*;
import javax.microedition.pim.*;

public class JSR75Support
	extends BaseProfileSupport
{
	public JSR75Support() {
		name = "JSR-75";
		longName = "PDA Optional Packages";
		version = System.getProperty("microedition.pim.version");
		description = "Access to filesystem and PIM data.";
		summary = composeSummary();
	}

	private String composeSummary() {
		if ( ! isSupported()) {
			return "no support";
		}
		
		Hashtable lists = new Hashtable();
		lists.put(new Integer(PIM.CONTACT_LIST), "contacts");
		lists.put(new Integer(PIM.EVENT_LIST), "events");
		lists.put(new Integer(PIM.TODO_LIST), "todos");
		
		PIM pim = PIM.getInstance();
		String ret = "";
		Enumeration types = lists.keys();
		while (types.hasMoreElements()) {
			int type = ((Integer)types.nextElement()).intValue();
			boolean supported = true;
			try {
				pim.openPIMList(type, PIM.READ_ONLY);
			}
			catch (PIMException e) {
				supported = false;
			}
			
			if (supported) {
				ret += " " + (String)lists.get(new Integer(type));
			}
		}
		
		return ret;
	}
}

