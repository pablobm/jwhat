package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.*;
import com.pablobm.jwhat.profiles.*;
import com.pablobm.jwhat.screens.*;

public class MainScreen
	extends List
	implements CommandListener, JWhatScreen {

	private JWhatMidlet midlet;
	private Command exitCmd;
	private Command detailsCmd;

	public MainScreen(JWhatMidlet midlet) {
		super("Supported Java profiles", List.IMPLICIT);
		this.midlet = midlet;
		exitCmd = new Command("Exit", Command.EXIT, 1);
		detailsCmd = new Command("Details", Command.ITEM, 2);

		createScreen();
		addCommand(exitCmd);
		addCommand(detailsCmd);
		setCommandListener(this);
	}

	public JWhatScreen getParent() {
		return this;
	}

	public JWhatMidlet getMIDlet() {
		return midlet;
	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == exitCmd) {
			getMIDlet().exit();
		}
		else if (cmd == detailsCmd) {
			Display.getDisplay(getMIDlet()).setCurrent(new JSR135Screen(this));
		}
	}
	
	private void createScreen() {
		ProfileSupportFactory psf = ProfileSupportFactory.getInstance();
		Enumeration profiles = psf.createAll();
		
		while(profiles.hasMoreElements()) {
			ProfileSupport ps = (ProfileSupport)profiles.nextElement();
			String line = ps.getName() + ": v" + ps.getVersion();
			append(line, null);
		}
	}
}

