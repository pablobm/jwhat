package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR75Screen
	extends JWhatProfileScreen {

	public JSR75Screen(JWhatScreen parent) {
		super(parent, new JSR75Support());
	}

	protected void render() {
		render(null);
	}
	protected void render(Hashtable properties) {
		getForm().deleteAll();
		getForm().append(version);
		if (properties != null) {
			Enumeration props = properties.elements();
			while (props.hasMoreElements()) {
				getForm().append((Item)props.nextElement());
			}
		}
		else {
			getForm().append(new StringItem("Available lists", "querying..."));
			new Thread(new DetectionProcess()).start();
		}
	}

	private class DetectionProcess
		implements Runnable {

		public void run() {
			render(buildPropertiesTable());
		}
	}
}

