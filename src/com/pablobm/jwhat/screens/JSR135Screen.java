package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.profiles.*;

public class JSR135Screen
	extends Form
	implements CommandListener {

	JWhatScreen parent;
	JSR135Support details;
	StringItem version;
	Hashtable properties;
	Command backCmd;

	public JSR135Screen(JWhatScreen parent) {
		super("JSR135");

		this.parent = parent;
		details = new JSR135Support();
		version = new StringItem("Version", details.getVersion());
		properties = buildPropertiesTable();
		backCmd = new Command("Back", Command.BACK, 1);

		addCommand(backCmd);
		setCommandListener(this);

		render();
	}

	public void render() {
		append(version);
		Enumeration props = properties.elements();

		while (props.hasMoreElements()) {
			append((Item)props.nextElement());
		}
	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == backCmd) {
			Display.getDisplay(parent.getMIDlet()).setCurrent((Screen)parent);
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
