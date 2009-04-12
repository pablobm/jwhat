package com.pablobm.jwhat.screens;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.*;
import com.pablobm.jwhat.profiles.*;
import com.pablobm.jwhat.screens.*;

public class MainScreen
	extends JWhatScreen
	implements CommandListener {

	private Command exitCmd;
	private Command detailsCmd;

	public MainScreen() {
		super(null, new List("Supported Java profiles", List.IMPLICIT));
		exitCmd = new Command("Exit", Command.EXIT, 1);
		detailsCmd = new Command("Details", Command.ITEM, 2);

		render();
		getScreen().addCommand(exitCmd);
		getScreen().addCommand(detailsCmd);
		getScreen().setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == exitCmd) {
			getMIDlet().exit();
		}
		else if (cmd == detailsCmd) {
			new JSR135Screen(this).display();
		}
	}

	protected List getList() {
		return (List)getScreen();
	}
	
	private void render() {
		ProfileSupportFactory psf = ProfileSupportFactory.getInstance();
		Enumeration profiles = psf.createAll();
		
		while(profiles.hasMoreElements()) {
			ProfileSupport ps = (ProfileSupport)profiles.nextElement();
			String line = ps.getName() + ": v" + ps.getVersion();
			getList().append(line, null);
		}
	}
}

