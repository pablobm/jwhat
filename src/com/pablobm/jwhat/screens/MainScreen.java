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
	private Vector profiles;

	public MainScreen() {
		super(null, new List("Supported Java profiles", List.IMPLICIT));
		exitCmd = new Command("Exit", Command.EXIT, 1);
		detailsCmd = new Command("Details", Command.ITEM, 2);
		profiles = new Vector();

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
			changeScreen(getList().getSelectedIndex());
		}
	}

	protected List getList() {
		return (List)getScreen();
	}
	
	protected void render() {
		ProfileSupportFactory psf = ProfileSupportFactory.getInstance();
		Enumeration profileList = psf.createAll();
		
		while(profileList.hasMoreElements()) {
			ProfileSupport ps = (ProfileSupport)profileList.nextElement();
			String line = ps.getName() + ": v" + ps.getVersion();
			getList().append(line, null);
			profiles.addElement(ps);
		}
	}

	private void changeScreen(int index) {
		ProfileSupport profile = (ProfileSupport)profiles.elementAt(index);

		if (profile instanceof JSR135Support) {
			new JSR135Screen(this).display();
		}
		else if (profile instanceof JSR75Support) {
			new JSR75Screen(this).display();
		}
		else {
			System.out.println("I don't know what screen to show");
		}
	}
}

