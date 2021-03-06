package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;

import com.pablobm.jwhat.*;
import com.pablobm.jwhat.profiles.*;
import com.pablobm.jwhat.screens.*;

public class JWhatProfileScreen
	extends JWhatScreen
	implements CommandListener {

	protected ProfileSupport details;
	protected StringItem version;
	protected Command backCmd;

	public JWhatProfileScreen(JWhatScreen parent, ProfileSupport details) {
		super(parent, new Form(details.getName()));

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
	
	protected void render() {
		getForm().append(version);
		Enumeration props = buildPropertiesTable();

		while (props.hasMoreElements()) {
			getForm().append((Item)props.nextElement());
		}
	}

	protected Enumeration buildPropertiesTable() {
		Enumeration features = details.getFeatures();
		Vector ret = new Vector();
		Feature feature;

		while (features.hasMoreElements()) {
			feature  = (Feature)features.nextElement();
			ret.addElement(new StringItem(feature.getName(), feature.toString()));
		}

		return ret.elements();
	}

}

