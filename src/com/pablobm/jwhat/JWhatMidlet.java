package com.pablobm.jwhat;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.profiles.*;

public class JWhatMidlet
	extends MIDlet
	implements CommandListener {

	private Screen screen;
	private Command exitCmd;

	public JWhatMidlet() {
		exitCmd = new Command("Exit", Command.EXIT, 1);
		screen = createScreen();
		
		screen.addCommand(exitCmd);
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
	}
	
	private Screen createScreen() {
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

