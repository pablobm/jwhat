package com.pablobm.jwhat;

import java.util.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import com.pablobm.jwhat.profiles.*;

public class JWhatMidlet
	extends MIDlet
	implements CommandListener {

	private Screen screen;

	public JWhatMidlet() {
		screen = createScreen();
	}

	public void startApp() {
		Display.getDisplay(this).setCurrent(screen);
	}
	
	public void pauseApp() {}

	public void destroyApp(boolean unconditional) {}

	public void commandAction(Command c, Displayable s) {
		notifyDestroyed();
	}
	
	public Hashtable createPropertiesTable() {
		Hashtable ret = new Hashtable();
		ret.put("JSR-75", "microedition.pim.version");
		ret.put("JSR-120", "wireless.messaging.sms.smsc");
		ret.put("JSR-135", "microedition.media.version");
		
		return ret;
	}
	
	private Screen createScreen() {
		ProfileSupportFactory psf = ProfileSupportFactory.getInstance();
		Enumeration profiles = psf.createAll();
		List ret = new List("Supported Java profiles", List.IMPLICIT);
		
		while(profiles.hasMoreElements()) {
			ProfileSupport ps = (ProfileSupport)profiles.nextElement();
			String line = ps.getName() + ": " + ps.getSummary();
			ret.append(line, null);
		}
		
		return ret;
	}
}

