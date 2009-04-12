package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR135Screen
	extends JWhatScreen
	implements CommandListener {

	JSR135Support details;
	StringItem version;
	Hashtable properties;
	Command backCmd;

	public JSR135Screen(JWhatScreen parent) {
		super(parent, new Form("JSR135"));

		details = new JSR135Support();
		version = new StringItem("Version", details.getVersion());
		properties = buildPropertiesTable();
		backCmd = new Command("Back", Command.BACK, 1);

		getForm().addCommand(backCmd);
		getForm().setCommandListener(this);

		render();
	}

	public Form getForm() {
		return (Form)getScreen();
	}

	public void render() {
		getForm().append(version);
		Enumeration props = properties.elements();

		while (props.hasMoreElements()) {
			getForm().append((Item)props.nextElement());
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
}
