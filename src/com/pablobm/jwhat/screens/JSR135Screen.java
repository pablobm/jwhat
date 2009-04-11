package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR135Screen
	extends Form {

	Screen parent;
	JSR135Support details;
	StringItem version;
	Hashtable properties;

	public JSR135Screen(Screen parent) {
		super("JSR135");

		this.parent = parent;
		details = new JSR135Support();
		version = new StringItem("Version", details.getVersion());
		properties = buildPropertiesTable();

		render();
	}

	public void render() {
		append(version);
		Enumeration props = properties.elements();

		while (props.hasMoreElements()) {
			append((Item)props.nextElement());
		}
	}

	private Hashtable buildPropertiesTable() {
		Hashtable features = details.getFeatures();
		Enumeration keys = features.keys();
		Hashtable ret = new Hashtable();
		Feature feature;

		while (keys.hasMoreElements()) {
			feature  = (Feature)features.get(keys.nextElement());
			ret.put(feature, new StringItem(feature.getName(), feature.toString()));
		}

		return ret;
	}
}
