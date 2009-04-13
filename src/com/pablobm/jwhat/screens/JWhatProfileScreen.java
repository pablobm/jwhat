package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.*;
import com.pablobm.jwhat.profiles.*;
import com.pablobm.jwhat.screens.*;

public abstract class JWhatProfileScreen
	extends JWhatScreen
	implements CommandListener {

	protected ProfileSupport details;
	protected StringItem version;
	protected Command backCmd;

	public JWhatProfileScreen(JWhatScreen parent, String name, ProfileSupport details) {
		super(parent, new Form(name));

		this.details = details;
		version = new StringItem("Version", details.getVersion());
		backCmd = new Command("Back", Command.BACK, 1);

		getForm().addCommand(backCmd);
		getForm().setCommandListener(this);

		render();
	}

	protected Form getForm() {
		return (Form)getScreen();
	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == backCmd) {
			getParent().display();
		}
	}

	protected Hashtable buildPropertiesTable() {
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

