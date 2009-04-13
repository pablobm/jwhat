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

	public Enumeration getFeatures() {
		Vector ret = new Vector();

		PIM pim = PIM.getInstance();
		Enumeration lists = getPIMLists();
		while (lists.hasMoreElements()) {
			PIMList list = (PIMList)lists.nextElement();
			boolean supported = true;

			try {
				pim.openPIMList(list.id, PIM.READ_ONLY);
			}
			catch (PIMException e) {
				supported = false;
			}

			ret.addElement(new BaseFeature(list.name, supported));
		}

		return ret.elements();
	}

	private Enumeration getPIMLists() {
		Vector lists = new Vector();
		lists.addElement(new PIMList(PIM.CONTACT_LIST, "contacts"));
		lists.addElement(new PIMList(PIM.EVENT_LIST, "events"));
		lists.addElement(new PIMList(PIM.TODO_LIST, "todos"));
		return lists.elements();
	}

	private class PIMList {
		public int id;
		public String name;

		public PIMList(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}

