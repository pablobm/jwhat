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
	}

	public Hashtable getFeatures() {
		Hashtable ret = new Hashtable();

		Hashtable lists = new Hashtable();
		lists.put(new Integer(PIM.CONTACT_LIST), "contacts");
		lists.put(new Integer(PIM.EVENT_LIST), "events");
		lists.put(new Integer(PIM.TODO_LIST), "todos");

		PIM pim = PIM.getInstance();
		Enumeration types = lists.keys();
		while (types.hasMoreElements()) {
			int type = ((Integer)types.nextElement()).intValue();
			String listName = (String)lists.get(new Integer(type));
			boolean supported = true;

			try {
				pim.openPIMList(type, PIM.READ_ONLY);
			}
			catch (PIMException e) {
				supported = false;
			}

			ret.put(listName, new BaseFeature(listName, supported));
		}

		return ret;
	}
}

