package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR75Screen
	extends JWhatScreen {

	JSR75Support details;
	Hashtable properties;
	StringItem version;

	public JSR75Screen(JWhatScreen parent) {
		super(parent, new Form("JSR75"));

		details = new JSR75Support();
		version = new StringItem("Version", details.getVersion());

		new Thread(new DetectionProcess()).start();
	}

	protected Form getForm() {
		return (Form)getScreen();
	}

	public void render() {
		getForm().append(version);
		Enumeration props = properties.elements();

		while (props.hasMoreElements()) {
			getForm().append((Item)props.nextElement());
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


	private class DetectionProcess
		implements Runnable {

		public void run() {
			properties = buildPropertiesTable();
			render();
		}
	}
}

