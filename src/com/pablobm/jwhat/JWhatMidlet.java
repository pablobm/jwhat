package com.pablobm.jwhat;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.profiles.*;
import com.pablobm.jwhat.screens.*;

public class JWhatMidlet
	extends MIDlet
	implements CommandListener {

	private List screen;
	private Command exitCmd;
	private Command detailsCmd;

	public JWhatMidlet() {
		exitCmd = new Command("Exit", Command.EXIT, 1);
		detailsCmd = new Command("Details", Command.ITEM, 2);
		screen = createScreen();
		
		screen.addCommand(exitCmd);
		screen.addCommand(detailsCmd);
		screen.setCommandListener(this);
	}

	public void startApp() {
		Display.getDisplay(this).setCurrent(screen);
	}
	
	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == exitCmd) {
			destroyApp(false);
			notifyDestroyed();
		}
		else if (cmd == detailsCmd) {
			Display.getDisplay(this).setCurrent(new JSR135Screen());
		}
	}
	
	private List createScreen() {
		ProfileSupportFactory psf = ProfileSupportFactory.getInstance();
		Enumeration profiles = psf.createAll();
		List ret = new List("Supported Java profiles", List.IMPLICIT);
		
		while(profiles.hasMoreElements()) {
			ProfileSupport ps = (ProfileSupport)profiles.nextElement();
			String line = ps.getName() + ": v" + ps.getVersion();
			ret.append(line, null);
		}
		
		return ret;
	}
}

