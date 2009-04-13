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
	protected void render(Enumeration properties) {
		getForm().deleteAll();
		getForm().append(version);
		if (properties != null) {
			while (properties.hasMoreElements()) {
				getForm().append((Item)properties.nextElement());
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

