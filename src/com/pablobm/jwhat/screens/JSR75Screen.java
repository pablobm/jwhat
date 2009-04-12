package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR75Screen
	extends JWhatScreen
	implements CommandListener {

	JSR75Support details;
	Hashtable properties;
	StringItem version;
	Command backCmd;

	public JSR75Screen(JWhatScreen parent) {
		super(parent, new Form("JSR75"));

		details = new JSR75Support();
		version = new StringItem("Version", details.getVersion());
		backCmd = new Command("Back", Command.BACK, 1);

		getForm().addCommand(backCmd);
		getForm().setCommandListener(this);

		render();

		new Thread(new DetectionProcess()).start();
	}

	protected Form getForm() {
		return (Form)getScreen();
	}

	public void render() {
		render(false);
	}
	public void render(boolean detectionPerformed) {
		getForm().deleteAll();
		getForm().append(version);
		if (detectionPerformed) {
			Enumeration props = properties.elements();
			while (props.hasMoreElements()) {
				getForm().append((Item)props.nextElement());
			}
		}
		else {
			getForm().append(new StringItem("Available lists", "querying..."));
		}
	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == backCmd) {
			getParent().display();
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
			render(true);
		}
	}
}

